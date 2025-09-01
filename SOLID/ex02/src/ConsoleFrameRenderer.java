public class ConsoleFrameRenderer implements FrameRenderer {
    
    @Override
    public void render(Frame frame) {
        System.out.println("\u25B6 Playing " + frame.getSize() + " bytes (" + frame.getType() + ")");
    }
}

