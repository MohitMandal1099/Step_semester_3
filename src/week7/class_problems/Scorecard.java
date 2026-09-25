package week7.class_problems;

public class Scorecard {
    private boolean[] results;
    private int recordedCount;
    private final int totalQuestions;

    Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    void recordAnswer(boolean correct) {
        if (recordedCount < totalQuestions) {
            results[recordedCount] = correct;
            recordedCount++;
        }
    }

    int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (results[i]) score++;
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println(sc.getScore());
    }
}