package OOP.Sprint1.Uppgift7_a_b;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,4);
        Point p3 = new Point(4,4);
        Point p4 = new Point(4,0);
        Square square = new Square(p1,p2,p3,p4);
        System.out.println(square.area());

        p1 = new Point(0,0);
        p2 = new Point(4,4);
        p3 = new Point(4,0);
        EvenSidedTriangle triangle = new EvenSidedTriangle(p1,p2,p3);
        System.out.println(triangle.area());


        p1 = new Point(0,0);
        p2 = new Point(0,4);
        p3 = new Point(8,4);
        p4 = new Point(8,0);
        Rectangle rectangle = new Rectangle(p1,p2,p3,p4);
        System.out.println(rectangle.area());

        p1 = new Point(0,0);
        p2 = new Point(4,0);
        Circle circle = new Circle(p1,p2);
        System.out.println(circle.area());


        List<Shape> shapes = new LinkedList<>();
        shapes.add(square);
        shapes.add(triangle);
        shapes.add(rectangle);
        shapes.add(circle);

        for (Shape shape : shapes) {
            String className = shape.getClass().toString().
                    substring(shape.getClass().toString().lastIndexOf('.')+1);
            System.out.println(className + " - Area: " + shape.area());
        }
    }
}
