public class ReceiptPrinter {
    public static void printReceipt(Order order) {
        System.out.println("\n--- RECEIPT ---");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: " + order.getCustomerName());
        System.out.println("Order Type: " + order.getType());
        System.out.println("Items:");
        for (MenuItem it : order.getItems()) {
            System.out.println(" - " + it.getName() + " : $" + String.format("%.2f", it.getPrice()));
        }
        System.out.println("-----------------");
        System.out.printf("Subtotal: $%.2f%n", order.subTotal());
        System.out.printf("Discount: -$%.2f%n", order.getDiscount());
        System.out.printf("Tax:      +$%.2f%n", order.subTotal() * order.getTaxRate());
        System.out.printf("Total:    $%.2f%n", order.getTotal());
        System.out.println("--- END ---\n");
    }
}