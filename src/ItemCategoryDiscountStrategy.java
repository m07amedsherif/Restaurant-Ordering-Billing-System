public class ItemCategoryDiscountStrategy implements DiscountStrategy {
    private final String category;
    private final double discountPercentage;

    public ItemCategoryDiscountStrategy(String category, double discountPercentage) {
        this.category = category;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double applyDiscount(Order order) {
        double discount = 0;
        for (MenuItem item : order.getItems()) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                discount += item.getPrice() * discountPercentage;
            }
        }
        return discount;
    }
}
