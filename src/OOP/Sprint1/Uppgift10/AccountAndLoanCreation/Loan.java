package OOP.Sprint1.Uppgift10.AccountAndLoanCreation;

public class Loan implements InterestBearing {
    private static int loanIDCounter = 400;
    private final int loanID;
    private int customerIDTakingLoan;
    private final double initialLoanPrincipal;
    private double currentLoanPrincipal;
    private double loanInterestRateInPercent;


    protected Loan(double initialLoanPrincipal, double loanInterestRateInPercent, int customerIDTakingLoan) {
        this.loanID = loanIDCounter++;
        this.initialLoanPrincipal = initialLoanPrincipal;
        this.loanInterestRateInPercent = loanInterestRateInPercent;
        this.customerIDTakingLoan = customerIDTakingLoan;
    }

    public int getLoanID() {
        return loanID;
    }

    @Override
    public double getInterestRateInPercent() {
        return loanInterestRateInPercent;
    }

    @Override
    public void setNewInterestRateInPercent(double newLoanInterestRateInPercent) {
        this.loanInterestRateInPercent = newLoanInterestRateInPercent;
    }

    public double getInitialLoanPrincipal() {
        return initialLoanPrincipal;
    }
}
