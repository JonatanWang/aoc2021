/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package aoc05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    private static final List<Line> lines = List.of(
        new Line("0,9 -> 5,9"),
        new Line("8,0 -> 0,8"),
        new Line("9,4 -> 3,4"),
        new Line("2,2 -> 2,1"),
        new Line("7,0 -> 7,4"),

        new Line("6,4 -> 2,0"),
        new Line("0,9 -> 2,9"),
        new Line("3,4 -> 1,4"),
        new Line("0,0 -> 8,8"),
        new Line("5,5 -> 8,2")
    );

    App classUnderTest;

    @BeforeEach
    void createSubject() {
        classUnderTest = new App(lines);
    }

    @Test void part1SumsInput() throws Exception {
        assertEquals(5, classUnderTest.getSolutionPart1());
    }

    @Test void part2MultipliesInput() {
        assertEquals(12, classUnderTest.getSolutionPart2());
    }
}