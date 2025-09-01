public class EmailClient implements EmailService {
    @Override
    public void send(String to, String body) {
        System.out.println("[EMAIL to=" + to + "] " + body);
    }
}