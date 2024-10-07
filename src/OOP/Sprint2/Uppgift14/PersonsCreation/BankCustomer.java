package OOP.Sprint2.Uppgift14.PersonsCreation;

import OOP.Sprint2.Uppgift14.AccountAndLoanCreation.Account;
import OOP.Sprint2.Uppgift14.AccountAndLoanCreation.Loan;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BankCustomer extends Person implements Serializable {

    private static int customerIDCounter = 1;
    private final int customerID;
    private List<Loan> loansList;
    private List<Account> accountsList;

    public BankCustomer(String name) {
        super(name);
        this.customerID = customerIDCounter++;
        loansList = new ArrayList<>();
        accountsList = new ArrayList<>();
    }

    public int getCustomerID() {
        return customerID;
    }

    public void addLoan(Loan loan) {
        loansList.add(loan);
    }

    public void addAccount(Account account) {
        accountsList.add(account);
    }

    public List<Loan> getLoansList() {
        return loansList;
    }

    public List<Account> getAccountsList() {
        return accountsList;
    }

    public void printAccounts() {
        System.out.println(String.format("Printing accounts belonging to customer ID: %s", this.getCustomerID()));
        for (Account account : accountsList) {
            account.printDetails();
        }
        System.out.println();
    }


    public void printLoans() {
        System.out.println(String.format("Printing loans belonging to customer ID: %s", this.getCustomerID()));
        for (Loan loan : loansList) {
            loan.printDetails();
        }
        System.out.println();
    }

}
