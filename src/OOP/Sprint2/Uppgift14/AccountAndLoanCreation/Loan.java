package OOP.Sprint2.Uppgift14.AccountAndLoanCreation;

import java.io.Serializable;

public class Loan implements InterestBearing, Printable, Serializable {
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

    public void printDetails() {
        System.out.println(String.format("Loan ID: %s -- Principal: %s -- Interest Rate: %s", this.loanID, this.currentLoanPrincipal, this.loanInterestRateInPercent));
    }
}
