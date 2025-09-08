package com.example.video;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        VideoPipelineFacade facade = new VideoPipelineFacade();
        
        // Process video with grayscale, scaling, and sharpening
        Path out = facade.process(
            Path.of("in.mp4"),      // source file
            Path.of("out.mp4"),     // output file
            true,                   // apply grayscale
            0.5,                    // scale factor
            3                       // sharpen strength
        );
        
        System.out.println("Wrote " + out);
    }
}
