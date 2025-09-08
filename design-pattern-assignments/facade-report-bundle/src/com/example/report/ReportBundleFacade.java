package com.example.report;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

public class ReportBundleFacade {
    private final JsonWriter jsonWriter;
    private final Zipper zipper;
    private final AuditLog auditLog;
    
    public ReportBundleFacade() {
        this.jsonWriter = new JsonWriter();
        this.zipper = new Zipper();
        this.auditLog = new AuditLog();
    }
    
    public Path export(Map<String, Object> data, Path outDir, String baseName) {
        // Validate inputs
        Objects.requireNonNull(data, "data cannot be null");
        Objects.requireNonNull(outDir, "outDir cannot be null");
        Objects.requireNonNull(baseName, "baseName cannot be null");
        
        // Orchestrate the three steps: write JSON → zip it → log success
        Path jsonFile = jsonWriter.write(data, outDir, baseName);
        Path zipFile = zipper.zip(jsonFile, outDir.resolve(baseName + ".zip"));
        auditLog.log("exported " + zipFile);
        
        return zipFile;
    }
}
