package OOP.Sprint1.Uppgift10.AccountAndLoanCreation;

public class LoanApprover {
    public static Loan approveLoan(double initialLoanPrincipal, double loanInterestRateInPercent, int customerIDTakingLoan) {
        return new Loan(initialLoanPrincipal, loanInterestRateInPercent, customerIDTakingLoan);
    }
}
