package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentEvaluatorTest {
    StudentEvaluator evaluator = new StudentEvaluator();

    @Test
    void testAddStudentAndCount() {
        evaluator.addStudent("Alice", 85);
        assertEquals(1, evaluator.getStudentCount());
    }

    @Test
    void testCalculateAverage() {
        evaluator.addStudent("Bob", 80);
        evaluator.addStudent("Charlie", 70);
        assertEquals(75.0, evaluator.calculateAverage());
    }

    @Test
    void testEvaluateGrade() {
        assertEquals("A", evaluator.evaluateGrade(95));
        assertEquals("B", evaluator.evaluateGrade(78));
        assertEquals("C", evaluator.evaluateGrade(55));
        assertEquals("Fail", evaluator.evaluateGrade(40));
    }

    @Test
    void testInvalidStudentName() {
        assertThrows(IllegalArgumentException.class, () -> evaluator.addStudent("", 90));
    }

    @Test
    void testInvalidMarksNegative() {
        assertThrows(IllegalArgumentException.class, () -> evaluator.addStudent("John", -5));
    }

    @Test
    void testInvalidMarksOver100() {
        assertThrows(IllegalArgumentException.class, () -> evaluator.addStudent("John", 105));
    }

    @Test
    void testEmptyListAverage() {
        assertEquals(0.0, new StudentEvaluator().calculateAverage());
    }
}
