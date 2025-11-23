import java.util.List;
import java.util.Scanner;

public class RestaurantFacade {
    private final Scanner sc = new Scanner(System.in);

    public void startOrdering() {
        MenuFactory factory = selectMenu();
        if (factory == null) {
            System.out.println("Invalid choice. Exiting.");
            return;
        }

        Menu menu = factory.createMenu();
        displayMenu(menu);

        MenuItem selectedItem = selectMenuItem(menu);
        if (selectedItem == null) {
            System.out.println("Invalid item. Exiting.");
            return;
        }

        selectedItem = customizeItem(selectedItem);

        DiscountStrategy discount = selectDiscount();
        OrderType orderType = selectOrderType();

        Order order = new Order.Builder()
                .addItem(selectedItem)
                .customer("Valued Customer")
                .discountStrategy(discount)
                .orderType(orderType)
                .build();

        OrderProcessor processor = createOrderProcessor(orderType);
        processor.process(order);

        processPayment(order);

        System.out.println("Thank you for your order!");
    }

    private MenuFactory selectMenu() {
        System.out.println("=== Welcome to the Restaurant ===");
        System.out.println("Select Menu Type:");
        System.out.println("1. Vegetarian");
        System.out.println("2. Non-Vegetarian");
        System.out.println("3. Kids");
        System.out.print("Enter choice: ");
        int menuChoice = sc.nextInt();

        return switch (menuChoice) {
            case 1 -> new VegetarianFactory();
            case 2 -> new NonVegetarianFactory();
            case 3 -> new KidsFactory();
            default -> null;
        };
    }

    private OrderType selectOrderType() {
        System.out.println("\nSelect Order Type:");
        System.out.println("1. Dine-In");
        System.out.println("2. Delivery");
        System.out.println("3. Takeaway");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        return switch (choice) {
            case 2 -> OrderType.DELIVERY;
            case 3 -> OrderType.TAKEAWAY;
            default -> OrderType.DINE_IN;
        };
    }

    private OrderProcessor createOrderProcessor(OrderType type) {
        return switch (type) {
            case DELIVERY -> new DeliveryOrderProcessor();
            case TAKEAWAY -> new TakeawayOrderProcessor();
            default -> new DineInOrderProcessor();
        };
    }

    private void displayMenu(Menu menu) {
        System.out.println("\n=== " + menu.getMenuName() + " Menu ===");
        List<MenuItem> items = menu.getItems();
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d. %s - $%.2f%n", i + 1, items.get(i).getName(), items.get(i).getPrice());
        }
    }

    private MenuItem selectMenuItem(Menu menu) {
        System.out.print("\nSelect an item: ");
        int itemChoice = sc.nextInt();
        if (itemChoice < 1 || itemChoice > menu.getItems().size()) {
            return null;
        }
        return menu.getItems().get(itemChoice - 1);
    }

    private MenuItem customizeItem(MenuItem selectedItem) {
        System.out.println("\nYou selected: " + selectedItem.getName());
        System.out.printf("Base price: $%.2f%n", selectedItem.getPrice());

        boolean adding = true;
        while (adding) {
            System.out.println("\nAvailable Add-ons:");
            System.out.println("1. Extra Cheese (+$0.75)");
            System.out.println("2. Sauce (+$0.50)");
            System.out.println("3. Extra Toppings (+$1.00)");
            System.out.println("4. Jalapenos (+$0.60)");
            System.out.println("5. Mushrooms (+$0.70)");
            System.out.println("6. Done");
            System.out.print("Choose an add-on: ");
            int addChoice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (addChoice) {
                case 1 -> selectedItem = new ExtraCheese(selectedItem);
                case 2 -> {
                    System.out.print("Enter sauce type (e.g., BBQ, Garlic): ");
                    String sauceName = sc.nextLine();
                    selectedItem = new Sauce(selectedItem, sauceName);
                }
                case 3 -> selectedItem = new ExtraToppings(selectedItem);
                case 4 -> selectedItem = new Jalapenos(selectedItem);
                case 5 -> selectedItem = new Mushrooms(selectedItem);
                case 6 -> adding = false;
                default -> System.out.println("Invalid choice.");
            }
        }
        return selectedItem;
    }

    private DiscountStrategy selectDiscount() {
        System.out.println("\nSelect Discount:");
        System.out.println("1. No Discount");
        System.out.println("2. 10% off Pizza");
        System.out.print("Enter choice: ");
        int discountChoice = sc.nextInt();
        sc.nextLine(); // consume newline

        return switch (discountChoice) {
            case 2 -> new ItemCategoryDiscountStrategy("Pizza", 0.10);
            default -> new NoDiscountStrategy();
        };
    }

    public void processPayment(Order order) {
        System.out.println("\nSelect Payment Method:");
        System.out.println("1. Cash");
        System.out.println("2. Credit Card");
        System.out.println("3. Mobile Wallet");
        System.out.print("Enter choice: ");
        int paymentChoice = sc.nextInt();
        sc.nextLine(); // consume newline

        Payment payment = new Payment();
        switch (paymentChoice) {
            case 1 -> payment.setPaymentStrategy(new CashPayment());
            case 2 -> {
                System.out.print("Enter credit card number: ");
                String cardNumber = sc.nextLine();
                payment.setPaymentStrategy(new CreditCardPayment(cardNumber));
            }
            case 3 -> {
                System.out.print("Enter mobile wallet ID: ");
                String walletId = sc.nextLine();
                payment.setPaymentStrategy(new MobileWalletPayment(walletId));
            }
            default -> {
                System.out.println("Invalid payment method. Defaulting to cash.");
                payment.setPaymentStrategy(new CashPayment());
            }
        }
        payment.pay(order.getTotal());
    }
}
