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
        examScores = new ArrayList<Double>(Arrays.asList(testScores));
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
        // returns a string representation of all exams taken
        // Exam Scores:
        //	Exam 1 -> 100
        //	Exam 2 -> 95
        //	Exam 3 -> 123
        //	Exam 4 -> 96
        StringBuilder examScoreSb = new StringBuilder("Exam Scores: \n\t");
        for (int i = 0; i < examScores.size(); i++) {
            examScoreSb.append("Exam ")
                    .append(i + 1)
                    .append(" -> ")
                    .append(examScores.get(i))
                    .append("\n\t");
        }
        return examScoreSb.toString();
    }

    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

    public void addExamScore(double testScore) {
        // adds an exam score to exam score list
        examScores.add(testScore);
    }

    public void setExamScore(int examNumber, double newScore) {
        // replaces the specified exam score with the new exam score
        if (examNumber >= examScores.size()) {
            throw new IllegalArgumentException("The student hasn't taken that many exams.");
        }
        if (examNumber <= 0) {
            throw new IllegalArgumentException("Number of exam to reset must be 1 or above.");
        }
        examScores.set(examNumber - 1, newScore);
    }

    public double getAverageExamScore() {
        // returns the sum of the examScore list, divided by size
        return -1.0;
    }

    @Override
    public String toString() {
        return "Student Name: " + firstName + " " + lastName + "\n\t"
                + "> Average Score: " + getAverageExamScore() + "\n\t"
                + "> " + getExamScores();
    }
}
