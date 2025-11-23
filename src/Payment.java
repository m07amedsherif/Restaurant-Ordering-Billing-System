public class Payment {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Payment strategy not set.");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

interface PaymentStrategy {
    void pay(double amount);
}

class CashPayment implements PaymentStrategy {
    @Override public void pay(double amount){
        System.out.println("Processing cash payment: $" + String.format("%.2f", amount));
    }
}

class CardPayment implements PaymentStrategy {
    private final String cardNumber;
    public CardPayment(String cardNumber){ this.cardNumber = cardNumber; }
    @Override public void pay(double amount){
        System.out.println("Charging card " + mask(cardNumber) + " for $" + String.format("%.2f", amount));
    }
    private String mask(String c){ if (c==null) return "****"; int n=c.length(); return "****" + c.substring(Math.max(0,n-4)); }
}

class MobileWalletPayment implements PaymentStrategy {
    private final String walletId;
    public MobileWalletPayment(String walletId){ this.walletId = walletId; }
    @Override public void pay(double amount){
        System.out.println("Charging mobile wallet " + walletId + " for $" + String.format("%.2f", amount));
    }
}