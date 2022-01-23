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


}
