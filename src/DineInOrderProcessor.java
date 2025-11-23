public class DineInOrderProcessor extends OrderProcessor {
    @Override
    protected void handleSpecialRequirements(Order order) {
        System.out.println("Assigning a waiter for dine-in order #" + order.getOrderId());
    }
}
