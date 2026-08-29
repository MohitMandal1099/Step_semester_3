package week1.assigment_problems;

public class TypingAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatchPosition = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i;
            }
        }

        double accuracy = (matched * 100.0) / original.length();
        String formattedAccuracy = String.format("%.2f", accuracy);

        if (firstMismatchPosition == -1) {
            System.out.println("Matched: " + matched + "/" + original.length() +
                    " | Accuracy: " + formattedAccuracy + "% | No Mismatches");
        } else {
            char originalChar = original.charAt(firstMismatchPosition);
            char typedChar = typed.charAt(firstMismatchPosition);
            System.out.println("Matched: " + matched + "/" + original.length() +
                    " | Accuracy: " + formattedAccuracy + "% | First Mismatch at position " +
                    (firstMismatchPosition + 1) + " ('" + originalChar + "' vs '" + typedChar + "')");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}