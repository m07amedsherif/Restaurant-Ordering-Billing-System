public interface Payment {
    boolean pay(double amount);
    String getName();
}

class CashPayment implements Payment {
    @Override public boolean pay(double amount){
        System.out.println("Processing cash payment: $" + String.format("%.2f", amount));
        return true;
    }
    @Override public String getName(){ return "Cash"; }
}

class CardPayment implements Payment {
    private final String cardNumber;
    public CardPayment(String cardNumber){ this.cardNumber = cardNumber; }
    @Override public boolean pay(double amount){
        System.out.println("Charging card " + mask(cardNumber) + " for $" + String.format("%.2f", amount));
        return true;
    }
    private String mask(String c){ if (c==null) return "****"; int n=c.length(); return "****" + c.substring(Math.max(0,n-4)); }
    @Override public String getName(){ return "Card"; }
}

class MobileWalletPayment implements Payment {
    private final String walletId;
    public MobileWalletPayment(String walletId){ this.walletId = walletId; }
    @Override public boolean pay(double amount){
        System.out.println("Charging mobile wallet " + walletId + " for $" + String.format("%.2f", amount));
        return true;
    }
    @Override public String getName(){ return "Mobile Wallet"; }
}