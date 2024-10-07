package OOP.Sprint2.Uppgift14.ChangeLog;

import OOP.Sprint2.Uppgift14.AccountAndLoanCreation.Account;
import OOP.Sprint2.Uppgift14.PersonsCreation.BankStaff;

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

    @Override
    public String getLogItemContent() {
        return String.format("Change Log item: %s -- Account creation\n" +
                             "Account created at %s\n" +
                             "Responsible employee ID: %s\n" +
                             "Account number: %s\n" +
                             "Approved interest rate: %s\n" +
                             "Initial balance: %s\n", super.getChangeLogItemID(),
                                                      super.getTimeOfChange(),
                                                      this.employmentNumberOfBankStaffResponsibleForChange,
                                                      this.accountNumberOfCreatedAccount,
                                                      this.approvedInterestRateInPercent,
                                                      this.initialBalance);
    }

    public int getResponsibleEmployeeID() {
        return this.employmentNumberOfBankStaffResponsibleForChange;
    }

}