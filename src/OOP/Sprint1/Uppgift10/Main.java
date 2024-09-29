package OOP.Sprint1.Uppgift10;

import OOP.Sprint1.Uppgift10.AccountAndLoanCreation.Account;
import OOP.Sprint1.Uppgift10.AccountAndLoanCreation.AccountCreator;
import OOP.Sprint1.Uppgift10.AccountAndLoanCreation.Loan;
import OOP.Sprint1.Uppgift10.AccountAndLoanCreation.LoanApprover;

public class Main {
    public static void main(String[] args) {
        Loan loan = LoanApprover.approveLoan(200,12,5);
        Account account = AccountCreator.createNewAccount(200,12,5);


    }
}
