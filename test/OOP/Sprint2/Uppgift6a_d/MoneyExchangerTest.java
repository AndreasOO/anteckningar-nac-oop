package OOP.Sprint2.Uppgift6a_d;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class MoneyExchangerTest {

    MoneyExchanger moneyExchanger = new MoneyExchanger();


    @Test
    void validateUserInputPrice() {
        moneyExchanger.setInputAmountPaid("23");

        moneyExchanger.setInputPrice(null);
        assertThrows(NullPointerException.class, () -> {
            moneyExchanger.validateUserInput();
        });
        moneyExchanger.setInputPrice("");
        assertThrows(IllegalArgumentException.class, () -> {
            moneyExchanger.validateUserInput();
        });

        moneyExchanger.setInputPrice("dsa");
        assertThrows(IllegalArgumentException.class, () -> {
            moneyExchanger.validateUserInput();
        });


    }


    @Test
    void validateUserInputAmountPaid() {
        moneyExchanger.setInputPrice("23.53");

        moneyExchanger.setInputAmountPaid(null);
        assertThrows(NullPointerException.class, () -> {
            moneyExchanger.validateUserInput();
        });
        moneyExchanger.setInputAmountPaid("");
        assertThrows(IllegalArgumentException.class, () -> {
            moneyExchanger.validateUserInput();
        });

        moneyExchanger.setInputAmountPaid("dsa");
        assertThrows(IllegalArgumentException.class, () -> {
            moneyExchanger.validateUserInput();
        });
    }

    @Test
    void validateUserInputHappyFlow() {
        moneyExchanger.setInputPrice("23");
        moneyExchanger.setInputAmountPaid("23");
        moneyExchanger.validateUserInput();
    }



    @Test
    void convertUserInputPrice() {
        moneyExchanger.setInputAmountPaid("23.53");
        moneyExchanger.setInputPrice(null);
        assertThrows(NullPointerException.class, () -> moneyExchanger.convertUserInput());

        moneyExchanger.setInputPrice("dsf");
        assertThrows(NumberFormatException.class, () -> moneyExchanger.convertUserInput());
    }

    @Test
    void convertUserInputAmountPaid() {
        moneyExchanger.setInputAmountPaid(null);
        moneyExchanger.setInputPrice("23");
        assertThrows(NullPointerException.class, () -> moneyExchanger.convertUserInput());

        moneyExchanger.setInputAmountPaid("dsf");
        assertThrows(NumberFormatException.class, () -> moneyExchanger.convertUserInput());
    }

    @Test
    void calculateChangeBack() {


        moneyExchanger.setPrice(100);
        moneyExchanger.setAmountPaid(150);
        moneyExchanger.calculateTotalChange();
        moneyExchanger.calculateTotalChange();
        moneyExchanger.calculateChangeBack();
        assertEquals(0, moneyExchanger.getValuesCounter().getNumberOfSingles());
        assertEquals(0, moneyExchanger.getValuesCounter().getNumberOfTwos());
        assertEquals(0, moneyExchanger.getValuesCounter().getNumberOfFives());
        assertEquals(0, moneyExchanger.getValuesCounter().getNumberOfTens());
        assertEquals(0, moneyExchanger.getValuesCounter().getNumberOfTwenties());
        assertEquals(1, moneyExchanger.getValuesCounter().getNumberOfFifties());
        assertEquals(0, moneyExchanger.getValuesCounter().getNumberOfHundreds());
        assertEquals(0, moneyExchanger.getValuesCounter().getNumberOfTwoHundreds());
        assertEquals(0, moneyExchanger.getValuesCounter().getNumberOfFiveHundreds());

    }

    @Test
    void calculateTotalChange() {

        moneyExchanger.setPrice(100);
        moneyExchanger.setAmountPaid(50);
        assertThrows(IllegalArgumentException.class, () -> moneyExchanger.calculateTotalChange());

        moneyExchanger.setPrice(100);
        moneyExchanger.setAmountPaid(150);
        moneyExchanger.calculateTotalChange();
        assertEquals(50,moneyExchanger.getTotalChange());
    }



    @Test
    void createOutputWithChange() {
        moneyExchanger.setPrice(100);
        moneyExchanger.setAmountPaid(150);
        moneyExchanger.calculateTotalChange();
        moneyExchanger.calculateChangeBack();
        assertEquals("Number of Fifties nodes: 1\n", moneyExchanger.createOutput());


    }

    @Test
    void createOutputWithoutChange() {
        moneyExchanger.setPrice(100);
        moneyExchanger.setAmountPaid(100);
        moneyExchanger.calculateTotalChange();
        moneyExchanger.calculateChangeBack();
        assertEquals("No change back", moneyExchanger.createOutput());
    }
}