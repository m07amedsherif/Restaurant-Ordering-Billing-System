public class TakeawayOrderProcessor extends OrderProcessor {
    @Override
    protected void handleSpecialRequirements(Order order) {
        System.out.println("Packaging order #" + order.getOrderId() + " for takeaway.");
    }
}
