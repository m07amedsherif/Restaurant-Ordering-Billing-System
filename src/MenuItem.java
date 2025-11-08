public interface MenuItem {
    String getName();
    double getPrice();
    String getCategory();
}

abstract class BaseMenuItem implements MenuItem {
    private final String name;
    private final double price;
    private final String category;

    protected BaseMenuItem(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override public String getName() { return name; }
    @Override public double getPrice() { return price; }
    @Override public String getCategory() { return category; }
    @Override public String toString() { return name + " (" + category + ") - $" + price; }
}

// ===== Pizza Items =====
class ItalianPizza extends BaseMenuItem {
    public ItalianPizza() { super("Italian Pizza", 9.50, "Pizza"); }
}

class EasternPizza extends BaseMenuItem {
    public EasternPizza() { super("Eastern Pizza", 8.75, "Pizza"); }
}

class MargheritaPizza extends BaseMenuItem {
    public MargheritaPizza() { super("Margherita Pizza", 8.25, "Pizza"); }
}

class PepperoniPizza extends BaseMenuItem {
    public PepperoniPizza() { super("Pepperoni Pizza", 9.00, "Pizza"); }
}

class BBQChickenPizza extends BaseMenuItem {
    public BBQChickenPizza() { super("BBQ Chicken Pizza", 10.00, "Pizza"); }
}


// ===== Burger Items =====
class ClassicBurger extends BaseMenuItem {
    public ClassicBurger() { super("Classic Burger", 7.25, "Burger"); }
}

class CheeseBurger extends BaseMenuItem {
    public CheeseBurger() { super("Cheese Burger", 7.75, "Burger"); }
}

class ChickenBurger extends BaseMenuItem {
    public ChickenBurger() { super("Chicken Burger", 8.00, "Burger"); }
}

class DoubleBeefBurger extends BaseMenuItem {
    public DoubleBeefBurger() { super("Double Beef Burger", 9.25, "Burger"); }
}

class VeggieBurger extends BaseMenuItem {
    public VeggieBurger() { super("Veggie Burger", 7.00, "Burger"); }
}


// ===== Salad Items =====
class VegSalad extends BaseMenuItem {
    public VegSalad() { super("Veg Salad", 5.00, "Salad"); }
}

class GreekSalad extends BaseMenuItem {
    public GreekSalad() { super("Greek Salad", 5.50, "Salad"); }
}

class CaesarSalad extends BaseMenuItem {
    public CaesarSalad() { super("Caesar Salad", 6.00, "Salad"); }
}

class TunaSalad extends BaseMenuItem {
    public TunaSalad() { super("Tuna Salad", 6.25, "Salad"); }
}

class FruitSalad extends BaseMenuItem {
    public FruitSalad() { super("Fruit Salad", 4.75, "Salad"); }
}


// ===== Kids Menu Items =====
class KidsNuggets extends BaseMenuItem {
    public KidsNuggets() { super("Kids Nuggets", 4.00, "Kids"); }
}

class KidsBurger extends BaseMenuItem {
    public KidsBurger() { super("Kids Burger", 4.25, "Kids"); }
}

class KidsPizza extends BaseMenuItem {
    public KidsPizza() { super("Kids Pizza", 4.50, "Kids"); }
}

class KidsMacAndCheese extends BaseMenuItem {
    public KidsMacAndCheese() { super("Kids Mac & Cheese", 4.00, "Kids"); }
}

class KidsHotdog extends BaseMenuItem {
    public KidsHotdog() { super("Kids Hotdog", 4.25, "Kids"); }
}
