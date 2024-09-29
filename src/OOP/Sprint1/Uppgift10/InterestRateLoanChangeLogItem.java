package OOP.Sprint1.Uppgift10;

public class InterestRateLoanChangeLogItem extends ChangeLogItem {
    private final int employmentNumberOfBankStaffResponsibleForChange;
    private final int loanIDOfChangedInterest;
    private final double previousInterestRateInPercent;
    private final double newInterestRateInPercent;


    public InterestRateLoanChangeLogItem(BankStaff bankStaff, Loan loan, double newInterestRateInPercent) {
        super();
        this.employmentNumberOfBankStaffResponsibleForChange = bankStaff.getEmploymentID();
        this.loanIDOfChangedInterest = loan.getLoanID();
        this.previousInterestRateInPercent = loan.getInterestRateInPercent();
        this.newInterestRateInPercent = newInterestRateInPercent;
    }

    public String getLogContent() {
        return String.format("getting log content of loan log item");
    }


}