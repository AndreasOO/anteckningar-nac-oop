package OOP.Sprint1.Uppgift10;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class InterestRateChangeLogItem {
    private int employmentNumberOfBankStaffResponsibleForChange;
    private int accountNumberOfChangedAccount;
    private int previousInterestRateInPercent;
    private int newInterestRateInPercent;
    private Date timeOfChange;

    public InterestRateChangeLogItem(BankStaff bankStaff, Account account, int newInterestRateInPercent) {
        this.employmentNumberOfBankStaffResponsibleForChange = bankStaff.getEmploymentID();
        this.accountNumberOfChangedAccount = account.getAccountNumber();
        this.previousInterestRateInPercent = account.getInterestRateInPercent();
        this.newInterestRateInPercent = newInterestRateInPercent;
        this.timeOfChange = Calendar.getInstance().getTime();

    }
}
