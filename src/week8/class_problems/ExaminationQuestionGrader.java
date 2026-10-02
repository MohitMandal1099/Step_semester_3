package week8.class_problems;

import java.util.*;
import java.util.regex.*;

abstract class Question {
    protected String type;
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    Question(String type, String correctAnswer, String studentAnswer, int points) {
        this.type = type;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();

    String getType() { return type; }
}

class McqQuestion extends Question {
    McqQuestion(String correctAnswer, String studentAnswer, int points) {
        super("MCQ", correctAnswer, studentAnswer, points);
    }
    double calculateScore() { return correctAnswer.equals(studentAnswer) ? points : 0; }
}

class TfQuestion extends Question {
    TfQuestion(String correctAnswer, String studentAnswer, int points) {
        super("TF", correctAnswer, studentAnswer, points);
    }
    double calculateScore() { return correctAnswer.equals(studentAnswer) ? points : 0; }
}

class EssayQuestion extends Question {
    EssayQuestion(String correctAnswer, String studentAnswer, int points) {
        super("ESSAY", correctAnswer, studentAnswer, points);
    }
    double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int matches = 0;
        String lowerStudentAnswer = studentAnswer.toLowerCase();

        for (String keyword : keywords) {
            if (lowerStudentAnswer.contains(keyword.trim().toLowerCase())) {
                matches++;
            }
        }

        if (matches >= 2) return points * 0.75;
        if (matches == 1) return points * 0.50;
        return 0;
    }
}

public class ExaminationQuestionGrader {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Question> questions = new ArrayList<>();

        Pattern pattern = Pattern.compile("^(\\S+)\\s+\"[^\"]*\"\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+)$");

        for (int i = 0; i < n; i++) {
            Matcher m = pattern.matcher(sc.nextLine().trim());
            if (m.matches()) {
                String type = m.group(1);
                String correctAnswer = m.group(2);
                String studentAnswer = m.group(3);
                int points = Integer.parseInt(m.group(4));

                switch (type) {
                    case "MCQ": questions.add(new McqQuestion(correctAnswer, studentAnswer, points)); break;
                    case "TF": questions.add(new TfQuestion(correctAnswer, studentAnswer, points)); break;
                    case "ESSAY": questions.add(new EssayQuestion(correctAnswer, studentAnswer, points)); break;
                }
            }
        }

        double total = 0;
        for (Question q : questions) {
            double score = q.calculateScore();
            System.out.printf("%s: %.2f%n", q.getType(), score);
            total += score;
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}