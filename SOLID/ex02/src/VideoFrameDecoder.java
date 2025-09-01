public class VideoFrameDecoder implements FrameDecoder {
    
    @Override
    public Frame decode(byte[] data) {
        // Simulate video decoding logic
        return new VideoFrame(data);
    }
}

