/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {
    private static List<Integer> INPUT = List.of(3,4,3,1,2);
    App classUnderTest;

    @BeforeEach
    void createSubject() {
        classUnderTest = new App(INPUT);
    }

    @Test void part1SumsInput() {
        var loop = 80;
        assertEquals(5934, classUnderTest.getSolutionPart1(loop));
    }

    @Test void part2MultipliesInput() {
        assertEquals(Long.parseLong("26984457539"), classUnderTest.getSolutionPart2());
    }
}