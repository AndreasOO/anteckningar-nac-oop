package OOP.Sprint2.Uppgift6a_d;

import java.util.Scanner;

public class MoneyExchanger {
    private String inputPrice;
    private String inputAmountPaid;
    private double price;
    private double amountPaid;
    private double totalChange;
    private double currentChangeLeft;
    Scanner scanner;
    boolean isTestMode;

    private final ValuesCounter valuesCounter;

    public MoneyExchanger() {
        valuesCounter = new ValuesCounter();
        scanner = new Scanner(System.in);
    }

    public MoneyExchanger(boolean isTestMode) {
        valuesCounter = new ValuesCounter();
        scanner = new Scanner(System.in);
    }

    public void runProgram() {
        getUserInput();
        try {
            validateUserInput();
            convertUserInput();
            calculateTotalChange();
            calculateChangeBack();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
        sendOutputToUser();
    }

    public void getUserInput() {

        System.out.println("Input price");
        inputPrice = scanner.nextLine();
        System.out.println("Input amount paid");
        inputAmountPaid = scanner.nextLine();
    }

    public void validateUserInput() {
        if (inputPrice == null) {
            throw new NullPointerException("Input price is null");
        }
        if (inputAmountPaid == null) {
            throw new NullPointerException("Input amount paid is null");
        }
        if (inputPrice.isEmpty()) {
            throw new IllegalArgumentException("Input price is empty");
        }
        if (inputAmountPaid.isEmpty()) {
            throw new IllegalArgumentException("Input amount paid is empty");
        }

        if (!inputPrice.matches("\\d*\\.?\\d+?")) {
            throw new IllegalArgumentException("Input price is incorrect format");
        }
        if (!inputAmountPaid.matches("\\d*\\.?\\d+?")) {
            throw new IllegalArgumentException("Input amount paid is incorrect format");
        }

    }

    public void convertUserInput() {
        price = Double.parseDouble(inputPrice);
        amountPaid = Double.parseDouble(inputAmountPaid);
    }

    public void calculateChangeBack() {
        currentChangeLeft = totalChange;

        while (currentChangeLeft > 0) {
            if (currentChangeLeft >= 500) {
                valuesCounter.addFiveHundred();
                currentChangeLeft -= 500;
                continue;
            }
            if (currentChangeLeft >= 200) {
                valuesCounter.addTwoHundred();
                currentChangeLeft -= 200;
                continue;
            }
            if (currentChangeLeft >= 100) {
                valuesCounter.addOneHundred();
                currentChangeLeft -= 100;
                continue;
            }
            if (currentChangeLeft >= 50) {
                valuesCounter.addFifty();
                currentChangeLeft -= 50;
                continue;
            }
            if (currentChangeLeft >= 20) {
                valuesCounter.addTwenty();
                currentChangeLeft -= 20;
                continue;
            }
            if (currentChangeLeft >= 10) {
                valuesCounter.addTen();
                currentChangeLeft -= 10;
                continue;
            }

            if (currentChangeLeft >= 5) {
                valuesCounter.addFive();
                currentChangeLeft -= 5;
                continue;
            }
            if (currentChangeLeft >= 2) {
                valuesCounter.addTwo();
                currentChangeLeft -= 2;
                continue;
            }
            if (currentChangeLeft >= 1) {
                valuesCounter.addSingle();
                currentChangeLeft -= 1;
                break;
            }
        }
    }

    public void calculateTotalChange() {
        totalChange = amountPaid-price;
        if (totalChange < 0) {
            throw new IllegalArgumentException("Not enough money to match price");
        }
    }

    public double getTotalChange() {
        return totalChange;
    }

    public String createOutput() {
        return valuesCounter.createOutput();
    }

    public void sendOutputToUser() {
        System.out.println(createOutput());
    }



    public ValuesCounter getValuesCounter() {
        return valuesCounter;
    }

    public void setInputPrice(String inputPrice) {
        this.inputPrice = inputPrice;
    }

    public void setInputAmountPaid(String inputAmountPaid) {
        this.inputAmountPaid = inputAmountPaid;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

}
