package aoc;

import java.util.Arrays;

public class Board {

    private aoc.Point[][] points;

    public Board() {}

    public Board(String[] inputString) {}

    public Board(aoc.Point[][] points) {
        this.points = points;
    }

    public aoc.Point[][] getPoints() {
        return points;
    }

    public void setPoints(aoc.Point[][] points) {
        this.points = points;
    }

    public boolean isBingo() {
        return  this.isVerticalBingo() || this.isHorizontalBingo();
    }

    private boolean isVerticalBingo() {

        for (var i = 0; i < 5; i ++) {
            if (points[i][0].isMarked() &&
                points[i][1].isMarked() &&
                points[i][2].isMarked() &&
                points[i][3].isMarked() &&
                points[i][4].isMarked()) {
                return true;
            };
        }

        return  false;
    }

    private boolean isHorizontalBingo() {

        for (var i = 0; i < 5; i ++) {
            if  (points[0][i].isMarked() &&
                points[1][i].isMarked() &&
                points[2][i].isMarked() &&
                points[3][i].isMarked() &&
                points[4][i].isMarked()) {
                return true;
            };
        }

        return  false;
    }

    @Override
    public String toString() {
        return "Board{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
