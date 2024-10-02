package OOP.Sprint1.Extrauppgift;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class MotorCycleAdTest {

    MotorCycleAd motorCycleAd = new MotorCycleAd(100.0, "header", "description", 1967, 2000, 500, DriveType.CARDAN);



    @Test
    void createCompleteAd() {
        assertEquals("header, 100.00 kr\n" +
                "Model year: 1967\n" +
                "Mileage in Kilometers: 2000\n" +
                "Engine Volume: 500 cm3\n" +
                "Drive Type: Cardan Driven\n" +
                "Description: description\n", motorCycleAd.createCompleteAd());
    }

    @Test
    void createHeader() {
        assertEquals("header, 100.00 kr", motorCycleAd.createHeader());
    }


    @Test
    void calculateRevenue() {
        assertEquals(72.00, motorCycleAd.calculateRevenue());
    }
}