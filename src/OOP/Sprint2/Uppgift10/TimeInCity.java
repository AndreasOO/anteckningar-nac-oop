package OOP.Sprint2.Uppgift10;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

public class TimeInCity {
    private LocalTime localTime;
    private String city;
    private Map<String,ZoneId> cityZoneIDmap;
    private ZoneId timeZone;

    public TimeInCity(String city) {
        initializeMap();
        this.city = city;
        this.timeZone = cityZoneIDmap.get(city.toLowerCase());
    }

    private void initializeMap() {
        cityZoneIDmap = new HashMap<>();
        cityZoneIDmap.put("toronto", ZoneId.of("America/Toronto"));
        cityZoneIDmap.put("stockholm", ZoneId.of("Europe/Stockholm"));
        cityZoneIDmap.put("shanghai", ZoneId.of("Asia/Shanghai"));
    }

    public String getTimeInHoursMinutesSeconds() {
        this.localTime = LocalTime.now(this.timeZone);
        return String.format("%02d:%02d:%02d", localTime.getHour(),
                localTime.getMinute(),
                localTime.getSecond());
    }

    public ZoneId getTimeZone() {
        return timeZone;
    }
}
