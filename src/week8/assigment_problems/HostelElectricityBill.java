package week8.assigment_problems;

import java.util.*;

abstract class Room {
    protected String type;
    protected int units;

    Room(String type, int units) {
        this.type = type;
        this.units = units;
    }

    abstract double calculateBill();

    String getType() { return type; }
}

class SingleRoom extends Room {
    SingleRoom(int units) { super("SINGLE", units); }
    double calculateBill() { return units * 8; }
}

class SharedRoom extends Room {
    private int occupants;

    SharedRoom(int units, int occupants) {
        super("SHARED", units);
        this.occupants = occupants;
    }
    double calculateBill() { return (units * 6.0) / occupants; }
}

class AcRoom extends Room {
    AcRoom(int units) { super("AC", units); }
    double calculateBill() { return units * 10 + 200; }
}

public class HostelElectricityBill {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);

            if (type.equals("SHARED")) {
                rooms.add(new SharedRoom(units, Integer.parseInt(parts[2])));
            } else if (type.equals("SINGLE")) {
                rooms.add(new SingleRoom(units));
            } else {
                rooms.add(new AcRoom(units));
            }
        }

        double total = 0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            System.out.printf("%s: %.2f%n", r.getType(), bill);
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
