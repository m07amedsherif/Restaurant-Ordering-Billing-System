public interface Observer {
    void update(Order order);
}


class Waiter implements Observer {
    @Override public void update(Order order){
        System.out.println("[Waiter] Please serve order for " + order.getCustomerName() + ". Type: " + order.getType());
    }
}

