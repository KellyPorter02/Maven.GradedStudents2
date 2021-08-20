package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentTest {

    Student testStudent;

    @Before
    public void setUp1() {
        Double[] scores = {100.0, 150.0, 250.0, 0.0};
        String firstName = "Leon";
        String lastName = "Hunter";
        testStudent = new Student(firstName, lastName, scores);
    }

    @Test
    public void constructor_propertiesAreSetOnStudentConstructor() {
        String expectedFirstName = "Leon";
        String expectedLastName = "Hunter";
        List<Double> expectedExamScoresList = new ArrayList<>(Arrays.asList(100.0, 150.0, 250.0, 0.0));
        Assert.assertEquals(expectedFirstName, testStudent.getFirstName());
        Assert.assertEquals(expectedLastName, testStudent.getLastName());
        Assert.assertEquals(expectedExamScoresList, testStudent.getExamScoresList());
    }

    @Test
    public void getFirstName() {
        String expected = "Leon";
        String returned = testStudent.getFirstName();
        Assert.assertEquals(expected, returned);
    }

    @Test
    public void setFirstName() {
        String given = "Kelly";
        testStudent.setFirstName(given);
        String returned = testStudent.getFirstName();
        Assert.assertEquals(given, returned);
    }

    @Test
    public void getLastName() {
        String expected = "Hunter";
        String returned = testStudent.getLastName();
        Assert.assertEquals(expected, returned);
    }

    @Test
    public void setLastName() {
        String given = "Porter";
        testStudent.setLastName(given);
        String returned = testStudent.getLastName();
        Assert.assertEquals(given, returned);
    }

    @Test
    public void getExamScores() {
        String expected = "Exam Scores: \n" +
                "\tExam 1 -> 100.0\n" +
                "\tExam 2 -> 150.0\n" +
                "\tExam 3 -> 250.0\n" +
                "\tExam 4 -> 0.0\n";
        String returned = testStudent.getExamScores();
        Assert.assertEquals(expected, returned);
    }

    @Test
    public void getNumberOfExamsTaken() {
        int expected = 4;
        int returned = testStudent.getNumberOfExamsTaken();
        Assert.assertEquals(expected,returned);
    }

    @Test
    public void addExamScore() {
        double scoreToAdd = 200.0;
        String expected = "Exam Scores: \n" +
                "\tExam 1 -> 100.0\n" +
                "\tExam 2 -> 150.0\n" +
                "\tExam 3 -> 250.0\n" +
                "\tExam 4 -> 0.0\n" +
                "\tExam 5 -> 200.0\n";
        testStudent.addExamScore(scoreToAdd);
        String returned = testStudent.getExamScores();
        Assert.assertEquals(expected, returned);
    }

    @Test
    public void setExamScore_resetFirstExamScore() {
        int examToReset = 1;
        double newExamScore = 175.0;
        String expected = "Exam Scores: \n" +
                "\tExam 1 -> 175.0\n" +
                "\tExam 2 -> 150.0\n" +
                "\tExam 3 -> 250.0\n" +
                "\tExam 4 -> 0.0\n";
        testStudent.setExamScore(examToReset, newExamScore);
        String returned = testStudent.getExamScores();
        Assert.assertEquals(expected, returned);
    }

    @Rule
    public ExpectedException setExamScore_ArgTooHighRule = ExpectedException.none();

    @Test
    public void setExamScore_whenExamScoreArgTooHigh_thenIllegalArgExceptionThrown() {
        setExamScore_ArgTooHighRule.expect(IllegalArgumentException.class);
        int examToReset = 7;
        double newExamScore = 45.0;
        testStudent.setExamScore(examToReset, newExamScore);
    }

    @Test
    public void setExamScore_whenExamScoreArgTooHigh_thenIllegalArgExceptionMessage() {
        String messageExpected = "The student hasn't taken that many exams.";
        setExamScore_ArgTooHighRule.expectMessage(messageExpected);
        int examToReset = 7;
        double newExamScore = 45.0;
        testStudent.setExamScore(examToReset, newExamScore);
    }

    @Rule
    public ExpectedException setExamScore_ArgTooLowRule = ExpectedException.none();

    @Test
    public void setExamScore_whenExamScoreTooLow_thenIllegalArgExceptionThrown() {
        setExamScore_ArgTooLowRule.expect(IllegalArgumentException.class);
        int examToReset = 0;
        double newExamScore = 45.0;
        testStudent.setExamScore(examToReset, newExamScore);
    }

    @Test
    public void setExamScore_whenExamScoreTooLow_thenIllegalArgExceptionMessage() {
        String messageExpected = "Number of exam to reset must be 1 or above.";
        setExamScore_ArgTooLowRule.expectMessage(messageExpected);
        int examToReset = 0;
        double newExamScore = 45.0;
        testStudent.setExamScore(examToReset, newExamScore);
    }

    @Test
    public void getAverageExamScore_listOfFourScores() {
        double expected = 125.0;
        double returned = testStudent.getAverageExamScore();
        Assert.assertEquals(expected, returned, 0.01);
    }

    @Test
    public void getAverageExamScore_zeroLengthListReturnsZero() {
        Double[] emptyScoresArray = new Double[0];
        Student testStudent2 = new Student("Leon", "Hunter", emptyScoresArray);
        double expected = 0.0;
        double returned = testStudent2.getAverageExamScore();
        Assert.assertEquals(expected, returned, 0.01);
    }

    @Test
    public void testToString() {
        String expected = "Student Name: Leon Hunter\n" +
                "\t> Average Score: 125.0\n" +
                "\t> Exam Scores: \n" +
                "\tExam 1 -> 100.0\n" +
                "\tExam 2 -> 150.0\n" +
                "\tExam 3 -> 250.0\n" +
                "\tExam 4 -> 0.0\n";
        String returned = testStudent.toString();
        Assert.assertEquals(expected, returned);
    }
}