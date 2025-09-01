public class Demo02 {
    public static void main(String[] args) {
        // Demonstrate different configurations (OCP compliance)
        System.out.println("=== Audio Player Demo ===");
        MediaPlayer audioPlayer = new Player(
            new AudioFrameDecoder(),
            new ConsoleFrameRenderer(),
            new SimpleFrameCache()
        );
        audioPlayer.play(new byte[]{1, 2, 3, 4});
        
        System.out.println("\n=== Video Player Demo ===");
        MediaPlayer videoPlayer = new Player(
            new VideoFrameDecoder(),
            new ConsoleFrameRenderer(),
            new SimpleFrameCache()
        );
        videoPlayer.play(new byte[]{5, 6, 7, 8, 9, 10});
    }
}
