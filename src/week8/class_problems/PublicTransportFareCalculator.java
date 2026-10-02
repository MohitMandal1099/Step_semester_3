package week8.class_problems;

import java.util.*;

abstract class Transport {
    protected String type;
    protected double distance;

    Transport(String type, double distance) {
        this.type = type;
        this.distance = distance;
    }

    abstract double calculateFare();

    String getType() { return type; }
}

class Bus extends Transport {
    Bus(double distance) { super("BUS", distance); }
    double calculateFare() { return Math.min(2 + 0.10 * distance, 10); }
}

class Train extends Transport {
    Train(double distance) { super("TRAIN", distance); }
    double calculateFare() { return 3 + 0.15 * distance; }
}

class Metro extends Transport {
    private double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super("METRO", distance);
        this.peakHourFactor = peakHourFactor;
    }
    double calculateFare() { return (1.50 + 0.20 * distance) * peakHourFactor; }
}

public class PublicTransportFareCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Transport> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);

            if (type.equals("METRO")) {
                journeys.add(new Metro(distance, Double.parseDouble(parts[2])));
            } else if (type.equals("BUS")) {
                journeys.add(new Bus(distance));
            } else {
                journeys.add(new Train(distance));
            }
        }

        double total = 0;
        for (Transport t : journeys) {
            double fare = t.calculateFare();
            System.out.printf("%s: %.2f%n", t.getType(), fare);
            total += fare;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
