public class ReceiptPrinter {
    public static void printReceipt(Order order, double subtotal, double tax, double discount, double total, String paymentMethod){
        System.out.println("\n--- RECEIPT ---");
        System.out.println("Customer: " + order.getCustomerName());
        System.out.println("Order Type: " + order.getType());
        System.out.println("Items:");
        for (MenuItem it : order.getItems()) System.out.println(" - " + it.getName() + " : $" + String.format("%.2f", it.getPrice()));
        System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
        System.out.println("Discount: -$" + String.format("%.2f", discount));
        System.out.println("Tax: $" + String.format("%.2f", tax));
        System.out.println("Total: $" + String.format("%.2f", total));
        System.out.println("Paid via: " + paymentMethod);
        System.out.println("--- END ---\n");
    }
}