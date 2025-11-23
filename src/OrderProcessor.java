public abstract class OrderProcessor {

    // Template method
    public final void process(Order order) {
        // Step 1: Calculate costs
        calculateTotals(order);

        // Step 2: Apply order-specific actions
        handleSpecialRequirements(order);

        // Step 3: Process payment
        processPayment(order);

        // Step 4: Generate receipt
        generateReceipt(order);

        // Step 5: Notify observers
        notifySystems(order);
    }

    protected void calculateTotals(Order order) {
        System.out.printf("Subtotal: $%.2f%n", order.subTotal());
        System.out.printf("Discount: -$%.2f%n", order.getDiscount());
        System.out.printf("Tax: +$%.2f%n", order.subTotal() * order.getTaxRate());
        System.out.printf("Total: $%.2f%n", order.getTotal());
    }

    // This is a "hook" method that can be overridden by subclasses
    protected void handleSpecialRequirements(Order order) {
        // No special requirements by default
    }

    protected void processPayment(Order order) {
        // Default payment processing
        System.out.println("Processing payment...");
        // In a real system, this would interact with a payment gateway
    }

    protected void generateReceipt(Order order) {
        ReceiptPrinter.printReceipt(order);
    }

    protected void notifySystems(Order order) {
        order.placeOrder();
    }
}