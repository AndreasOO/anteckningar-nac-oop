package OOP.Sprint1.Uppgift10.ChangeLog;

import OOP.Sprint1.Uppgift10.AccountAndLoanCreation.Loan;
import OOP.Sprint1.Uppgift10.PersonsCreation.BankStaff;

public class LoanInterestRateChangeLogItem extends ChangeLogItem {
    private final int employmentNumberOfBankStaffResponsibleForChange;
    private final int loanIDOfChangedInterest;
    private final double previousInterestRateInPercent;
    private final double newInterestRateInPercent;


    protected LoanInterestRateChangeLogItem(BankStaff bankStaff, Loan loan, double newInterestRateInPercent) {
        super();
        this.employmentNumberOfBankStaffResponsibleForChange = bankStaff.getEmploymentID();
        this.loanIDOfChangedInterest = loan.getLoanID();
        this.previousInterestRateInPercent = loan.getInterestRateInPercent();
        this.newInterestRateInPercent = newInterestRateInPercent;
    }

    public String getLogItemContent() {
        return String.format("Change Log item: %s -- Interest Rate Change on Account\n" +
                        "Change made at %s\n" +
                        "Responsible employee ID: %s\n" +
                        "Account number: %s\n" +
                        "Previous interest rate: %s\n" +
                        "New interest rate: %s\n", super.getChangeLogItemID(),
                super.getTimeOfChange(),
                this.employmentNumberOfBankStaffResponsibleForChange,
                this.loanIDOfChangedInterest,
                this.previousInterestRateInPercent,
                this.newInterestRateInPercent);

    }

    public int getResponsibleEmployeeID() {
        return this.employmentNumberOfBankStaffResponsibleForChange;
    }

}