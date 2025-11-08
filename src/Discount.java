public interface Discount {
    double applyDiscount(Order order);
    String getName();
}

class PizzaDiscount implements Discount {
    private final double percent;
    public PizzaDiscount(double percent){ this.percent = percent; }
    @Override public double applyDiscount(Order order){
        double discount = 0.0;
        for (MenuItem it : order.getItems()){
            if ("Pizza".equalsIgnoreCase(it.getCategory())) discount += it.getPrice() * percent;
        }
        return discount;
    }
    @Override public String getName(){ return "PizzaDiscount"; }
}

class ChickenDiscount implements Discount {
    private final double amount;
    public ChickenDiscount(double amount){ this.amount = amount; }
    @Override public double applyDiscount(Order order){
        double d=0.0; for (MenuItem it : order.getItems()){ if ("Chicken".equalsIgnoreCase(it.getCategory())) d+=amount; } return d;
    }
    @Override public String getName(){ return "ChickenDiscount"; }
}