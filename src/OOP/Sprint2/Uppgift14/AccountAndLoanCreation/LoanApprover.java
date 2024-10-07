package OOP.Sprint2.Uppgift14.AccountAndLoanCreation;

public class LoanApprover {
    public static Loan approveLoan(double initialLoanPrincipal, double loanInterestRateInPercent, int customerIDTakingLoan) {
        return new Loan(initialLoanPrincipal, loanInterestRateInPercent, customerIDTakingLoan);
    }
}
