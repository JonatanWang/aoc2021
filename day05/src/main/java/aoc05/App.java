/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package aoc05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    private final Board board;
    private final List<Line> lines;

    public App(List<Line> lines) {
        this.board = new Board();
        this.lines = lines;
    }

    public Integer getSolutionPart1() throws Exception {
        return 0;
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