public abstract class AddOn implements MenuItem {
    protected final MenuItem item;
    protected final String addonName;
    protected final double addonPrice;

    protected AddOn(MenuItem item, String addonName, double addonPrice) {
        this.item = item;
        this.addonName = addonName;
        this.addonPrice = addonPrice;
    }

    @Override public String getName() { return item.getName() + " + " + addonName; }
    @Override public double getPrice() { return item.getPrice() + addonPrice; }
    @Override public String getCategory() { return item.getCategory(); }
}

// ===== Add-ons =====
class ExtraCheese extends AddOn {
    public ExtraCheese(MenuItem item) { super(item, "Extra Cheese", 0.75); }
}

class Sauce extends AddOn {
    public Sauce(MenuItem item, String sauceName) { super(item, sauceName + " Sauce", 0.50); }
}

class ExtraToppings extends AddOn {
    public ExtraToppings(MenuItem item) { super(item, "Extra Toppings", 1.00); }
}

class Jalapenos extends AddOn {
    public Jalapenos(MenuItem item) { super(item, "Jalapenos", 0.60); }
}

class Mushrooms extends AddOn {
    public Mushrooms(MenuItem item) { super(item, "Mushrooms", 0.70); }
}




