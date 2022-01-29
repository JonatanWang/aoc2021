/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    private List<Integer> input;

    public App(List<Integer> input) {
        this.input = input;
    }

    public Integer getSolutionPart1(int loop) {
        var res = 0;
        var tmp = new ArrayList<>(input);
        /**
        var tmp = new ArrayList<Integer>();

        for (Integer integer : input) {
            tmp.add(integer);
        }*/

        while(loop != 0) {
            var initialInputSize = tmp.size();
            for(var i = 0; i < initialInputSize; i ++) {
                if (tmp.get(i) == 0) {
                    tmp.add(8);
                    tmp.set(i, 6);
                } else {
                    var newValue = tmp.get(i) - 1;
                    tmp.set(i, newValue);
                }
            }

            loop --;
        }

        res = tmp.size();

        return res;
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

        List<Integer> input = parseInput("input.txt");
        String part = System.getenv("part") == null ? "part1" : System.getenv("part");
        var loop =  256;
        if (part.equals("part2"))
            System.out.println(new App(input).getSolutionPart2());
        else
            System.out.println(new App(input).getSolutionPart1(loop));
    }

    private static List<Integer> parseInput(String filename) throws IOException {

        var input = Files.lines(Path.of(filename))
                .map(s -> s.split(",")).collect(Collectors.toList());

        var list2 = Files.lines(Path.of(filename)).findFirst().get().split(",");
                //.stream().map(Integer::parseInt).collect(Collectors.toList())

        var list =
                Arrays
                .stream(
                        Files.lines(Path.of(filename))
                        .map(s -> s.split(","))
                        .findFirst()
                        .get()
                )
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return list;
        //return Arrays.stream(input.get(0)).map(Integer::parseInt).collect(Collectors.toList());
    }
}