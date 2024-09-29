package OOP.Sprint1.Uppgift10.AccountAndLoanCreation;

public class Account implements InterestBearing {
    private static int accountNumberCounter = 500;

    private final int accountNumber;
    private double accountBalance;
    private double accountInterestRateInPercentage;
    private int customerIDOfAccountOwner;

    protected Account(double accountBalance, int accountInterestRate, int customerIDOfAccountOwner) {
        this.accountNumber = accountNumberCounter++;
        this.accountBalance = accountBalance;
        this.accountInterestRateInPercentage = accountInterestRate;
        this.customerIDOfAccountOwner = customerIDOfAccountOwner;

    }

    public int getAccountNumber() {
        return accountNumber;
    }


    @Override
    public double getInterestRateInPercent() {
        return accountInterestRateInPercentage;
    }

    @Override
    public void setNewInterestRateInPercent(double newAccountInterestRateInPercentage) {
        this.accountInterestRateInPercentage = newAccountInterestRateInPercentage;
    }

    public double getAccountBalance() {
        return accountBalance;
    }
}
