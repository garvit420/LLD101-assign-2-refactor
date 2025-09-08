package com.example.imports;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader csvReader;
    private final ProfileService profileService;
    
    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.csvReader = Objects.requireNonNull(csvReader, "csvReader");
        this.profileService = Objects.requireNonNull(profileService, "profileService");
    }
    
    @Override
    public int importFrom(Path csvFile) {
        Objects.requireNonNull(csvFile, "csvFile");
        
        List<String[]> rows = csvReader.read(csvFile);
        int successfulImports = 0;
        
        for (int i = 0; i < rows.size(); i++) {
            String[] row = rows.get(i);
            
            // Skip header row if it's the first row and contains "id", "email", "displayName"
            if (i == 0 && isHeaderRow(row)) {
                continue;
            }
            
            if (isValidRow(row)) {
                try {
                    String id = row[0].trim();
                    String email = row[1].trim();
                    String displayName = row.length > 2 ? row[2].trim() : "";
                    
                    profileService.createProfile(id, email, displayName);
                    successfulImports++;
                } catch (Exception e) {
                    System.err.println("Failed to create profile for row " + (i + 1) + ": " + e.getMessage());
                }
            } else {
                System.err.println("Skipping invalid row " + (i + 1) + ": " + getRowDescription(row));
            }
        }
        
        return successfulImports;
    }
    
    private boolean isHeaderRow(String[] row) {
        return row.length >= 2 && 
               "id".equalsIgnoreCase(row[0].trim()) && 
               "email".equalsIgnoreCase(row[1].trim());
    }
    
    private boolean isValidRow(String[] row) {
        // Must have at least id and email columns
        if (row.length < 2) {
            return false;
        }
        
        String id = row[0].trim();
        String email = row[1].trim();
        
        // ID cannot be empty
        if (id.isEmpty()) {
            return false;
        }
        
        // Email cannot be empty and must contain @
        if (email.isEmpty() || !email.contains("@")) {
            return false;
        }
        
        return true;
    }
    
    private String getRowDescription(String[] row) {
        if (row.length == 0) {
            return "empty row";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append("'").append(row[i]).append("'");
        }
        
        if (row.length < 2) {
            sb.append(" (insufficient columns)");
        } else if (row[0].trim().isEmpty()) {
            sb.append(" (missing id)");
        } else if (row[1].trim().isEmpty() || !row[1].trim().contains("@")) {
            sb.append(" (invalid email)");
        }
        
        return sb.toString();
    }
}
