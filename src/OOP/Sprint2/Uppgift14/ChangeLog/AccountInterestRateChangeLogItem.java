package OOP.Sprint2.Uppgift14.ChangeLog;

import OOP.Sprint2.Uppgift14.AccountAndLoanCreation.Account;
import OOP.Sprint2.Uppgift14.PersonsCreation.BankStaff;

public class AccountInterestRateChangeLogItem extends ChangeLogItem implements JListHeadingFormatable {
    private final int employmentNumberOfBankStaffResponsibleForChange;
    private final int accountNumberOfChangedAccount;
    private final double previousInterestRateInPercent;
    private final double newInterestRateInPercent;


    protected AccountInterestRateChangeLogItem(BankStaff bankStaff, Account account, double newInterestRateInPercent) {
        super();
        this.employmentNumberOfBankStaffResponsibleForChange = bankStaff.getEmploymentID();
        this.accountNumberOfChangedAccount = account.getAccountNumber();
        this.previousInterestRateInPercent = account.getInterestRateInPercent();
        this.newInterestRateInPercent = newInterestRateInPercent;
    }

    public String createHeader() {
        return String.format("Log item %d \t-\t Interest Rate Change on Account", super.getChangeLogItemID());
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
                                                        this.accountNumberOfChangedAccount,
                                                        this.previousInterestRateInPercent,
                                                        this.newInterestRateInPercent);
    }

    public int getResponsibleEmployeeID() {
        return this.employmentNumberOfBankStaffResponsibleForChange;
    }

}
