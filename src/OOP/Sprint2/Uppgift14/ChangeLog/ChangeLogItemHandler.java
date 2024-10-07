package OOP.Sprint2.Uppgift14.ChangeLog;

public interface ChangeLogItemHandler {
    void addItemToChangeLog(ChangeLogItem changeLogItem);
    void printChangeLogItem(ChangeLogItem changeLogItem);
    void printChronologicalChangeHistory();
}
