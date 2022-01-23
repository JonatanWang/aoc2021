package aoc05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {

    private static final String testString = "212,174 -> 362,74";

    @Test
    void testConstructor() {
        var line = new Line(testString);
        assertEquals(212, line.x1);
        assertEquals(174, line.y1);

        assertEquals(362, line.x2);
        assertEquals(74, line.y2);
    }
}
