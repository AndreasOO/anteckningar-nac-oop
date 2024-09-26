package OOP.Sprint1.Uppgift10;

public class Account implements InterestBearing {
    private static int accountNumberCounter = 500;

    private final int accountNumber;
    private double balance;
    private int interestRate;

    Account(double balance, int interestRate) {
        this.accountNumber = accountNumberCounter++;
        this.balance = balance;
        this.interestRate = interestRate;
    }


    public int getInterestRateInPercent() {
        return interestRate;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
