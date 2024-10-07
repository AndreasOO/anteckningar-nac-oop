package OOP.Sprint2.Uppgift14;

import OOP.Sprint2.Uppgift14.AccountAndLoanCreation.Account;
import OOP.Sprint2.Uppgift14.AccountAndLoanCreation.Loan;
import OOP.Sprint2.Uppgift14.ChangeLog.ChangeLog;
import OOP.Sprint2.Uppgift14.PersonsCreation.BankCustomer;
import OOP.Sprint2.Uppgift14.PersonsCreation.BankStaff;
import OOP.Sprint2.Uppgift14.Storage.CustomerRoster;
import OOP.Sprint2.Uppgift14.Storage.StaffRoster;
import OOP.Sprint2.Uppgift14.Storage.StorageLoader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BankStaff> staffList = StorageLoader.getInstance().getBankStaffList();
        List<BankCustomer> customerList = StorageLoader.getInstance().getBankCustomerList();


        BankCustomer customer1 = customerList.getFirst();
        BankStaff staff1 = staffList.getFirst();




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
