package OOP.Sprint2.Uppgift14.Storage;

import OOP.Sprint2.Uppgift14.PersonsCreation.BankCustomer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRoster {
    private List<BankCustomer> customers;

    private final static CustomerRoster CUSTOMER_ROSTER = new CustomerRoster();


    private CustomerRoster() {
        customers = new ArrayList<>();
        customers.add(new BankCustomer("Andreas Ohlander"));
        customers.add(new BankCustomer("Micke Mouse"));
        customers.add(new BankCustomer("Donald Drump"));
        customers.add(new BankCustomer("Pixy Malone"));
        customers.add(new BankCustomer("Fat Joe"));
        customers.add(new BankCustomer("Tally Racket"));
        customers.add(new BankCustomer("Finley Poh"));
        customers.add(new BankCustomer("Dark Evil"));
        customers.add(new BankCustomer("Long Island"));
        customers.add(new BankCustomer("Name Forgot"));
        customers.add(new BankCustomer("Margot Willstrom"));
        customers.add(new BankCustomer("Ulrika Kempe"));
        customers.add(new BankCustomer("Dennis Loppa"));
        customers.add(new BankCustomer("Doland Dark"));
        customers.add(new BankCustomer("Yerl Herl"));
        customers.add(new BankCustomer("Tacky Lacky"));

    }

    protected static CustomerRoster getInstance() {
        return CUSTOMER_ROSTER;
    }

    protected List<BankCustomer> getCustomers() {
        return customers;
    }

}
