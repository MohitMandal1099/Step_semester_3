package week7.class_problems;

public class Locker {
    private String code;
    private final int lockerNumber;

    Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    void changeCode(String oldCode, String newCode) {
        if (!oldCode.equals(code)) {
            System.out.println("Change rejected: incorrect current code");
        } else {
            code = newCode;
            System.out.println("Code changed successfully");
        }
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}