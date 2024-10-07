package OOP.Sprint2.Uppgift14;

import OOP.Sprint2.Uppgift14.AccountAndLoanCreation.Account;
import OOP.Sprint2.Uppgift14.AccountAndLoanCreation.Loan;
import OOP.Sprint2.Uppgift14.ChangeLog.ChangeLog;
import OOP.Sprint2.Uppgift14.PersonsCreation.BankCustomer;
import OOP.Sprint2.Uppgift14.PersonsCreation.BankStaff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/OOP/Sprint2/Uppgift14/database.ser"))) {
            out.writeObject(customer1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        customer1.printAccounts();

        List<BankCustomer> customerList = new ArrayList<>();
        customerList.add(customer1);


        BankCustomer customer2;


        try (ObjectInputStream out = new ObjectInputStream(new FileInputStream("src/OOP/Sprint2/Uppgift14/database.ser"))) {
            customer2 = (BankCustomer) out.readObject();
            customerList.add(customer2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
