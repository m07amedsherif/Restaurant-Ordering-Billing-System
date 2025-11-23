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





