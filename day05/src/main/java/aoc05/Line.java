package aoc05;

import java.util.ArrayList;
import java.util.List;

public class Line {
    public int x1, x2, y1, y2;

    public Line(String s) {
        var twoParts = s.split(" -> ");
        var firstPart = twoParts[0].split(",");
        var secondPart = twoParts[1].split(",");
        this.x1 = Integer.parseInt(firstPart[0]);
        this.y1 = Integer.parseInt(firstPart[1]);
        this.x2 = Integer.parseInt(secondPart[0]);
        this.y2 = Integer.parseInt(secondPart[1]);
    }
}
