package OOP.Sprint2.Uppgift7;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class InterestCalculatorTest {

    InterestCalculator interestCalculator = new InterestCalculator(100, 10);

    @Test
    void calculateYearlyInterest() {
        assertEquals(110.00, interestCalculator.calculateYearlyInterest(100.00));
        assertEquals(121.00, interestCalculator.calculateYearlyInterest(110.00));
        assertEquals(133.10, interestCalculator.calculateYearlyInterest(121.00));
        assertEquals(146.41, interestCalculator.calculateYearlyInterest(133.10));
        assertEquals(161.05, interestCalculator.calculateYearlyInterest(146.41));
        assertEquals(177.16, interestCalculator.calculateYearlyInterest(161.05));
        assertEquals(194.87, interestCalculator.calculateYearlyInterest(177.16));
        assertEquals(214.36, interestCalculator.calculateYearlyInterest(194.87));
        assertEquals(235.79, interestCalculator.calculateYearlyInterest(214.36));
        assertEquals(259.37, interestCalculator.calculateYearlyInterest(235.79));
    }

}