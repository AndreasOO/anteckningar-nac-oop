package OOP.Sprint1.Uppgift10.ChangeLog;

import java.util.ArrayList;
import java.util.List;

public class ChangeLog implements ChangeLogItemHandler {
    List<ChangeLogItem> changeLogItems;

    // Singleton pattern
    private static final ChangeLog INTEREST_CHANGE_LOG = new ChangeLog();
    // Singleton pattern
    public static ChangeLog getInstance(){
        return INTEREST_CHANGE_LOG;
    }

    private ChangeLog() {
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

    //TODO add print methods for specific changeLogItem classes, a filter on instanceof

}
