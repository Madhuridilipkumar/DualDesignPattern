package composite;

public class BuildOrder {

    public static Component getOrder()
    {
    	Composite order = new Composite("Order") ;
    	
    	order.addChild(new Leaf("Crispy Onion Strings", 5.50 ));
        order.addChild(new Leaf("The Purist", 8.00 ));
    	
    	CustomBurger customBurger = new CustomBurger( "Build Your Own Burger") ;
    	
    	Burger burger = new Burger("Choose a burger");
    	String[] b = {"Beef","1/3lb","On A Bun"};
    	burger.setOptions(b);
    	
    	Cheese cheese = new Cheese("Choose a Cheese");
    	String[] c = {"Danish Blue Cheese","Horseradish Cheddar"};
    	cheese.setOptions(c);
    	cheese.wrapDecorator(burger);
    	
    	Toppings toppings = new Toppings("Choose upto 4 Toppings, Extra toppings is chargable");
    	String[] t = {"Bermuda Red Onions","Black Olives","Carrot Strings","Coleslaw"};
    	toppings.setOptions(t);
    	toppings.wrapDecorator(cheese);
    	
    	Premium premiumToppings = new Premium("Choose Premium Toppings");
    	String[] pt = {"Applewood Smoked Becon"};
    	premiumToppings.setOptions(pt);
    	premiumToppings.wrapDecorator(toppings);
    	
    	Sauce sauce = new Sauce("Choose a Sauce");
    	String[] s = {"Appricot Sauce"};
    	sauce.setOptions(s);
    	sauce.wrapDecorator(premiumToppings);
        
    	customBurger.setDecorator( sauce ) ;
        customBurger.addChild(burger);
        customBurger.addChild(cheese);
        customBurger.addChild(toppings);
        customBurger.addChild(premiumToppings);
        customBurger.addChild(sauce);
        order.addChild( customBurger );
        
        return order ;
    }

}
