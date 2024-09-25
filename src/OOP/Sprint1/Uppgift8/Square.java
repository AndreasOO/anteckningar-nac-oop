package OOP.Sprint1.Uppgift8;

public class Square extends Shape {


    private final double side1;
    private final double side2;
    private final double side3;
    private final double side4;

    public Square(Point point1, Point point2, Point point3, Point point4) {
        super(point1);
        this.side1 = super.getStartingPoint().getDistance(point2);
        this.side2 = point2.getDistance(point3);
        this.side3 = point3.getDistance(point4);
        this.side4 = point4.getDistance(super.getStartingPoint());
    }

    public double area() {
        return Math.pow(side1,2);
    }
}
