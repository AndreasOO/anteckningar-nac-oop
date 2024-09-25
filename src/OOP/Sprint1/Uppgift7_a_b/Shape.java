package OOP.Sprint1.Uppgift7_a_b;

public abstract class Shape {
    private final Point startingPoint;

    Shape(Point startingPoint) {
        this.startingPoint = startingPoint;
    }
    public abstract double area();

    public Point getStartingPoint() {
        return startingPoint;
    }
}
