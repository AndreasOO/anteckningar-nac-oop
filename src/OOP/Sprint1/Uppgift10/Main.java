package OOP.Sprint1.Uppgift10;

import OOP.Sprint1.Uppgift10.AccountAndLoanCreation.Account;
import OOP.Sprint1.Uppgift10.AccountAndLoanCreation.Loan;
import OOP.Sprint1.Uppgift10.ChangeLog.ChangeLog;
import OOP.Sprint1.Uppgift10.PersonsCreation.BankCustomer;
import OOP.Sprint1.Uppgift10.PersonsCreation.BankStaff;

public class Main {
    public static void main(String[] args) {



        BankCustomer customer1 = new BankCustomer("Andreas Ohlander");
        BankStaff staff1 = new BankStaff("Laran Matta", 39000);




        staff1.handleAccountCreation(10000, 5, customer1);
        Account account = customer1.getAccountsList().getFirst();
        staff1.handleAccountInterestChange(12, account);



        staff1.handleLoanApproval(50000, 7.5, customer1);
        Loan loan = customer1.getLoansList().getFirst();
        staff1.handleLoanInterestChange(5, loan);


        ChangeLog.getInstance().printChronologicalChangeHistory();

        customer1.printAccounts();
        customer1.printLoans();


    }
}
