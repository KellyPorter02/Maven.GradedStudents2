package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private List<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        examScores = new ArrayList<>(Arrays.asList(testScores));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExamScores() {
        StringBuilder examScoreSb = new StringBuilder("Exam Scores: \n");
        for (int i = 0; i < examScores.size(); i++) {
            examScoreSb.append("\tExam ")
                    .append(i + 1)
                    .append(" -> ")
                    .append(examScores.get(i))
                    .append("\n");
        }
        return examScoreSb.toString();
    }

    public List<Double> getExamScoresList() {
        return examScores;
    }

    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

    public void addExamScore(double testScore) {
        examScores.add(testScore);
    }

    public void setExamScore(int examNumber, double newScore) {
        if (examNumber >= examScores.size()) {
            throw new IllegalArgumentException("The student hasn't taken that many exams.");
        }
        if (examNumber <= 0) {
            throw new IllegalArgumentException("Number of exam to reset must be 1 or above.");
        }
        examScores.set(examNumber - 1, newScore);
    }

    public double getAverageExamScore() {
        if (examScores.size() == 0) {
            return 0.0;
        }
        double scoreSum = 0.0;
        for (Double score: examScores) {
            scoreSum += score;
        }
        return scoreSum / examScores.size();
    }

    @Override
    public String toString() {
        return "Student Name: " + firstName + " " + lastName + "\n\t"
                + "> Average Score: " + getAverageExamScore() + "\n\t"
                + "> "
                + getExamScores();
    }
}
