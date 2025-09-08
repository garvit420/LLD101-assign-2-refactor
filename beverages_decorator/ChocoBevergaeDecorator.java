package beverages_decorator;

public class ChocoBevergaeDecorator extends Beverage {
    Beverage b;

    public ChocoBevergaeDecorator(Beverage b){
        this.b = b;
    }

    @Override
    public int cost() {
        return this.b.cost() + 20;
    }
    
}
