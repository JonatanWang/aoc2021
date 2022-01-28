package aoc05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    private static final Board board = new Board();
    private final List<Line> lines;

    public App(List<Line> lines) {
        this.lines = lines;
    }

    public Integer getSolutionPart1() {

        for (Line line:
                lines) {
            if (line.x1 == line.x2 && line.y1 == line.y2) {
                board.points[line.x1][line.y1] ++;
            }
            else if (line.x1 == line.x2) {
                var start = Integer.min(line.y1, line.y2);
                var end = Integer.max(line.y1, line.y2);
                for(var i = start; i <= end; i ++) {
                    board.points[line.x1][i] ++;
                }
            } else if (line.y1 == line.y2) {
                var start = Integer.min(line.x1, line.x2);
                var end = Integer.max(line.x1, line.x2);
                for(var j = start; j <= end; j ++) {
                    board.points[j][line.y1] ++;
                }
            } else {

            }
        }

        var res = Stream
                .of(board.points)
                .flatMapToInt(IntStream::of)
                .filter(p -> p >= 2)
                .count();
        return (int) res;
    }

    public Integer getSolutionPart2() {
        for (Line line:
                lines) {
            var numOfPoints = Math.max(Math.abs(line.x1 - line.x2), Math.abs(line.y1 - line.y2)) + 1;
            var offsetX = Integer.compare(line.x2, line.x1);
            var offsetY = Integer.compare(line.y2, line.y1);
            System.out.println("offsetX: " + offsetX + " || offsetY: " + offsetY + " || numOfpoints: " + numOfPoints);
            for (var i = 0; i < numOfPoints; i ++) {
                board.points[line.x1 + i * offsetX][line.y1 + i * offsetY] ++;
            }
            /**
            if (line.x1 == line.x2 && line.y1 == line.y2) {
                board.points[line.x1][line.y1] ++;
            }
            else if (line.x1 == line.x2) {
                var start = Integer.min(line.y1, line.y2);
                var end = Integer.max(line.y1, line.y2);
                for(var i = start; i <= end; i ++) {
                    board.points[line.x1][i] ++;
                }
            } else if (line.y1 == line.y2) {
                var start = Integer.min(line.x1, line.x2);
                var end = Integer.max(line.x1, line.x2);
                for(var j = start; j <= end; j ++) {
                    board.points[j][line.y1] ++;
                }
            }
            else if (line.x1 < line.x2 && line.y1 < line.y2){
                var numOfPoints = line.x2 - line.x1 + 1;
                for (var i = 0; i < numOfPoints; i ++) {
                    board.points[line.x1 + i][line.y1 + i] ++;
                }
            } else if (line.x1 < line.x2 && line.y1 > line.y2){
                var numOfPoints = line.x2 - line.x1 + 1;
                for (var i = 0; i < numOfPoints; i ++) {
                    board.points[line.x1 + i][line.y1 - i] ++;
                }
            }
            else if (line.x1 > line.x2 && line.y1 < line.y2){
                var numOfPoints = line.x1 - line.x2 + 1;
                for (var i = 0; i < numOfPoints; i ++) {
                    board.points[line.x1 - i][line.y1 + i] ++;
                }
            }
            else if (line.x1 > line.x2 && line.y1 > line.y2){
                var numOfPoints = line.x1 - line.x2 + 1;
                for (var i = 0; i < numOfPoints; i ++) {
                    board.points[line.x1 - i][line.y1 - i] ++;
                }
            }
             */
        }

        //board.show();

        var res = Stream
                .of(board.points)
                .flatMapToInt(IntStream::of)
                .filter(p -> p >= 2)
                .count();

        return (int) res;
    }

    public static void main(String[] args) throws Exception {

        var lines = getInput("input.txt");
        String part = System.getenv("part") == null ? "part1" : System.getenv("part");

        if (part.equals("part2"))
            System.out.println(new App(lines).getSolutionPart2());
        else
            System.out.println(new App(lines).getSolutionPart1());
    }

    private static List<Line> getInput(String filename) throws IOException {
        return Files.lines(Path.of(filename))
                .map(s -> new Line(s))
                .collect(Collectors.toList());
    }
}