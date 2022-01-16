package aoc04;

public class Point {
    private int value;
    private boolean marked;

    public Point(int value, boolean marked) {
        this.value = value;
        this.marked = marked;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    @Override
    public String toString() {
        return "Point{" +
                "value=" + value +
                ", visited=" + marked +
                '}';
    }
}
