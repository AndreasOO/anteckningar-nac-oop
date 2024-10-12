package OOP.Sprint2.Uppgift14.ChangeLog;

import OOP.Sprint2.Uppgift14.PersonsCreation.BankStaff;

import java.util.ArrayList;
import java.util.List;


/**
 * Singleton class for the changelog. It is instantiated with a private constructor when the program runs and the single
 * instance can be accessed only through the getInstance static method.
 */
public class ChangeLog implements ChangeLogItemHandler {
    List<ChangeLogItem> changeLogItems;


    private static final ChangeLog CHANGE_LOG = new ChangeLog();

    public static ChangeLog getInstance(){
        return CHANGE_LOG;
    }

    private ChangeLog() {
        changeLogItems = new ArrayList<>();
    }


    public String[] createHeadersForJList() {
        List<String> list = new ArrayList<>();
        for (ChangeLogItem changeLogItem : changeLogItems) {
            if (changeLogItem instanceof JListHeadingFormatable formatableItem) {
                list.add(formatableItem.createHeader());
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public String[] createHeadersForJListFilterByEmployeeID(int id) {
        List<String> list = new ArrayList<>();
        for (ChangeLogItem changeLogItem : changeLogItems) {
            if (changeLogItem.getResponsibleEmployeeID() != id) {
                continue;
            }
            if (changeLogItem instanceof JListHeadingFormatable formatableItem) {
                list.add(formatableItem.createHeader());
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public String[] createHeadersForJListFilterByLoanApproval() {
        List<String> list = new ArrayList<>();
        for (ChangeLogItem changeLogItem : changeLogItems) {
            if (!(changeLogItem instanceof LoanApprovalChangeLogItem)) {
                continue;
            }
            if (changeLogItem instanceof JListHeadingFormatable formatableItem) {
                list.add(formatableItem.createHeader());
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public String[] createHeadersForJListFilterByCreatedAccounts() {
        List<String> list = new ArrayList<>();
        for (ChangeLogItem changeLogItem : changeLogItems) {
            if (!(changeLogItem instanceof AccountCreationChangeLogItem)) {
                continue;
            }
            if (changeLogItem instanceof JListHeadingFormatable formatableItem) {
                list.add(formatableItem.createHeader());
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public String[] createHeadersForJListFilterByLoanInterestChange() {
        List<String> list = new ArrayList<>();
        for (ChangeLogItem changeLogItem : changeLogItems) {
            if (!(changeLogItem instanceof LoanInterestRateChangeLogItem)) {
                continue;
            }
            if (changeLogItem instanceof JListHeadingFormatable formatableItem) {
                list.add(formatableItem.createHeader());
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public String[] createHeadersForJListFilterByAccountInterestChange() {
        List<String> list = new ArrayList<>();
        for (ChangeLogItem changeLogItem : changeLogItems) {
            if (!(changeLogItem instanceof AccountInterestRateChangeLogItem)) {
                continue;
            }
            if (changeLogItem instanceof JListHeadingFormatable formatableItem) {
                list.add(formatableItem.createHeader());
            }
        }
        return list.toArray(new String[list.size()]);
    }


    // BY ID
    public String[] createHeadersForJListFilterByLoanApprovalAndEmployeeID(int id) {
        List<String> list = new ArrayList<>();
        for (ChangeLogItem changeLogItem : changeLogItems) {
            if (changeLogItem.getResponsibleEmployeeID() != id) {
                continue;
            }
            if (!(changeLogItem instanceof LoanApprovalChangeLogItem)) {
                continue;
            }
            if (changeLogItem instanceof JListHeadingFormatable formatableItem) {
                list.add(formatableItem.createHeader());
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public String[] createHeadersForJListFilterByCreatedAccountsAndEmployeeID(int id) {
        List<String> list = new ArrayList<>();
        for (ChangeLogItem changeLogItem : changeLogItems) {
            if (changeLogItem.getResponsibleEmployeeID() != id) {
                continue;
            }
            if (!(changeLogItem instanceof AccountCreationChangeLogItem)) {
                continue;
            }
            if (changeLogItem instanceof JListHeadingFormatable formatableItem) {
                list.add(formatableItem.createHeader());
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public String[] createHeadersForJListFilterByLoanInterestChangeAndEmployeeID(int id) {
        List<String> list = new ArrayList<>();
        for (ChangeLogItem changeLogItem : changeLogItems) {
            if (changeLogItem.getResponsibleEmployeeID() != id) {
                continue;
            }
            if (!(changeLogItem instanceof LoanInterestRateChangeLogItem)) {
                continue;
            }
            if (changeLogItem instanceof JListHeadingFormatable formatableItem) {
                list.add(formatableItem.createHeader());
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public String[] createHeadersForJListFilterByAccountInterestChangeAndEmployeeID(int id) {
        List<String> list = new ArrayList<>();
        for (ChangeLogItem changeLogItem : changeLogItems) {
            if (changeLogItem.getResponsibleEmployeeID() != id) {
                continue;
            }
            if (!(changeLogItem instanceof AccountInterestRateChangeLogItem)) {
                continue;
            }
            if (changeLogItem instanceof JListHeadingFormatable formatableItem) {
                list.add(formatableItem.createHeader());
            }
        }
        return list.toArray(new String[list.size()]);
    }

    @Override
    public void addItemToChangeLog(ChangeLogItem changeLogItem) {
            changeLogItems.add(changeLogItem);
    }

    @Override
    public void printChangeLogItem(ChangeLogItem changeLogItem) {
        System.out.println(changeLogItem.getLogItemContent());
    }

    public String getLogItemContentByID(int id) {
        for (ChangeLogItem changeLogItem : changeLogItems) {
            if (changeLogItem.getChangeLogItemID() == id) {
                return changeLogItem.getLogItemContent();
            }
        } return null;
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
