package week8.class_problems;

import java.util.*;

abstract class Payment {
    protected String type;
    protected double amount;

    Payment(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    abstract double calculateFee();

    double getAdjustedAmount() {
        return amount + calculateFee();
    }

    String getType() {
        return type;
    }
}

class CardPayment extends Payment {
    CardPayment(double amount) { super("CARD", amount); }
    double calculateFee() { return amount * 0.02; }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) { super("WALLET", amount); }
    double calculateFee() { return amount * 0.01; }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) { super("BANKTRANSFER", amount); }
    double calculateFee() { return 0; }
}

public class PaymentSystemFeeCalculator {

    static Payment createPayment(String type, double amount) {
        switch (type) {
            case "CARD": return new CardPayment(amount);
            case "WALLET": return new WalletPayment(amount);
            case "BANKTRANSFER": return new BankTransferPayment(amount);
            default: throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Payment> payments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            payments.add(createPayment(parts[0], Double.parseDouble(parts[1])));
        }

        double total = 0;
        for (Payment p : payments) {
            double adjusted = p.getAdjustedAmount();
            System.out.printf("%s: %.2f%n", p.getType(), adjusted);
            total += adjusted;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}