package OOP.Sprint1.Uppgift10.ChangeLog;

public interface ChangeLogItemHandler {
    void addItemToChangeLog(ChangeLogItem changeLogItem);
    void printChangeLogItem(ChangeLogItem changeLogItem);
    void printChronologicalChangeHistory();
}
