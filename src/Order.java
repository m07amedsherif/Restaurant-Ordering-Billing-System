import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order extends Subject {
    private static int orderIdCounter = 1;
    private final int orderId;
    private final List<MenuItem> items;
    private final OrderType type;
    private final String customerName;
    private final double taxRate;
    private DiscountStrategy discountStrategy;

    private Order(Builder b) {
        this.orderId = orderIdCounter++;
        this.items = Collections.unmodifiableList(new ArrayList<>(b.items));
        this.type = b.type;
        this.customerName = b.customerName;
        this.taxRate = b.taxRate;
        this.discountStrategy = b.discountStrategy;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public OrderType getType() {
        return type;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double subTotal() {
        double s = 0;
        for (MenuItem i : items) {
            s += i.getPrice();
        }
        return s;
    }

    public double getDiscount() {
        double discount = 0;
        if (discountStrategy != null) {
            discount = discountStrategy.applyDiscount(this);
        }
        return discount;
    }

    public double getTotal() {
        double subtotal = subTotal();
        double discount = getDiscount();
        return subtotal - discount + (subtotal * taxRate);
    }

    public void placeOrder() {
        notifyObservers(this);
    }

    public static class Builder {
        private final List<MenuItem> items = new ArrayList<>();
        private OrderType type = OrderType.DINE_IN;
        private String customerName = "Guest";
        private double taxRate = 0.14;
        private DiscountStrategy discountStrategy = new NoDiscountStrategy();

        public Builder addItem(MenuItem item) {
            items.add(item);
            return this;
        }

        public Builder orderType(OrderType t) {
            this.type = t;
            return this;
        }

        public Builder customer(String name) {
            this.customerName = name;
            return this;
        }

        public Builder taxRate(double r) {
            this.taxRate = r;
            return this;
        }

        public Builder discountStrategy(DiscountStrategy ds) {
            this.discountStrategy = ds;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}