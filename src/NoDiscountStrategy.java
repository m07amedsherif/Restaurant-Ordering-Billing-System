public class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(Order order) {
        return 0;
    }
}
