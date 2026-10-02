package week8.assigment_problems;

import java.util.*;

abstract class Vehicle {
    protected String type;
    protected int hours;

    Vehicle(String type, int hours) {
        this.type = type;
        this.hours = hours;
    }

    abstract double calculateCharge();

    String getType() { return type; }
}

class Bike extends Vehicle {
    Bike(int hours) { super("BIKE", hours); }
    double calculateCharge() { return hours * 10; }
}

class Car extends Vehicle {
    Car(int hours) { super("CAR", hours); }
    double calculateCharge() {
        if (hours <= 1) return 30;
        return 30 + (hours - 1) * 20;
    }
}

class Truck extends Vehicle {
    Truck(int hours) { super("TRUCK", hours); }
    double calculateCharge() { return Math.max(hours * 50, 100); }
}

public class CampusParkingChargeCalculator {

    static Vehicle createVehicle(String type, int hours) {
        switch (type) {
            case "BIKE": return new Bike(hours);
            case "CAR": return new Car(hours);
            case "TRUCK": return new Truck(hours);
            default: throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            vehicles.add(createVehicle(parts[0], Integer.parseInt(parts[1])));
        }

        double total = 0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            System.out.printf("%s: %.2f%n", v.getType(), charge);
            total += charge;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}