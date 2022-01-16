package aoc04;

import java.util.Arrays;
import java.util.List;

public class Board {

    private Point[][] points;

    public Board() {}

    public Board(List<String> boardLines) {
        this.points = new Point[5][5];
        for (var j = 0; j < 5; j ++) {
            var currentLineArray = boardLines.get(j).trim().split("\\s+");
            for (var k = 0; k < 5; k ++) {
                points[j][k] = new Point(Integer.parseInt(currentLineArray[k]), false);
            }
        }
    }

    public Board(Point[][] points) {
        this.points = points;
    }

    public Point[][] getPoints() {
        return points;
    }

    public void setPoints(Point[][] points) {
        this.points = points;
    }

    public boolean isBingo() {
        return  this.isVerticalBingo() || this.isHorizontalBingo();
    }

    public void markNumber(int number) {
        for (var k = 0; k < 5; k++) {
            for (var l = 0; l < 5; l++) {
                var currentPoint = points[k][l];
                if (currentPoint.isMarked() == false && currentPoint.getValue() == number) {
                    currentPoint.setMarked(true);
                }
            }
        }
    }

    public int getSumOfUnmarkedNumbers() {
        var sumOfUnmarkedNumbers = 0;
        for (var i = 0; i < 5; i ++) {
            for (var j = 0; j < 5; j ++) {
                if (points[i][j].isMarked() == false) {
                    sumOfUnmarkedNumbers += points[i][j].getValue();
                }
            }
        }

        return sumOfUnmarkedNumbers;
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
