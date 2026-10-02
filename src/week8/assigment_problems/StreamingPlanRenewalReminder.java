package week8.assigment_problems;

import java.time.LocalDate;
import java.util.*;

abstract class Plan {
    protected String name;
    protected LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }

    String getName() { return name; }
}

class BasicPlan extends Plan {
    BasicPlan(String name, LocalDate startDate) { super(name, startDate); }
    int getValidityDays() { return 30; }
}

class StandardPlan extends Plan {
    StandardPlan(String name, LocalDate startDate) { super(name, startDate); }
    int getValidityDays() { return 90; }
}

class PremiumPlan extends Plan {
    PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }
    int getValidityDays() { return 365; }
}

public class StreamingPlanRenewalReminder {

    static Plan createPlan(String type, String name, LocalDate startDate) {
        switch (type) {
            case "BASIC": return new BasicPlan(name, startDate);
            case "STANDARD": return new StandardPlan(name, startDate);
            case "PREMIUM": return new PremiumPlan(name, startDate);
            default: throw new IllegalArgumentException("Unknown plan type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Plan> plans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            LocalDate startDate = LocalDate.parse(parts[2]);
            plans.add(createPlan(parts[0], parts[1], startDate));
        }

        for (Plan p : plans) {
            System.out.println(p.getName() + ": " + p.getRenewalDate());
        }
    }
}