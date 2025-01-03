package OOP.Sprint1.Uppgift10.PersonsCreation;

import OOP.Sprint1.Uppgift10.AccountAndLoanCreation.Account;
import OOP.Sprint1.Uppgift10.AccountAndLoanCreation.AccountCreator;
import OOP.Sprint1.Uppgift10.AccountAndLoanCreation.Loan;
import OOP.Sprint1.Uppgift10.AccountAndLoanCreation.LoanApprover;
import OOP.Sprint1.Uppgift10.ChangeLog.ChangeLogItemRegistrator;
import OOP.Sprint1.Uppgift10.ChangeLog.ChangeLog;

public class BankStaff extends Person {
    private static int employmentIDCounter = 10;

    private final int employmentID;
    private final double salary;

    public BankStaff(String name, double salary) {
        super(name);
        this.employmentID = employmentIDCounter++;
        this.salary = salary;
    }

    public int getEmploymentID() {
        return employmentID;
    }

    public void handleAccountCreation(double accountBalance, int accountInterestRate, BankCustomer bankCustomer) {
        Account account = AccountCreator.createNewAccount(accountBalance, accountInterestRate, bankCustomer.getCustomerID());
        bankCustomer.addAccount(account);
        logAccountCreation(account);
    }

    public void handleLoanApproval(double initialLoanPrincipal, double loanInterestRateInPercent, BankCustomer bankCustomer) {
        Loan loan = LoanApprover.approveLoan(initialLoanPrincipal, loanInterestRateInPercent, bankCustomer.getCustomerID());
        bankCustomer.addLoan(loan);
        logLoanApproval(loan);
    }

    public void handleAccountInterestChange(double newAccountInterestRateInPercent, Account account) {
        logAccountInterestChange(account,newAccountInterestRateInPercent);
        account.setNewInterestRateInPercent(newAccountInterestRateInPercent);
    }

    public void handleLoanInterestChange(double newLoanInterestRateInPercent, Loan loan) {
        logLoanInterestChange(loan,newLoanInterestRateInPercent);
        loan.setNewInterestRateInPercent(newLoanInterestRateInPercent);
    }


    private void logAccountCreation(Account account) {
        ChangeLog.getInstance().addItemToChangeLog(ChangeLogItemRegistrator.getAccountCreationLogItem(this, account));
    }
    private void logLoanApproval(Loan loan) {
        ChangeLog.getInstance().addItemToChangeLog(ChangeLogItemRegistrator.getLoanApprovalLogItem(this, loan));
    }

    private void logAccountInterestChange(Account account, double newAccountInterestRateInPercent) {
        ChangeLog.getInstance().addItemToChangeLog(ChangeLogItemRegistrator.getAccountInterestRateChangeLogItem(this, account, newAccountInterestRateInPercent));
    }
    private void logLoanInterestChange(Loan loan, double newLoanInterestRateInPercent) {
        ChangeLog.getInstance().addItemToChangeLog(ChangeLogItemRegistrator.getLoanInterestRateChangeLogItem(this, loan, newLoanInterestRateInPercent));
    }
}
