package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * FAULTY "Singleton": public constructor, getInstance() returns a NEW instance each time,
 * not thread-safe, reload allowed anytime, mutable global state, reflection+serialization-friendly.
 */
public class AppSettings implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // Volatile ensures visibility across threads
    private static volatile AppSettings instance;
    private final Properties props = new Properties();
    
    // Flag to prevent reflection-based construction after first instance
    private static volatile boolean instanceCreated = false;

    // Private constructor prevents external instantiation
    private AppSettings() {
        // Protection against reflection-based construction
        synchronized (AppSettings.class) {
            if (instanceCreated) {
                throw new IllegalStateException("Cannot create instance using reflection - use getInstance() instead");
            }
            instanceCreated = true;
        }
    }

    public static AppSettings getInstance() {
        if (instance == null) {
            synchronized (AppSettings.class) {
                if (instance == null) {
                    instance = new AppSettings();
                }
            }
        }
        return instance;
    }

    // Preserve singleton property during deserialization
    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }

    public void loadFromFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }
}
