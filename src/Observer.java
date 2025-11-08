public interface Observer {
    void update(Order order);
}

class Kitchen implements Observer {
    @Override public void update(Order order){
        System.out.println("[Kitchen] New order received for " + order.getCustomerName() + ". Items: " + order.getItems().size());
    }
}

class Waiter implements Observer {
    @Override public void update(Order order){
        System.out.println("[Waiter] Please serve order for " + order.getCustomerName() + ". Type: " + order.getType());
    }
}

