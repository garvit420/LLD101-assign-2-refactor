package beverages_decorator;

public class Client {

	public static void main(String[] args) {
		

		
		Beverage capp = new Cappuccino();
        System.out.println("Cappuccino");
		System.out.println("Cost of simple Cappuccino: " + capp.cost());

		Beverage cappWithSugar = new SugarBeverageDecorator(capp);
		System.out.println("Cost of Cappuccino with sugar: " + cappWithSugar.cost());
		
		Beverage latte = new Latte();
        System.out.println("Latte");
		System.out.println("Cost of simple Latte: " + latte.cost());

		Beverage latteWithChoco = new ChocoBevergaeDecorator(latte);
		System.out.println("Cost of Latte with Choco: " + latteWithChoco.cost());
	}

}