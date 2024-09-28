package OOP.Sprint1.Uppgift10;

public class Loan implements InterestBearing {
    private final double initialLoanPrincipal;
    private double currentLoanPrincipal;
    private double loanInterestRateInPercent;
    BankCustomer bankCustomerTakingLoan;
    BankStaff bankStaffApprovingLoan;

    protected Loan(double initialLoanPrincipal, double loanInterestRateInPercent) {
        this.initialLoanPrincipal = initialLoanPrincipal;
        this.loanInterestRateInPercent = loanInterestRateInPercent;
    }

    protected void setBankCustomerTakingLoan(BankCustomer bankCustomerTakingLoan) {
        this.bankCustomerTakingLoan = bankCustomerTakingLoan;
    }

    protected void setBankStaffApprovingLoan(BankStaff bankStaffApprovingLoan) {
        this.bankStaffApprovingLoan = bankStaffApprovingLoan;
    }


    @Override
    public double getInterestRateInPercent() {
        return loanInterestRateInPercent;
    }

    @Override
    public void setNewInterestRateInPercent(double newLoanInterestRateInPercent) {
        this.loanInterestRateInPercent = newLoanInterestRateInPercent;
    }

    public BankCustomer getBankCustomerTakingLoan() {
        return bankCustomerTakingLoan;
    }

    public BankStaff getBankStaffApprovingLoan() {
        return bankStaffApprovingLoan;
    }
}
