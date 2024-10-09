package OOP.Sprint2.Uppgift14.PersonsCreation;

import OOP.Sprint2.Uppgift14.AccountAndLoanCreation.Account;
import OOP.Sprint2.Uppgift14.AccountAndLoanCreation.AccountCreator;
import OOP.Sprint2.Uppgift14.AccountAndLoanCreation.Loan;
import OOP.Sprint2.Uppgift14.AccountAndLoanCreation.LoanApprover;
import OOP.Sprint2.Uppgift14.ChangeLog.ChangeLog;
import OOP.Sprint2.Uppgift14.ChangeLog.ChangeLogItemRegistrator;

import java.io.Serializable;

public class BankStaff extends Person implements Serializable {
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



    @Override
    public String toString() {
        return "BankStaff{" +
                "employmentID=" + employmentID +
                "} " + super.toString();
    }
}
