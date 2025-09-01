public class AudioFrame extends Frame {
    
    public AudioFrame(byte[] data) {
        super(data);
    }
    
    @Override
    public byte[] getData() {
        return data;
    }
    
    @Override
    public int getSize() {
        return data.length;
    }
    
    @Override
    public String getType() {
        return "Audio";
    }
}

