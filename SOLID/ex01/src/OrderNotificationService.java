public interface OrderNotificationService {
    void sendOrderConfirmation(String customerEmail, double total);
}
