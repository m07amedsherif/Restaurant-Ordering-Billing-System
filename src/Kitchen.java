public class Kitchen implements Observer {
    @Override
    public void update(Order order) {
        System.out.println("[Kitchen] New order received. Preparing items...");
        for (MenuItem item : order.getItems()) {
            System.out.println("  - " + item.getName());
        }
    }
}
