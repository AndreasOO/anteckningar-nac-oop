package OOP.Sprint2.Uppgift14.BankInteractions;

import OOP.Sprint2.Uppgift14.AccountAndLoanCreation.Account;
import OOP.Sprint2.Uppgift14.AccountAndLoanCreation.Loan;
import OOP.Sprint2.Uppgift14.ChangeLog.ChangeLog;
import OOP.Sprint2.Uppgift14.GUI.BankStaffGUI;
import OOP.Sprint2.Uppgift14.PersonsCreation.BankCustomer;
import OOP.Sprint2.Uppgift14.PersonsCreation.BankStaff;
import OOP.Sprint2.Uppgift14.Storage.StorageLoader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<BankStaff> staffList = StorageLoader.getInstance().getBankStaffList();
        List<BankCustomer> customerList = StorageLoader.getInstance().getBankCustomerList();



        ChangeLog.getInstance().createHeadersForJList();

        BankCustomer customer1 = customerList.getFirst();
        BankStaff staff1 = staffList.getFirst();
        BankAdministration bankAdmin = new BankAdministration(staff1);

        BankStaff staff2 = staffList.getLast();
        BankAdministration bankAdmin2 = new BankAdministration(staff2);





        bankAdmin.handleAccountCreation(10000, 5, customer1);
        Account account = customer1.getAccountsList().getFirst();
        bankAdmin.handleAccountInterestChange(12, account);
        bankAdmin.handleLoanApproval(50000, 7.5, customer1);
        Loan loan = customer1.getLoansList().getFirst();
        bankAdmin.handleLoanInterestChange(5, loan);

        bankAdmin2.handleAccountCreation(10000, 5, customer1);
        Account account2 = customer1.getAccountsList().getLast();
        bankAdmin2.handleAccountInterestChange(12, account2);
        bankAdmin2.handleLoanApproval(50000, 7.5, customer1);
        Loan loan2 = customer1.getLoansList().getFirst();
        bankAdmin2.handleLoanInterestChange(5, loan2);

        ChangeLog.getInstance().printChronologicalChangeHistory();

        customer1.printAccounts();
        customer1.printLoans();



        BankStaffGUI gui = new BankStaffGUI(staff1);
        gui.init();

















    }
}
