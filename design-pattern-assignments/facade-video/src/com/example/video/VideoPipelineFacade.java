package com.example.video;

import java.nio.file.Path;

/**
 * Facade class that simplifies the video processing pipeline.
 * Coordinates the subsystems (Decoder, FilterEngine, Encoder) and the SharpenAdapter
 * to provide a single, easy-to-use interface for video processing.
 */
public class VideoPipelineFacade {
    private Decoder decoder;
    private FilterEngine filterEngine;
    private Encoder encoder;
    private SharpenAdapter sharpenAdapter;
    
    public VideoPipelineFacade() {
        this.decoder = new Decoder();
        this.filterEngine = new FilterEngine();
        this.encoder = new Encoder();
        this.sharpenAdapter = new SharpenAdapter();
    }
    
    /**
     * Processes a video file through the complete pipeline.
     * 
     * @param src The source video file path
     * @param out The output video file path
     * @param gray Whether to apply grayscale filter
     * @param scale Scale factor (null to skip scaling)
     * @param sharpenStrength Sharpening strength (null to skip sharpening)
     * @return The path to the processed video file
     */
    public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {
        // Step 1: Decode the input video
        Frame[] frames = decoder.decode(src);
        
        // Step 2: Apply grayscale filter if requested
        if (gray) {
            frames = filterEngine.grayscale(frames);
        }
        
        // Step 3: Apply scaling if requested
        if (scale != null) {
            frames = filterEngine.scale(frames, scale);
        }
        
        // Step 4: Apply sharpening if requested
        if (sharpenStrength != null) {
            frames = sharpenAdapter.applySharpen(frames, sharpenStrength);
        }
        
        // Step 5: Encode the final frames
        return encoder.encode(frames, out);
    }
}
