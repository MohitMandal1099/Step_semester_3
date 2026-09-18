package week5.class_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlacementDriveShortlistingRankingEngine {

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    static String shortlistAndRank(Candidate[] candidates) {
        List<Candidate> shortlisted = new ArrayList<>();

        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                shortlisted.add(c);
            }
        }

        Candidate[] ranked = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(ranked);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ranked.length; i++) {
            if (i > 0) result.append(" | ");
            result.append(i + 1).append(". ").append(ranked[i].name)
                    .append(" (").append(String.format("%.1f", ranked[i].compositeScore())).append(")");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}