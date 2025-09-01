public class VideoFrame extends Frame {
    
    public VideoFrame(byte[] data) {
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
        return "Video";
    }
}

