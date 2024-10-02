package OOP.Sprint1.Extrauppgift;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class CarAdTest {

    CarAd carAd = new CarAd(100.0, "header", "description", 1967, 2000, Colors.BLUE, Tires.SUMMER_TIRES);



    @Test
    void createCompleteAd() {
        assertEquals("header, 100.00 kr\n" +
                "Model year: 1967\n" +
                "Mileage in Kilometers: 2000\n" +
                "Color: Blue\n" +
                "Tires: Summer Tires\n" +
                "Description: description\n", carAd.createCompleteAd());
    }

    @Test
    void createHeader() {
        assertEquals("header, 100.00 kr", carAd.createHeader());
    }

    @Test
    void calculateRevenue() {
        assertEquals(80.00, carAd.calculateRevenue());
    }
}