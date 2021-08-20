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
        // returns the sum of all exam averages divided by the number of students.
        double avgExamScoreSum = 0.0;
        for (Student student: students) {
            avgExamScoreSum += student.getAverageExamScore();
        }
        return avgExamScoreSum / students.length;
    }

    public void addStudent(Student student) {
        // adds a student to the students list
    }

    public void removeStudent(String firstName, String lastName) {
        // The class Classroom should define a method which uses a firstName and lastName parameter to identify
        // and remove the respective student from composite students object.
        // Ensure the array is re-ordered after the removal;
        // Null values should be located in the final indices of the array.
    }

    public Student[] getStudentByScore() {
        // which returns an array representation of Student objects sorted in descending order by score.
        //If two students have the same class average, order them lexigraphically.
        Comparator<Student> c = (s1, s2) -> (int) (s1.getAverageExamScore() - s2.getAverageExamScore());
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
