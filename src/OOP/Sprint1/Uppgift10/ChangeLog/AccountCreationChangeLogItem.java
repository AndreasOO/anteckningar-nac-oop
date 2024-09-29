package OOP.Sprint1.Uppgift10.ChangeLog;

import OOP.Sprint1.Uppgift10.AccountAndLoanCreation.Account;
import OOP.Sprint1.Uppgift10.BankStaff;

public class AccountCreationChangeLogItem extends ChangeLogItem {
    private final int employmentNumberOfBankStaffResponsibleForChange;
    private final int accountNumberOfCreatedAccount;
    private final double approvedInterestRateInPercent;
    private final double initialBalance;


    protected AccountCreationChangeLogItem(BankStaff bankStaff, Account account) {
        super();
        this.employmentNumberOfBankStaffResponsibleForChange = bankStaff.getEmploymentID();
        this.accountNumberOfCreatedAccount = account.getAccountNumber();;
        this.approvedInterestRateInPercent = account.getInterestRateInPercent();
        this.initialBalance = account.getAccountBalance();
    }

    public String getLogContent() {
        return String.format("getting log content of account creation log item");
    }


}