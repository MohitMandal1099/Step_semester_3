package week5.assigment_problems;

public class TopPerformerTracker {

    static String findMinMaxSpread(int[] scores) {
        int min = scores[0];
        int max = scores[0];

        for (int score : scores) {
            if (score < min) min = score;
            if (score > max) max = score;
        }

        return "Min: " + min + " | Max: " + max + " | Spread: " + (max - min);
    }

    public static void main(String[] args) {
        System.out.println(findMinMaxSpread(new int[]{45, 82, 79, 90, 33, 90, 61}));
    }
}