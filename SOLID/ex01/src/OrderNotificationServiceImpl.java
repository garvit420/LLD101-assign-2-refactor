public class OrderNotificationServiceImpl implements OrderNotificationService {
    private EmailService emailService;
    
    // Constructor injection for EmailService
    public OrderNotificationServiceImpl(EmailService emailService) {
        this.emailService = emailService;
    }
    
    @Override
    public void sendOrderConfirmation(String customerEmail, double total) {
        emailService.send(customerEmail, "Thanks! Your total is " + total);
    }
}
