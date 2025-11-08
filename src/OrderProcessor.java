public class OrderProcessor {
    private final OrderNotifier notifier;
    private final java.util.List<Discount> discounts = new java.util.ArrayList<>();
    private Payment paymentStrategy;

    public OrderProcessor(OrderNotifier notifier){ this.notifier = notifier; }
    public void addDiscount(Discount d){ discounts.add(d); }
    public void setPaymentStrategy(Payment p){ this.paymentStrategy = p; }

    public void process(Order order){
        double subtotal = order.subTotal();
        double discount = 0.0; for (Discount d : discounts) discount += d.applyDiscount(order);
        double taxable = Math.max(0, subtotal - discount);
        double tax = taxable * order.getTaxRate();
        double total = taxable + tax;

        notifier.notifyObservers(order);

        boolean paid = false;
        if (paymentStrategy != null) paid = paymentStrategy.pay(total);
        else System.out.println("No payment method set. Skipping payment.");

        ReceiptPrinter.printReceipt(order, subtotal, tax, discount, total, paymentStrategy==null?"UNPAID":paymentStrategy.getName());
    }
}