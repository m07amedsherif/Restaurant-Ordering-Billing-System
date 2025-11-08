public interface MenuFactory {
    Menu createMenu();
}

class VegetarianFactory implements MenuFactory {
    @Override public Menu createMenu(){ return new VegetarianMenu(); }
}

class NonVegetarianFactory implements MenuFactory {
    @Override public Menu createMenu(){ return new NonVegetarianMenu(); }
}

class KidsFactory implements MenuFactory {
    @Override public Menu createMenu(){ return new KidsMenu(); }
}