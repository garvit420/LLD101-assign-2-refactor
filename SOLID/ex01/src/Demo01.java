

public class Demo01 {
    public static void main(String[] args) {
        // Wire all dependencies - dependency injection
        TaxCalculator taxCalculator = new TaxCalculatorImpl();
        EmailService emailService = new EmailClient();
        OrderNotificationService notificationService = new OrderNotificationServiceImpl(emailService);
        OrderRepository orderRepository = new OrderRepositoryImpl();
        
        // Inject dependencies into OrderService
        OrderService orderService = new OrderService(taxCalculator, notificationService, orderRepository);
        orderService.checkout("a@shop.com", 100.0);
    }
}
