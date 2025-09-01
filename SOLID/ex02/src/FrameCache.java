public interface FrameCache {
    void cache(Frame frame);
    Frame getLastCached();
    boolean hasCachedFrame();
}

