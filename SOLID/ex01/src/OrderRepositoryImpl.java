public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public void saveOrder(String customerEmail, double total) {
        System.out.println("Order stored (pretend DB).");
    }
}
