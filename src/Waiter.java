public class Waiter implements Observer {
    @Override
    public void update(Order order) {
        System.out.println("[Waiter] New order #" + order.getOrderId() + " has been placed by " + order.getCustomerName() + ".");
    }
}
