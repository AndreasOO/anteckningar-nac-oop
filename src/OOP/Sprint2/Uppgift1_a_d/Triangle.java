package OOP.Sprint2.Uppgift1_a_d;

public class Triangle implements Figure {
    private final double side1;
    private final double side2;
    private final double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getArea()  {
        return (side1*side2)/2;
    }

    public double getCircumference() {
        return side1+side2+side3;
    }







}
