package OOP.Sprint1.Extrauppgift;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class CamperAdTest {



    CamperAd camperAd = new CamperAd(100.0, "header", "description", 1967, 2000, Shower.INDOOR_WATERFALL, 3);




    @Test
    void createCompleteAd() {
        assertEquals("header, 100.00 kr\n" +
                             "Model year: 1967\n" +
                             "Mileage in Kilometers: 2000\n" +
                             "Shower: Indoor Waterfall Shower\n" +
                             "Number of beds: 3\n" +
                             "Description: description\n", camperAd.createCompleteAd());
    }

    @Test
    void createHeader() {
        assertEquals("header, 100.00 kr", camperAd.createHeader());
    }

    @Test
    void calculateRevenue() {
        assertEquals(80.00, camperAd.calculateRevenue());
    }
}