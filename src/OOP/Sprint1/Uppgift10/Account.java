package OOP.Sprint1.Uppgift10;

public class Account implements InterestBearing {
    private static int accountNumberCounter = 500;

    private final int accountNumber;
    private double accountBalance;
    private double accountInterestRateInPercentage;
    private BankCustomer accountOwner;

    protected Account(double accountBalance, int accountInterestRate) {
        this.accountNumber = accountNumberCounter++;
        this.accountBalance = accountBalance;
        this.accountInterestRateInPercentage = accountInterestRate;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    protected void setAccountOwner(BankCustomer accountOwner) {
        this.accountOwner = accountOwner;
    }

    @Override
    public double getInterestRateInPercent() {
        return accountInterestRateInPercentage;
    }

    @Override
    public void setNewInterestRateInPercent(double newAccountInterestRateInPercentage) {
        this.accountInterestRateInPercentage = newAccountInterestRateInPercentage;
    }
}
