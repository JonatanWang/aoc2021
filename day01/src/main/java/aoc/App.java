/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    private final List<Integer> input;

    public App(List<Integer> input) {
        this.input = input;
    }

    public Integer getSolutionPart1() {
        int cnt = 0;
        for(int i = 0; i < input.size() - 1; i ++) {
            if (input.get(i + 1) > input.get(i)) {
                cnt ++;
            }
        }
        return cnt;
    }

    public Integer getSolutionPart2() {
        var cnt = 0;
        for (int i = 0; i < input.size() - 3; i ++) {
            var sumOfWindow1 = input.get(i) + input.get(i + 1) + input.get(i + 2);
            var sumOfWindow2 = input.get(i + 1) + input.get(i + 2) + input.get(i + 3);
            if (sumOfWindow2 > sumOfWindow1) cnt ++;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("java");
        List<Integer> input = parseInput("input.txt");
        String part = System.getenv("part") == null ? "part1" : System.getenv("part");
        if (part.equals("part2"))
            System.out.println(new App(input).getSolutionPart2());
        else
            System.out.println(new App(input).getSolutionPart1());
    }

    private static List<Integer> parseInput(String filename) throws IOException {
        return Files.lines(Path.of(filename))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}