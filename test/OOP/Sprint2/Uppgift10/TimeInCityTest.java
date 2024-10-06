package OOP.Sprint2.Uppgift10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TimeInCityTest {


    TimeInCity timeInCityStockholm = new TimeInCity("Stockholm");
    TimeInCity timeInCityToronto = new TimeInCity("Toronto");
    TimeInCity timeInCityShanghai = new TimeInCity("Shanghai");
    @Test
    void getTimeInHoursMinutesSeconds() {
        assertTrue(timeInCityStockholm.getTimeInHoursMinutesSeconds().matches("([0-1][0-9]|2[0-4]):[0-5][0-9]:[0-5][0-9]"));
        assertTrue(timeInCityToronto.getTimeInHoursMinutesSeconds().matches("([0-1][0-9]|2[0-4]):[0-5][0-9]:[0-5][0-9]"));
        assertTrue(timeInCityShanghai.getTimeInHoursMinutesSeconds().matches("([0-1][0-9]|2[0-4]):[0-5][0-9]:[0-5][0-9]"));
    }

    @Test
    void getTimeZone() {
        assertEquals("Europe/Stockholm", timeInCityStockholm.getTimeZone().toString());
        assertEquals("America/Toronto", timeInCityToronto.getTimeZone().toString());
        assertEquals("Asia/Shanghai", timeInCityShanghai.getTimeZone().toString());
    }
}