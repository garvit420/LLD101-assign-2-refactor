public class TaxCalculatorImpl implements TaxCalculator {
    private double taxRate = 0.18; // in beest case I would like to get it dynamically may be form db
    
    public double calculateTax(double subtotal) {
        return subtotal * taxRate;
    }
    
    @Override
    public double calculateTotalWithTax(double subtotal) {
        return subtotal + calculateTax(subtotal);
    }
}
