public class OrderService {
    private TaxCalculator taxCalculator;
    private OrderNotificationService notificationService;
    private OrderRepository orderRepository;
    
    // Constructor injection - dependencies are injected from outside
    public OrderService(TaxCalculator taxCalculator, 
                       OrderNotificationService notificationService, 
                       OrderRepository orderRepository) {
        this.taxCalculator = taxCalculator;
        this.notificationService = notificationService;
        this.orderRepository = orderRepository;
    }
    
    public void checkout(String customerEmail, double subtotal) {
        double total = taxCalculator.calculateTotalWithTax(subtotal);
        notificationService.sendOrderConfirmation(customerEmail, total);
        orderRepository.saveOrder(customerEmail, total);
    }
}