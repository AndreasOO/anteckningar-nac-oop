package OOP.Sprint1.Uppgift10.ChangeLog;

import OOP.Sprint1.Uppgift10.AccountAndLoanCreation.InterestBearing;
import OOP.Sprint1.Uppgift10.PersonsCreation.BankStaff;

import java.util.ArrayList;
import java.util.List;


/**
 * Singleton class for the changelog. It is instantiated with a private constructor when the program runs and the single
 * instance can be accessed only through the getInstance static method.
 */
public class ChangeLog implements ChangeLogItemHandler {
    List<ChangeLogItem> changeLogItems;


    private static final ChangeLog INTEREST_CHANGE_LOG = new ChangeLog();

    public static ChangeLog getInstance(){
        return INTEREST_CHANGE_LOG;
    }

    private ChangeLog() {
        changeLogItems = new ArrayList<>();
    }

    @Override
    public void addItemToChangeLog(ChangeLogItem changeLogItem) {
            changeLogItems.add(changeLogItem);
    }

    @Override
    public void printChangeLogItem(ChangeLogItem changeLogItem) {
        System.out.println(changeLogItem.getLogItemContent());
    }

    // TODO fix sorting with comparator class and date comparison of the time of change variable.
    @Override
    public void printChronologicalChangeHistory() {
        for (ChangeLogItem changeLogItem : changeLogItems) {
            printChangeLogItem(changeLogItem);
        }
    }


    public void printLoansApprovedByEmployee(BankStaff bankstaff) {
        System.out.println(String.format("Printing Loans approved by employee ID: %s", bankstaff.getEmploymentID()));
        for (ChangeLogItem changeLogItem : changeLogItems) {
            if (changeLogItem instanceof LoanApprovalChangeLogItem && changeLogItem.getResponsibleEmployeeID() == bankstaff.getEmploymentID()) {
                System.out.println(changeLogItem.getLogItemContent());
            }
        }
    }

    public void printAccountsCreatedByEmployee(BankStaff bankstaff) {
        System.out.println(String.format("Printing Accounts created by employee ID: %s", bankstaff.getEmploymentID()));
        for (ChangeLogItem changeLogItem : changeLogItems) {
            if (changeLogItem instanceof AccountCreationChangeLogItem && changeLogItem.getResponsibleEmployeeID() == bankstaff.getEmploymentID()) {
                System.out.println(changeLogItem.getLogItemContent());
            }
        }
    }

    public void printLoanInterestRateChangesApprovedByEmployee(BankStaff bankstaff) {
        System.out.println(String.format("Printing Loan interest rate changes approved by employee ID: %s", bankstaff.getEmploymentID()));
        for (ChangeLogItem changeLogItem : changeLogItems) {
            if (changeLogItem instanceof LoanInterestRateChangeLogItem && changeLogItem.getResponsibleEmployeeID() == bankstaff.getEmploymentID()) {
                System.out.println(changeLogItem.getLogItemContent());
            }
        }
    }

    public void printAccountInterestRateChangesApprovedByEmployee(BankStaff bankstaff) {
        System.out.println(String.format("Printing Account interest rate changes approved by employee ID: %s", bankstaff.getEmploymentID()));
        for (ChangeLogItem changeLogItem : changeLogItems) {
            if (changeLogItem instanceof AccountInterestRateChangeLogItem && changeLogItem.getResponsibleEmployeeID() == bankstaff.getEmploymentID()) {
                System.out.println(changeLogItem.getLogItemContent());
            }
        }
    }

    //TODO add print methods for specific changeLogItem classes, a filter on instanceof


}
