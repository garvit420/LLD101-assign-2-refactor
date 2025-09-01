public class Player implements MediaPlayer {
    private final FrameDecoder decoder;
    private final FrameRenderer renderer;
    private final FrameCache cache;
    
    // Constructor injection for dependencies (DIP compliance)
    public Player(FrameDecoder decoder, FrameRenderer renderer, FrameCache cache) {
        this.decoder = decoder;
        this.renderer = renderer;
        this.cache = cache;
    }
    
    @Override
    public void play(byte[] fileBytes) {
        // Single responsibility: only orchestrates the playing process
        Frame frame = decoder.decode(fileBytes);
        renderer.render(frame);
        cache.cache(frame);
        System.out.println("Cached last frame? " + cache.hasCachedFrame());
    }
}