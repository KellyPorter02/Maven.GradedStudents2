package io.zipcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Classroom {

    private Student[] students;

    public Classroom() {
        students = new Student[30];
    }

    public Classroom(int maxNumberOfStudents) {
        students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Student[] getStudents() {
        return students;
    }

    public double getAverageExamScore() {
        double avgExamScoreSum = 0.0;
        for (Student student: students) {
            avgExamScoreSum += student.getAverageExamScore();
        }
        double result = avgExamScoreSum / students.length;
        return roundTo2DecimalPlaces(result);
    }

    double roundTo2DecimalPlaces(double input) {
        return Math.round(input * 100.0) / 100.0;
    }

    public void addStudent(Student studentToAdd) {
        Student[] plusOneArray = Arrays.copyOf(students, students.length + 1);
        plusOneArray[plusOneArray.length - 1] = studentToAdd;
        students = plusOneArray;
    }

    public boolean removeStudent(String firstName, String lastName) {
        int removeIdx = findIndexOfStudentToRemove(firstName, lastName);
        if (removeIdx < 0) {
            return false;
        }
        for (int i = 0; i < students.length; i++) {
            if (i == students.length - 1) {
                students[i] = null;
            }
            if (i >= removeIdx && i < students.length - 1) {
                students[i] = students[i + 1];
            }
        }
        return true;
    }

    int findIndexOfStudentToRemove(String firstName, String lastName) {
        for (int i = 0; i < students.length; i++) {
            if (shouldBeRemoved(firstName, lastName, students[i])) {
                return i;
            }
        }
        return -1;
    }

    boolean shouldBeRemoved(String firstName, String lastName, Student student) {
        return firstName.compareTo(student.getFirstName()) == 0
                && lastName.compareTo(student.getLastName()) == 0;
    }

    public Student[] getStudentByScore() {
        // returns an array representation of Student objects sorted in descending order by score.
        // If two students have the same class average, order them lexicographically.

        Comparator<Student> c = Comparator.comparing(Student::getAverageExamScore).reversed();
        c = c.thenComparing(s -> s.getLastName());
        Arrays.sort(students, c);
        return students;
    }

    public Map<Character, List<Student>> getGradeBook() {
        return null;
    }

    public String gradeBookToString(Map<Character, List<Student>> gradeBook) {
        return "";
    }

    public int calculatePercentile() {
//        this.getAverageExamScore()
        return -1;
    }


}
