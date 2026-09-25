package week7.assigment_problems;

public class TrafficLight {
    private String color;
    private final String id;

    TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    String next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
        return color;
    }

    String getColor() {
        return color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println(t.getColor());
        System.out.println(t.next());
        System.out.println(t.next());
        System.out.println(t.next());
    }
}
