package io.zipcoder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClassroomTest {

    Student student1;
    Student student2;
    Student student3;
    Student student4;
    Student student5;
    Student student6;
    Student student7;
    Student student8;
    Student student9;
    Student student10;
    Classroom testClass;


    @Before
    public void setUp() {
        Double[] s1 = {55.0, 65.0, 70.0};
        Double[] s2 = {45.0, 25.0, 99.0};
        Double[] s3 = {100.0, 25.0, 35.0};
        Double[] s4 = {95.0, 65.0, 75.0};
        Double[] s5 = {65.0, 65.0, 45.0};
        Double[] s6 = {75.0, 60.0, 50.0};
        Double[] s7 = {25.0, 75.0, 90.0};
        Double[] s8 = {50.0, 67.0, 85.0};
        Double[] s9 = {88.0, 98.0, 65.0};
        Double[] s10 = {75.0, 98.0, 45.0};
        student1 = new Student("A", "A", s1);
        student2 = new Student("B", "B", s2);
        student3 = new Student("C", "C", s3);
        student4 = new Student("D", "D", s4);
        student5 = new Student("E", "E", s5);
        student6 = new Student("F", "F", s6);
        student7 = new Student("G", "G", s7);
        student8 = new Student("H", "H", s8);
        student9 = new Student("I", "I", s9);
        student10 = new Student("J", "J", s10);
        Student[] groupStudents = {student1, student2, student3, student4, student5,
                student6, student7, student8, student9, student10};
        testClass = new Classroom(groupStudents);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getStudents() {
        for (Student student: testClass.getStudents()) {
            System.out.println(student.getAverageExamScore());
        }
        Student[] returnedSortedStudents = testClass.getStudentByScore();
        for (Student student: returnedSortedStudents) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void getAverageExamScore() {
    }

    @Test
    public void addStudent() {
    }

    @Test
    public void removeStudent() {
    }

    @Test
    public void getStudentByScore() {
    }

    @Test
    public void getGradeBook() {
    }

    @Test
    public void gradeBookToString() {
    }

    @Test
    public void calculatePercentile() {
    }
}
