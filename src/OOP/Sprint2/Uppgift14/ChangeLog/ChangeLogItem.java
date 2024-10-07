package OOP.Sprint2.Uppgift14.ChangeLog;

import java.util.Calendar;
import java.util.Date;

public abstract class ChangeLogItem {
    private static int changeLogItemIDCounter = 1;
    private final int changeLogItemID;
    private final Date timeOfChange;

    public ChangeLogItem() {
        this.changeLogItemID = changeLogItemIDCounter++;
        this.timeOfChange = Calendar.getInstance().getTime();
    }

    public int getChangeLogItemID() {
        return this.changeLogItemID;
    }

    public Date getTimeOfChange() {
        return this.timeOfChange;
    }

    public abstract String getLogItemContent();

    public abstract int getResponsibleEmployeeID();
}
