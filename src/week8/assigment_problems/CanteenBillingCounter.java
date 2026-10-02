package week8.assigment_problems;

import java.util.*;

abstract class Customer {
    protected String type;
    protected double billAmount;

    Customer(String type, double billAmount) {
        this.type = type;
        this.billAmount = billAmount;
    }

    abstract double calculateFinalAmount();

    String getType() { return type; }
}

class Student extends Customer {
    Student(double billAmount) { super("STUDENT", billAmount); }
    double calculateFinalAmount() { return billAmount * 0.90; }
}

class Staff extends Customer {
    Staff(double billAmount) { super("STAFF", billAmount); }
    double calculateFinalAmount() { return billAmount * 0.95; }
}

class Guest extends Customer {
    Guest(double billAmount) { super("GUEST", billAmount); }
    double calculateFinalAmount() { return billAmount + 10; }
}

public class CanteenBillingCounter {

    static Customer createCustomer(String type, double amount) {
        switch (type) {
            case "STUDENT": return new Student(amount);
            case "STAFF": return new Staff(amount);
            case "GUEST": return new Guest(amount);
            default: throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            customers.add(createCustomer(parts[0], Double.parseDouble(parts[1])));
        }

        double total = 0;
        for (Customer c : customers) {
            double finalAmount = c.calculateFinalAmount();
            System.out.printf("%s: %.2f%n", c.getType(), finalAmount);
            total += finalAmount;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}