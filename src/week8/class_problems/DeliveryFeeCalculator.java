package week8.class_problems;

import java.util.*;

abstract class Delivery {
    protected String type;
    protected double weight;
    protected double distance;

    Delivery(String type, double weight, double distance) {
        this.type = type;
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();

    String getType() { return type; }
}

class StandardDelivery extends Delivery {
    StandardDelivery(double weight, double distance) { super("STANDARD", weight, distance); }
    double calculateFee() { return 5 + 0.50 * weight + 0.10 * distance; }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double weight, double distance) { super("EXPRESS", weight, distance); }
    double calculateFee() { return 15 + 1.00 * weight + 0.20 * distance; }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        super("INTERNATIONAL", weight, distance);
        this.customsFee = customsFee;
    }
    double calculateFee() { return 25 + 2.00 * weight + 0.50 * distance + customsFee; }
}

public class DeliveryFeeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Delivery> deliveries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double distance = Double.parseDouble(parts[2]);

            if (type.equals("INTERNATIONAL")) {
                deliveries.add(new InternationalDelivery(weight, distance, Double.parseDouble(parts[3])));
            } else if (type.equals("STANDARD")) {
                deliveries.add(new StandardDelivery(weight, distance));
            } else {
                deliveries.add(new ExpressDelivery(weight, distance));
            }
        }

        double total = 0;
        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            System.out.printf("%s: %.2f%n", d.getType(), fee);
            total += fee;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}