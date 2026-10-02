package week8.assigment_problems;

import java.util.*;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    abstract double calculateBonus();

    String getName() { return name; }
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double salary) { super(name, salary); }
    double calculateBonus() { return monthlySalary * 0.10; }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double salary) { super(name, salary); }
    double calculateBonus() { return monthlySalary * 0.05; }
}

class Intern extends Employee {
    Intern(String name, double salary) { super(name, salary); }
    double calculateBonus() { return 2000; }
}

public class FestivalBonusCalculator {

    static Employee createEmployee(String type, String name, double salary) {
        switch (type) {
            case "FULLTIME": return new FullTimeEmployee(name, salary);
            case "PARTTIME": return new PartTimeEmployee(name, salary);
            case "INTERN": return new Intern(name, salary);
            default: throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            employees.add(createEmployee(parts[0], parts[1], Double.parseDouble(parts[2])));
        }

        double total = 0;
        for (Employee e : employees) {
            double bonus = e.calculateBonus();
            System.out.printf("%s: %.2f%n", e.getName(), bonus);
            total += bonus;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}