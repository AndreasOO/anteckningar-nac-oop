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

    private final ValuesCounter valuesCounter;

    public MoneyExchanger() {
        valuesCounter = new ValuesCounter();
        scanner = new Scanner(System.in);
        Integer v = 5;
        v.hashCode();
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


            int timesDenomination;

            if (currentChangeLeft >= 500) {
                timesDenomination = (int) currentChangeLeft/500;
                valuesCounter.addFiveHundred(timesDenomination);
                currentChangeLeft -= 500*timesDenomination;

            }
            if (currentChangeLeft >= 200) {
                timesDenomination = (int) currentChangeLeft/200;
                valuesCounter.addTwoHundred(timesDenomination);
                currentChangeLeft -= 200*timesDenomination;

            }
            if (currentChangeLeft >= 100) {
                timesDenomination = (int) currentChangeLeft/100;
                valuesCounter.addOneHundred(timesDenomination);
                currentChangeLeft -= 100*timesDenomination;

            }
            if (currentChangeLeft >= 50) {
                timesDenomination = (int) currentChangeLeft/50;
                valuesCounter.addFifty(timesDenomination);
                currentChangeLeft -= 50*timesDenomination;

            }
            if (currentChangeLeft >= 20) {
                timesDenomination = (int) currentChangeLeft/20;
                valuesCounter.addTwenty(timesDenomination);
                currentChangeLeft -= 20*timesDenomination;

            }
            if (currentChangeLeft >= 10) {
                timesDenomination = (int) currentChangeLeft/10;
                valuesCounter.addTen(timesDenomination);
                currentChangeLeft -= 10*timesDenomination;

            }

            if (currentChangeLeft >= 5) {
                timesDenomination = (int) currentChangeLeft/5;
                valuesCounter.addFive(timesDenomination);
                currentChangeLeft -= 5*timesDenomination;

            }
            if (currentChangeLeft >= 2) {
                timesDenomination = (int) currentChangeLeft/2;
                valuesCounter.addTwo(timesDenomination);
                currentChangeLeft -= 2*timesDenomination;

            }
            if (currentChangeLeft >= 1) {
                valuesCounter.addSingle(1);
                currentChangeLeft -= 1;

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
