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
        assertEquals(161.051, interestCalculator.calculateYearlyInterest(146.41));
        assertEquals(177.155, interestCalculator.calculateYearlyInterest(161.05));
        assertEquals(194.876, interestCalculator.calculateYearlyInterest(177.16));
        assertEquals(214.357, interestCalculator.calculateYearlyInterest(194.87));
        assertEquals(235.796, interestCalculator.calculateYearlyInterest(214.36));
        assertEquals(259.369, interestCalculator.calculateYearlyInterest(235.79));
    }

    @Test
    void createOutput() {
        assertEquals("Year\t\tAmount\n" +
                "------------------\n" +
                "0\t\t\t100.00\n" +
                "1\t\t\t110.00\n" +
                "2\t\t\t121.00\n" +
                "3\t\t\t133.10\n" +
                "4\t\t\t146.41\n" +
                "5\t\t\t161.05\n" +
                "6\t\t\t177.16\n" +
                "7\t\t\t194.87\n" +
                "8\t\t\t214.36\n" +
                "9\t\t\t235.79\n" +
                "10\t\t\t259.37\n", interestCalculator.createOutputCompoundInterestForYears(10));
    }

}