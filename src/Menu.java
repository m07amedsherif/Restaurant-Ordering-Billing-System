import java.util.*;

public interface Menu {
    String getMenuName();
    List<MenuItem> getItems();
}

// ===== Vegetarian Menu =====
class VegetarianMenu implements Menu {
    private final List<MenuItem> items = new ArrayList<>();

    public VegetarianMenu() {
        items.add(new VegSalad());
        items.add(new ItalianPizza());
        items.add(new MargheritaPizza());
        items.add(new GreekSalad());
        items.add(new VeggieBurger());
        items.add(new CaesarSalad());
        items.add(new TunaSalad());
        items.add(new FruitSalad());
    }

    @Override
    public String getMenuName() { return "Vegetarian"; }

    @Override
    public List<MenuItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}

// ===== Non-Vegetarian Menu =====
class NonVegetarianMenu implements Menu {
    private final List<MenuItem> items = new ArrayList<>();

    public NonVegetarianMenu() {
        items.add(new ClassicBurger());
        items.add(new EasternPizza());
        items.add(new ChickenBurger());
        items.add(new PepperoniPizza());
        items.add(new BBQChickenPizza());
        items.add(new DoubleBeefBurger());
        items.add(new CheeseBurger());
    }

    @Override
    public String getMenuName() { return "Non-Vegetarian"; }

    @Override
    public List<MenuItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}

// ===== Kids Menu =====
class KidsMenu implements Menu {
    private final List<MenuItem> items = new ArrayList<>();

    public KidsMenu() {
        items.add(new KidsNuggets());
        items.add(new KidsBurger());
        items.add(new KidsPizza());
        items.add(new KidsMacAndCheese());
        items.add(new KidsHotdog());
    }

    @Override
    public String getMenuName() { return "Kids"; }

    @Override
    public List<MenuItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}
