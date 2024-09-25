package OOP.Sprint1.Uppgift8;

public class FigureFactory {

    FigureFactory() {

    }


    public static Square getSquare(Point point1, Point point2, Point point3, Point point4) {
        return new Square(point1, point2, point3, point4);
    }

    public static Rectangle getRectangle(Point point1, Point point2, Point point3, Point point4) {
        return new Rectangle(point1, point2, point3, point4);
    }

    public static EvenSidedTriangle getEvenSidedTriangle(Point point1, Point point2, Point point3) {
        return new EvenSidedTriangle(point1, point2, point3);
    }

    public static Circle getCircle(Point point1, Point point2) {
        return new Circle(point1, point2);
    }
}
