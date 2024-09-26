package OOP.Sprint1.Uppgift10;

import java.util.ArrayList;

public class BankStaff extends Person {
    private static int employmentIDCounter = 1;

    private final int employmentID;
    private double salary;

    public BankStaff(String name, int personalNumber, double salary) {
        super(name,personalNumber);
        this.employmentID = employmentIDCounter++;
        this.salary = salary;
    }

    public int getEmploymentID() {
        return employmentID;
    }
}
