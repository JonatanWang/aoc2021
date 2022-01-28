package aoc05;

public class Board {

    public int[][] points = new int[1000][1000];;

    public Board() {
        for(var i = 0; i < points.length; i ++) {
            for(var j = 0; j < points[0].length; j ++) {
                points[i][j] = 0;
            }
        }
    }

    public void show() {
        var maxX = 0; var maxY = 0;
        for(var x = 0; x < points.length; x ++) {
            for(var y = 0; y < points[x].length; y ++) {
                if (points[x][y] > 0) {
                    if (x > maxX) {
                        maxX = x;
                    }
                    if (y > maxY) {
                        maxY = y;
                    }
                }
            }
        }
        for(var x = 0; x <= maxX; x ++) {
            var currentLine = "";
            for(var y = 0; y <= maxY; y ++) {
                currentLine += points[y][x];
            }
            System.out.println("Current Line: " + currentLine);
        }
    }

}
