package week7.assigment_problems;

public class Character {
    private int health;
    private final int maxHealth;

    Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    void takeDamage(int amount) {
        int newHealth = health - amount;
        health = Math.max(newHealth, 0);
    }

    void heal(int amount) {
        int newHealth = health + amount;
        health = Math.min(newHealth, maxHealth);
    }

    int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("health = " + c.getHealth());
        c.heal(50);
        System.out.println("health = " + c.getHealth());
        c.takeDamage(150);
        System.out.println("health = " + c.getHealth());
    }
}