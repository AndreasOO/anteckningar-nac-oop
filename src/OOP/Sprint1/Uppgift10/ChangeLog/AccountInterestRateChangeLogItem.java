package OOP.Sprint1.Uppgift10.ChangeLog;

import OOP.Sprint1.Uppgift10.AccountAndLoanCreation.Account;
import OOP.Sprint1.Uppgift10.BankStaff;

public class AccountInterestRateChangeLogItem extends ChangeLogItem {
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


    public String getLogContent() {
        return String.format("getting log content of account log item");
    }


}
