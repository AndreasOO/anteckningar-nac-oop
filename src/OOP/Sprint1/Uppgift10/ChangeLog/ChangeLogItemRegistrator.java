package OOP.Sprint1.Uppgift10.ChangeLog;

import OOP.Sprint1.Uppgift10.AccountAndLoanCreation.Account;
import OOP.Sprint1.Uppgift10.AccountAndLoanCreation.Loan;
import OOP.Sprint1.Uppgift10.BankStaff;

public class ChangeLogItemRegistrator {
    ChangeLogItemRegistrator(){

    }
    public static AccountCreationChangeLogItem getAccountCreationLogItem(BankStaff bankStaff, Account account) {
        return new AccountCreationChangeLogItem(bankStaff,account);
    }

    public static LoanApprovalChangeLogItem getLoanApprovalLogItem(BankStaff bankStaff, Loan loan) {
        return new LoanApprovalChangeLogItem(bankStaff,loan);
    }

    public static LoanInterestRateChangeLogItem getLoanInterestRateChangeLogItem(BankStaff bankStaff, Loan loan, double newInterestRate) {
        return new LoanInterestRateChangeLogItem(bankStaff,loan,newInterestRate);
    }

    public static AccountInterestRateChangeLogItem getAccountInterestRateChangeLogItem(BankStaff bankStaff, Account account, double newInterestRate) {
        return new AccountInterestRateChangeLogItem(bankStaff,account,newInterestRate);
    }
}
