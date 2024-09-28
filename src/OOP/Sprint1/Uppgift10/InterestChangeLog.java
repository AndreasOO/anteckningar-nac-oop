package OOP.Sprint1.Uppgift10;

import java.util.ArrayList;
import java.util.List;

public class InterestChangeLog implements ChangeLogItemHandler {
    List<InterestRateAccountChangeLogItem> changeLogItems;

    public InterestChangeLog() {
        changeLogItems = new ArrayList<>();
    }

    public void addItemToChangeLog(ChangeLogItem changeLogItem) {
        if (changeLogItem instanceof InterestRateAccountChangeLogItem interestRateChangeLogItem) {
            changeLogItems.add(interestRateChangeLogItem);
//        } else {
//            throw new IllegalClassFormatException();
            //TODO add exception handling in this or calling class
        }
    }

    public void printChangeLogItem(ChangeLogItem changeLogItem) {
        if (changeLogItem instanceof InterestRateAccountChangeLogItem interestRateChangeLogItem) {
            System.out.println(interestRateChangeLogItem);
            //TODO actual print method in item class
        }
    }

    public void printChronologicalChangeHistory() {
        for (InterestRateAccountChangeLogItem interestRateChangeLogItem : changeLogItems) {
            System.out.println(interestRateChangeLogItem);
            //TODO actual print method in item class
        }

    }

}
