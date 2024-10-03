package OOP.Sprint2.Uppgift1_a_d;

public class Square implements Figure {
    private double length;
    private double width;

    public Square(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length*width;
    }

    public double getCircumference() {
        return length+length+width+width;
    }
}
