package OOP.Sprint1.Uppgift7_a_b;

public class Circle extends Shape {

    private final Point center;
    private final double radius;

    public Circle(Point point1, Point point2) {
        super(point1);
        this.center = super.getStartingPoint();
        this.radius = center.getDistance(point2);
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}
