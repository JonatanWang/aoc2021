/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
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

    public Long getSolutionPart2() {
        var cnt = 0l;
        Map<Integer, Long> map = new HashMap<>();
        for(Integer integer : input) {
            if (map.containsKey(integer)) {
                var value = map.get(integer);
                map.put(integer, value + 1);
            } else {
                map.put(integer, 1l);
            }
        }

        var days = 256;
        while(days > 0) {

            var keySet = map.keySet();
            var tmpMap = new HashMap<Integer, Long>();
            for (Integer key : keySet) {

                var value = map.get(key);
                //System.out.println("k = " + key + " | value = " + value);
                if (key == 0) {
                    addKey6(tmpMap, value);
                    tmpMap.put(8, value);
                } else if (key == 7) {
                    addKey6(tmpMap, value);
                } else {
                    var newKey = key - 1;
                    tmpMap.put(newKey, value);
                }
            }
            map = tmpMap;
            days --;
        }

        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            var value = entry.getValue(); // numOfFishWithThisAge
            cnt += value;
        }


        return cnt;
    }

    private void addKey6(HashMap<Integer, Long> tmpMap, Long value) {
        if (tmpMap.keySet().contains(6)) {
            var valueToKey6 = tmpMap.get(6);
            tmpMap.put(6, valueToKey6 + value);
        } else {
            tmpMap.put(6, value);
        }
    }

    public static void main(String[] args) throws IOException {

        List<Integer> input = parseInput("input.txt");
        String part = System.getenv("part") == null ? "part1" : System.getenv("part");
        var loop =  80;
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