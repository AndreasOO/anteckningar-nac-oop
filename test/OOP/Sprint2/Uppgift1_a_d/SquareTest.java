package OOP.Sprint2.Uppgift1_a_d;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    Square square = new Square(2,2);

    @Test
    void getArea() {
        assertEquals(4,square.getArea());
    }

    @Test
    void getCircumference() {
        assertEquals(8, square.getCircumference());
    }
}