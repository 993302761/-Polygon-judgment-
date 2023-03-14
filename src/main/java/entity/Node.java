package entity;

public class Node {
    private double x;
    private double y;

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Node(String s, String s1) {
        x=Double.parseDouble(s);
        y=Double.parseDouble(s1);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Node(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
