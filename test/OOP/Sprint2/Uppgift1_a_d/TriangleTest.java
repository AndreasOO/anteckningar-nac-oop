package OOP.Sprint2.Uppgift1_a_d;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {


    Triangle triangle = new Triangle(2,2,2);

    @Test
    void getArea() {
        assertEquals(2,triangle.getArea());
    }

    @Test
    void getCircumference() {
        assertEquals(6,triangle.getCircumference());
    }
}