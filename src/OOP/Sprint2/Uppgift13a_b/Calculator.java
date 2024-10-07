package OOP.Sprint2.Uppgift13a_b;

import java.util.Arrays;

public class Calculator {
    private final String userInput;
    private Operators operator;
    private double operandOne;
    private double operandTwo;
    private double result;

    public Calculator(String userInput) {
        this.userInput = userInput;
    }

    public void execute() {
        try {
            validateInput();
            findOperator();
            findOperands();
            calculate();
            printResult();
        } catch (NumberFormatException e) {
            System.out.println("Incorrect format of number");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void printResult() {
        System.out.println("Result of " + userInput + " is: " + result);
    }

    protected void validateInput() {
        if (userInput.matches("^\\d+(\\.\\d+)? [+\\-*/] \\d+(\\.\\d+)?$")) {
            return;
        }
        throw new IllegalArgumentException("Incorrect input format");
    }

    protected void findOperator() {
        operator = Arrays.stream(Operators.values()).filter(op -> userInput.indexOf(op.character) != -1).findFirst().orElse(null);

    }

    protected void findOperands() {
        operandOne = Double.parseDouble(userInput.substring(0, userInput.indexOf(operator.character)));
        operandTwo = Double.parseDouble(userInput.substring(userInput.indexOf(operator.character) + 1));
    }

    protected double calculate() {
        switch (operator.character) {
            case '+' -> result = operandOne + operandTwo;
            case '-' -> result = operandOne - operandTwo;
            case '*' -> result = operandOne * operandTwo;
            case '/' -> {
                if (operandTwo == 0.00 || operandTwo == Double.POSITIVE_INFINITY || operandTwo == Double.NEGATIVE_INFINITY)
                    throw new ArithmeticException("Cannot divide by Zero");
                result = operandOne / operandTwo;
            }
        }
        return result;
    }

    public double getResult() {
        return result;
    }

    protected String getUserInput() {
        return userInput;
    }

    protected Operators getOperator() {
        return operator;
    }

    public double getOperandOne() {
        return operandOne;
    }

    public double getOperandTwo() {
        return operandTwo;
    }
}
