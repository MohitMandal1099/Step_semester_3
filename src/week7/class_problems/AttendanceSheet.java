package week7.class_problems;

public class AttendanceSheet {
    private String[] presentStudents;
    private int count;

    AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.count = 0;
    }

    void markPresent(String name) {
        if (!isPresent(name)) {
            presentStudents[count] = name;
            count++;
        }
    }

    int getPresentCount() {
        return count;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println(sheet.getPresentCount());
        System.out.println(sheet.isPresent("Ben"));
    }
}