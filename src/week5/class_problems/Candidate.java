package week5.class_problems;

public class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    double compositeScore() {
        return (cgpa * 10) + (codingScore * 0.5);
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.compositeScore(), this.compositeScore());
    }
}