public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers(Order order);
}

class OrderNotifier implements Subject {
    private final java.util.List<Observer> observers = new java.util.ArrayList<>();
    @Override public void register(Observer o){ observers.add(o); }
    @Override public void unregister(Observer o){ observers.remove(o); }
    @Override public void notifyObservers(Order order){ for (Observer o : observers) o.update(order); }
}
