public class DeliveryOrderProcessor extends OrderProcessor {
    @Override
    protected void handleSpecialRequirements(Order order) {
        System.out.println("Adding delivery fee and assigning a driver for order #" + order.getOrderId());
    }
}
