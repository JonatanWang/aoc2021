/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.*;
import static java.util.stream.Collectors.*;

public class App {

    private static final String FILE_PATH = "/Users/zhengyu.wang/dev/aoc2021/day01/app/src/main/java/aoc/input.txt";
    private static List<Integer> input;

    static {
        try {
            input = lines(Paths.get(FILE_PATH))
                    .map(Integer::parseInt)
                    .collect(Collectors.<Integer>toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSolutionPart1() {
        int cnt = 0;
        for(int i = 0; i < input.size() - 1; i ++) {
            if (input.get(i + 1) > input.get(i)) {
                cnt ++;
            }
        }
        return String.valueOf(cnt);
    }

    public String getSolutionPart2() {
        var cnt = 0;
        for (int i = 0; i < input.size() - 3; i ++) {
            var sumOfWindow1 = input.get(i) + input.get(i + 1) + input.get(i + 2);
            var sumOfWindow2 = input.get(i + 1) + input.get(i + 2) + input.get(i + 3);
            if (sumOfWindow2 > sumOfWindow1) cnt ++;
        }
        return String.valueOf(cnt);
    }

    public static void main(String[] args) {

        String part = System.getenv("part") == null ? "part1" : System.getenv("part");
        if (part.equals("part2"))
            System.out.println(new App().getSolutionPart2());
        else
            System.out.println(new App().getSolutionPart1());
    }
}
