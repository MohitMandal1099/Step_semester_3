package week5.class_problems;

import java.util.Arrays;

public class HackathonScoreCurveBooster {

    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
        System.out.println(Arrays.toString(scores));
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        curveScores(scores, 10);
    }
}