package OOP.Sprint1.Uppgift8;

public class EvenSidedTriangle extends Shape {

    //TODO fix actual find hypotenuse method
    private final double hypot;
    private final double side2;
    private final double side3;



    public EvenSidedTriangle(Point point1, Point point2, Point point3) {
        super(point1);
        this.hypot = super.getStartingPoint().getDistance(point2);
        this.side2 = point2.getDistance(point3);
        this.side3 = point3.getDistance(super.getStartingPoint());
    }

    public double area() {
        return (side2 * side3)/2.0;
    }
}
