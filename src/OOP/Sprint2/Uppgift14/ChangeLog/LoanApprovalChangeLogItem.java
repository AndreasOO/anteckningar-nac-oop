package OOP.Sprint2.Uppgift14.ChangeLog;

import OOP.Sprint2.Uppgift14.AccountAndLoanCreation.Loan;
import OOP.Sprint2.Uppgift14.PersonsCreation.BankStaff;

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

    public String getLogItemContent() {
        return String.format("Change Log item: %s -- Loan approval\n" +
                        "Account created at %s\n" +
                        "Responsible employee ID: %s\n" +
                        "Loan ID number: %s\n" +
                        "Approved interest rate: %s\n" +
                        "Initial principal: %s\n", super.getChangeLogItemID(),
                super.getTimeOfChange(),
                this.employmentNumberOfBankStaffResponsibleForChange,
                this.loanIDOfApprovedLoan,
                this.approvedInterestRateInPercent,
                this.initialLoanPrincipal);
    }

    public int getResponsibleEmployeeID() {
        return this.employmentNumberOfBankStaffResponsibleForChange;
    }


}