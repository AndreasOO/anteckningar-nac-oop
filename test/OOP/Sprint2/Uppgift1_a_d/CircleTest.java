package OOP.Sprint2.Uppgift1_a_d;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    Circle circle = new Circle(4);

    Figure figure = new Circle(4);

    @Test
    void getArea() {
        assertEquals(50.26548245743669, circle.getArea());
        assertEquals(50.26548245743669, figure.getArea());
    }

    @Test
    void getCircumference() {
        assertEquals(25.132741228718345, circle.getCircumference());
        assertEquals(25.132741228718345, figure.getCircumference());
    }
}