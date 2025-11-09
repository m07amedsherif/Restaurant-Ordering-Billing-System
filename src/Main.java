import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MenuFactory factory = null;

        System.out.println("=== Welcome to the Restaurant ===");
        System.out.println("Select Menu Type:");
        System.out.println("1. Vegetarian");
        System.out.println("2. Non-Vegetarian");
        System.out.println("3. Kids");
        System.out.print("Enter choice: ");
        int menuChoice = sc.nextInt();

        switch (menuChoice) {
            case 1 -> factory = new VegetarianFactory();
            case 2 -> factory = new NonVegetarianFactory();
            case 3 -> factory = new KidsFactory();
            default -> {
                System.out.println("Invalid choice. Exiting.");
                return;
            }
        }

        Menu menu = factory.createMenu();
        System.out.println("\n=== " + menu.getMenuName() + " Menu ===");
        List<MenuItem> items = menu.getItems();
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d. %s - $%.2f%n", i + 1, items.get(i).getName(), items.get(i).getPrice());
        }

        System.out.print("\nSelect an item: ");
        int itemChoice = sc.nextInt();
        if (itemChoice < 1 || itemChoice > items.size()) {
            System.out.println("Invalid item. Exiting.");
            return;
        }

        MenuItem selectedItem = items.get(itemChoice - 1);
        System.out.println("\nYou selected: " + selectedItem.getName());
        System.out.printf("Base price: $%.2f%n", selectedItem.getPrice());

        // Add-ons
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

        System.out.println("\n=== Order Summary ===");
        System.out.println("Item: " + selectedItem.getName());
        System.out.printf("Total Price: $%.2f%n", selectedItem.getPrice());
        System.out.println("Thank you for your order!");
    }

    private static void printMenu(Menu m){
        System.out.println("-- " + m.getMenuName() + " --");
        for (MenuItem it : m.getItems()) System.out.println(it);
    }
}
