/*
Refactored Project: Restaurant Ordering System
Language: Java
Structure: Each file contains interface + its implementations or parent + child classes
*/

public class Main {
    public static void main(String[] args){
        MenuFactory vegF = new VegetarianFactory();
        MenuFactory nonVegF = new NonVegetarianFactory();
        MenuFactory kidsF = new KidsFactory();

        printMenu(vegF.createMenu());
        printMenu(nonVegF.createMenu());
        printMenu(kidsF.createMenu());

        Order.Builder builder = new Order.Builder();
        builder.customer("Mohamed Sherif").orderType(OrderType.DELIVERY);

        MenuItem item1 = new ExtraCheese(new Sauce(new ItalianPizza(), "Garlic"));
        MenuItem item2 = new ClassicBurger();
        MenuItem item3 = new KidsNuggets();

        builder.addItem(item1).addItem(item2).addItem(item3);
        Order order = builder.build();

        OrderNotifier notifier = new OrderNotifier();
        notifier.register(new Kitchen());
        notifier.register(new Waiter());

        OrderProcessor processor = new OrderProcessor(notifier);
        processor.addDiscount(new PizzaDiscount(0.10));
        processor.addDiscount(new ChickenDiscount(0.50));
        processor.setPaymentStrategy(new CardPayment("1234567812345678"));

        processor.process(order);
    }

    private static void printMenu(Menu m){
        System.out.println("-- " + m.getMenuName() + " --");
        for (MenuItem it : m.getItems()) System.out.println(it);
    }
}
