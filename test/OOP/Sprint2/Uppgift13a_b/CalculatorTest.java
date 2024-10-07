package OOP.Sprint2.Uppgift13a_b;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {

    Calculator calculator = new Calculator("10 + 11");

    Calculator calculatorDivideByZero = new Calculator("10 / 0");

    Calculator calculatorIncorrectInput = new Calculator("das + +21");

    @Test
    void validateInput() {
        assertThrows(IllegalArgumentException.class, () -> calculatorIncorrectInput.validateInput());
        calculator.validateInput();
    }

    @Test
    void findOperator() {
        calculator.findOperator();
        assertEquals(Operators.ADDITION, calculator.getOperator());
        assertEquals(1, Arrays.stream(Operators.values()).filter(op -> op == Operators.ADDITION).count());
    }

    @Test
    void findOperands() {
        calculator.findOperator();
        calculator.findOperands();
        assertEquals(10.0, calculator.getOperandOne());
        assertEquals(11.0, calculator.getOperandTwo());
    }

    @Test
    void calculate() {
        calculator.findOperator();
        calculator.findOperands();
        assertEquals(21.0, calculator.calculate());

        calculatorDivideByZero.findOperator();
        calculatorDivideByZero.findOperands();
        assertThrows(ArithmeticException.class, () -> calculatorDivideByZero.calculate());
    }
}