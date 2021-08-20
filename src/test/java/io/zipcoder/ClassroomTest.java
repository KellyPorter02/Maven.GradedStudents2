package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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
    Classroom threeStudentsCR;

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
        Student[] threeStudentsArr = {student1, student4, student9};
        threeStudentsCR = new Classroom(threeStudentsArr);
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
    public void getStudentsTest() {
        Student[] expected = {student1, student2, student3, student4, student5,
            student6, student7, student8, student9, student10};
        Student[] returned = testClass.getStudents();
        Assert.assertArrayEquals(expected, returned);
    }

    @Test
    public void getAverageExamScore_tenStudents() {
        double expected = 65.83;
        double returned = testClass.getAverageExamScore();
        Assert.assertEquals(expected, returned, 0.0000001);
    }

    @Test
    public void getAverageExamScore_threeStudents() {
        double expected = 75.11;
        double returned = threeStudentsCR.getAverageExamScore();
        Assert.assertEquals(expected, returned, 0.0000001);
    }

    @Test
    public void roundTo2DecimalPlaces_roundUp() {
        double input = 543.655;
        double expected = 543.66;
        double returned = testClass.roundTo2DecimalPlaces(input);
        Assert.assertEquals(expected, returned, .001);
    }

    @Test
    public void roundTo2DecimalPlaces_roundDown() {
        double input = 543.650;
        double expected = 543.65;
        double returned = testClass.roundTo2DecimalPlaces(input);
        Assert.assertEquals(expected, returned, .001);
    }

    @Test
    public void roundTo2DecimalPlaces_negativeRoundUp() {
        double input = -543.655;
        double expected = -543.65;
        double returned = testClass.roundTo2DecimalPlaces(input);
        Assert.assertEquals(expected, returned, .001);
    }


    @Test
    public void addStudent() {
        Student addedStudent = new Student("New", "Student", new Double[0]);
        testClass.addStudent(addedStudent);
        Student[] expected = {student1, student2, student3, student4, student5,
                student6, student7, student8, student9, student10, addedStudent};
        Student[] returned = testClass.getStudents();
        Assert.assertArrayEquals(expected, returned);
    }

    @Test
    public void removeStudent_studentFoundReturnsTrue() {
        String inputFirstName = "A";
        String inputLastName = "A";
        boolean successfulRemove = testClass.removeStudent(inputFirstName, inputLastName);
        Assert.assertTrue(successfulRemove);
    }

    @Test
    public void removeStudent_studentNotFoundReturnsFalse() {
        String inputFirstName = "Z";
        String inputLastName = "Z";
        boolean isRemoved = testClass.removeStudent(inputFirstName, inputLastName);
        Assert.assertFalse(isRemoved);
    }

    @Test
    public void removeStudent_remove1stStudentLastValueOfArrayNull() {
        String inputFirstName = "A";
        String inputLastName = "A";
        testClass.removeStudent(inputFirstName, inputLastName);
        Student[] arrayAfterRemove = testClass.getStudents();
        Assert.assertNull(arrayAfterRemove[arrayAfterRemove.length - 1]);
    }

    @Test
    public void getStudentByScore_student4HigherScoreThanS1() {
        Student[] inputStudentArray = {student1, student4};
        Classroom testClass2 = new Classroom(inputStudentArray);
        Student[] arrayExpected = {student4, student1};
        Student[] arrayReturned = testClass2.getStudentByScore();
        Assert.assertArrayEquals(arrayExpected, arrayReturned);
    }

    @Test
    public void getStudentByScore_student1AndS7SameScore_SortByLastName() {
        Student[] inputStudentArray = {student7, student1};
        Classroom testClass3 = new Classroom(inputStudentArray);
        Student[] arrayExpected = {student1, student7};
        Student[] arrayReturned = testClass3.getStudentByScore();
        Assert.assertArrayEquals(arrayExpected, arrayReturned);
    }

    @Test
    public void getStudentByScore_tenStudentsSortAndSortByLastName() {
        Student[] arrayExpected = {student9, student4, student10, student8, student1,
                student7, student6, student5, student2, student3};
        Student[] arrayReturned = testClass.getStudentByScore();
        System.out.println(Arrays.toString(arrayReturned));
        Assert.assertArrayEquals(arrayExpected, arrayReturned);
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
