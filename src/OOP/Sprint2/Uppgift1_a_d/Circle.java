package OOP.Sprint2.Uppgift1_a_d;

public class Circle implements Figure {
    private final double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.pow(radius, 2)*Math.PI;
    }

    public double getCircumference() {
        return radius * 2 * Math.PI;
    }


}
