package io.zipcoder;

import org.junit.*;
import org.junit.rules.ExpectedException;

public class StudentTest {

    Student testStudent;

//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }

    @Test
    public void constructor() {
    }

    @Test
    public void getFirstName() {
    }

    @Test
    public void setFirstName() {
    }

    @Test
    public void getLastName() {
    }

    @Test
    public void setLastName() {
    }

    @Before
    public void setUp1() {
        Double[] scores = {100.0, 150.0, 250.0, 0.0};
        testStudent = new Student("Leon", "Hunter", scores);
    }

    @Test
    public void getExamScores() {
        String expected = "Exam Scores: \n" +
                "\tExam 1 -> 100.0\n" +
                "\tExam 2 -> 150.0\n" +
                "\tExam 3 -> 250.0\n" +
                "\tExam 4 -> 0.0\n" +
                "\t";
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
                "\tExam 5 -> 200.0\n" +
                "\t";
        testStudent.addExamScore(scoreToAdd);
        String returned = testStudent.getExamScores();
        System.out.println(returned);
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
                "\tExam 4 -> 0.0\n" +
                "\t";
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
    public void getAverageExamScore() {
    }

    @Test
    public void testToString() {
    }
}