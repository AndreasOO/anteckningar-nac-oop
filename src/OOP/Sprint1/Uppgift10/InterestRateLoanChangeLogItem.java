package OOP.Sprint1.Uppgift10;

public class InterestRateLoanChangeLogItem extends ChangeLogItem {
    private final int employmentNumberOfBankStaffResponsibleForChange;
    private final int customerIDOfChangedAccount;
    private final double previousInterestRateInPercent;
    private final double newInterestRateInPercent;


    public InterestRateLoanChangeLogItem(BankStaff bankStaff, Loan loan, double newInterestRateInPercent) {
        super();
        this.employmentNumberOfBankStaffResponsibleForChange = bankStaff.getEmploymentID();
        this.customerIDOfChangedAccount = loan.getBankCustomerTakingLoan().getCustomerID();
        this.previousInterestRateInPercent = loan.getInterestRateInPercent();
        this.newInterestRateInPercent = newInterestRateInPercent;
    }


}