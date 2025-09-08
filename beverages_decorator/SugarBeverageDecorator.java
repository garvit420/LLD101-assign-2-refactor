package beverages_decorator;

public class SugarBeverageDecorator extends Beverage {
    Beverage b;

    public SugarBeverageDecorator(Beverage b){
        this.b = b;
    }

    @Override
    public int cost() {
        return this.b.cost() + 10;
    }
    
}
