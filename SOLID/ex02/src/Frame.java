public abstract class Frame {
    protected byte[] data;
    
    protected Frame(byte[] data) {
        this.data = data;
    }
    
    public abstract byte[] getData();
    public abstract int getSize();
    public abstract String getType();
}
