import java.util.*;

public class Order {
    private final List<MenuItem> items;
    private final OrderType type;
    private final String customerName;
    private final double taxRate;

    private Order(Builder b){ this.items = Collections.unmodifiableList(new ArrayList<>(b.items)); this.type = b.type; this.customerName = b.customerName; this.taxRate = b.taxRate; }

    public List<MenuItem> getItems(){ return items; }
    public OrderType getType(){ return type; }
    public String getCustomerName(){ return customerName; }
    public double getTaxRate(){ return taxRate; }

    public double subTotal(){ double s=0; for (MenuItem i: items) s+=i.getPrice(); return s; }

    public static class Builder {
        private final List<MenuItem> items = new ArrayList<>();
        private OrderType type = OrderType.DINE_IN;
        private String customerName = "Guest";
        private double taxRate = 0.14;

        public Builder addItem(MenuItem item){ items.add(item); return this; }
        public Builder orderType(OrderType t){ this.type = t; return this; }
        public Builder customer(String name){ this.customerName = name; return this; }
        public Builder taxRate(double r){ this.taxRate = r; return this; }
        public Order build(){ return new Order(this); }
    }
}