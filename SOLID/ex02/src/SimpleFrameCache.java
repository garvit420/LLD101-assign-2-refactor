public class SimpleFrameCache implements FrameCache {
    private Frame lastCached;
    
    @Override
    public void cache(Frame frame) {
        this.lastCached = frame;
    }
    
    @Override
    public Frame getLastCached() {
        return lastCached;
    }
    
    @Override
    public boolean hasCachedFrame() {
        return lastCached != null;
    }
}

