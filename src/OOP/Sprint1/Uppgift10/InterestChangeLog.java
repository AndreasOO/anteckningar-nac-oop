package OOP.Sprint1.Uppgift10;

import java.util.ArrayList;
import java.util.List;

public class InterestChangeLog implements ChangeLogItemHandler {
    List<ChangeLogItem> changeLogItems;

    public InterestChangeLog() {
        changeLogItems = new ArrayList<>();
    }

    public void addItemToChangeLog(ChangeLogItem changeLogItem) {
            changeLogItems.add(changeLogItem);
    }

    public void printChangeLogItem(ChangeLogItem changeLogItem) {
        System.out.println(changeLogItem.getLogContent());
    }

    // TODO fix sorting with comparator class and date comparison of the time of change variable.
    public void printChronologicalChangeHistory() {
        for (ChangeLogItem changeLogItem : changeLogItems) {
            printChangeLogItem(changeLogItem);
        }
    }

}
