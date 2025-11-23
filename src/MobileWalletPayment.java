public class MobileWalletPayment implements PaymentStrategy {
    private final String walletId;

    public MobileWalletPayment(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " with mobile wallet " + walletId);
    }
}
