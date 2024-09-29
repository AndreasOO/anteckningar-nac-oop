package OOP.Sprint1.Uppgift10.ChangeLog;

import OOP.Sprint1.Uppgift10.AccountAndLoanCreation.Loan;
import OOP.Sprint1.Uppgift10.BankStaff;

public class LoanApprovalChangeLogItem extends ChangeLogItem {
    private final int employmentNumberOfBankStaffResponsibleForChange;
    private final int loanIDOfApprovedLoan;
    private final double approvedInterestRateInPercent;
    private final double initialLoanPrincipal;


    public LoanApprovalChangeLogItem(BankStaff bankStaff, Loan loan) {
        super();
        this.employmentNumberOfBankStaffResponsibleForChange = bankStaff.getEmploymentID();
        this.loanIDOfApprovedLoan = loan.getLoanID();
        this.approvedInterestRateInPercent = loan.getInterestRateInPercent();
        this.initialLoanPrincipal = loan.getInitialLoanPrincipal();
    }

    public String getLogContent() {
        return String.format("getting log content of loan approval log item");
    }


}