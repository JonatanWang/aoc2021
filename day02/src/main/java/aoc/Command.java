package aoc;

import java.util.*;

public class Command {

    private String action;
    private int distance;

    public Command(String action, int distance) {
        this.action = action;
        this.distance = distance;
    }

    public static Command parseString(String s) {
        var commandParts = s.split(" ");
        return new Command(commandParts[0], Integer.valueOf(commandParts[1]));
    }

    public void info() {
        System.out.println("Action: " + this.action + "; " + "Distance: " + this.distance);
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}