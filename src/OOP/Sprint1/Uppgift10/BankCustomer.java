package OOP.Sprint1.Uppgift10;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer extends Person {

    private static int customerIDCounter = 1;
    private final int customerID;
    List<Loan> loansList;
    List<Account> accountsList;

    public BankCustomer(String name, int personalNumber) {
        super(name,personalNumber);
        this.customerID = customerIDCounter++;
        loansList = new ArrayList<>();
        accountsList = new ArrayList<>();
    }

    public int getCustomerID() {
        return customerID;
    }
}
