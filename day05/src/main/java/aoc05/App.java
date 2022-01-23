package aoc05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    private static final Board board = new Board();
    private final List<Line> lines;

    public App(List<Line> lines) {
        this.lines = lines;
    }

    public Integer getSolutionPart1() {
        var selectedLines = lines
                .stream()
                .filter(line -> line.x1 == line.x2 || line.y1 == line.y2)
                .collect(Collectors.toList());

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

        int cnt = 0;
        for(var i = 0; i < board.points.length; i ++) {
            for(var j = 0; j < board.points[0].length; j ++) {
                if(board.points[i][j] >= 2) cnt ++;
            }
        }

        return cnt;
    }

    public Integer getSolutionPart2() {
        var res = 0;

        return res;
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