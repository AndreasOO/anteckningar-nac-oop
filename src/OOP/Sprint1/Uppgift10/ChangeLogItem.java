package OOP.Sprint1.Uppgift10;

import java.util.Calendar;
import java.util.Date;

public abstract class ChangeLogItem {
    private static int changeLogItemIDCounter = 1;
    private final int changeLogItemID;
    private Date timeOfChange;

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
}
