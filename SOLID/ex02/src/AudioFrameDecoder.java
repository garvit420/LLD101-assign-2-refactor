public class AudioFrameDecoder implements FrameDecoder {
    
    @Override
    public Frame decode(byte[] data) {
        // Simulate audio decoding logic
        return new AudioFrame(data);
    }
}

