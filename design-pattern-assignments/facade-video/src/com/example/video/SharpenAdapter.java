package com.example.video;

/**
 * Adapter class that adapts the legacy LegacySharpen API to work with Frame arrays.
 * Converts Frame[] to string handles and back to Frame[] to bridge the API gap.
 */
public class SharpenAdapter {
    private LegacySharpen legacySharpen;
    
    public SharpenAdapter() {
        this.legacySharpen = new LegacySharpen();
    }
    
    /**
     * Applies sharpening to frames using the legacy API.
     * @param frames The frames to sharpen
     * @param strength The sharpening strength
     * @return The sharpened frames
     */
    public Frame[] applySharpen(Frame[] frames, int strength) {
        // Convert frames to a handle string for the legacy API
        String framesHandle = convertFramesToHandle(frames);
        
        // Use the legacy API
        String resultHandle = legacySharpen.applySharpen(framesHandle, strength);
        
        // Convert back to frames (in practice, this would involve actual processing)
        return convertHandleToFrames(resultHandle, frames);
    }
    
    /**
     * Converts Frame array to a string handle for legacy API compatibility.
     */
    private String convertFramesToHandle(Frame[] frames) {
        StringBuilder handle = new StringBuilder("FRAMES:");
        for (Frame frame : frames) {
            handle.append(frame.w).append("x").append(frame.h).append(";");
        }
        return handle.toString();
    }
    
    /**
     * Converts string handle back to Frame array.
     * In a real implementation, this would reconstruct the processed frames.
     */
    private Frame[] convertHandleToFrames(String handle, Frame[] originalFrames) {
        // For simulation purposes, return the original frames
        // In practice, this would parse the handle and reconstruct processed frames
        return originalFrames;
    }
}
