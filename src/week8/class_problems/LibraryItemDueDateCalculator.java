package week8.class_problems;

import java.time.LocalDate;
import java.util.*;

abstract class LibraryItem {
    protected String title;

    LibraryItem(String title) { this.title = title; }

    abstract int getBorrowDays();

    LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(getBorrowDays());
    }

    String getTitle() { return title; }
}

class Book extends LibraryItem {
    Book(String title) { super(title); }
    int getBorrowDays() { return 14; }
}

class Dvd extends LibraryItem {
    Dvd(String title) { super(title); }
    int getBorrowDays() { return 7; }
}

class Magazine extends LibraryItem {
    Magazine(String title) { super(title); }
    int getBorrowDays() { return 3; }
}

public class LibraryItemDueDateCalculator {

    static LibraryItem createItem(String type, String title) {
        switch (type) {
            case "BOOK": return new Book(title);
            case "DVD": return new Dvd(title);
            case "MAGAZINE": return new Magazine(title);
            default: throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1).replace("\"", "").trim();
            items.add(createItem(type, title));
        }

        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.getDueDate(currentDate));
        }
    }
}
