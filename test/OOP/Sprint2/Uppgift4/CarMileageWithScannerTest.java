package OOP.Sprint2.Uppgift4;

import OOP.Sprint2.Uppgift2.CarMileage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarMileageWithScannerTest {

    CarMileageWithScanner carMileage = new CarMileageWithScanner();




    @Test
    void createOutput() {
        carMileage.setDrivenKilometersNow(1487);
        carMileage.setDrivenKilometersOneYearAgo(0);
        carMileage.setGasolineConsumedSinceOneYear(1235.4);

        assertEquals("Kilometers driven: 1487.0\n" +
                "Gasoline consumed: 1235.4\n" +
                "Mileage in liters per kilometer: 0.83", carMileage.createOutput());
    }

    @Test
    void calculateMileage() {

        carMileage.setDrivenKilometersNow(1487);
        carMileage.setDrivenKilometersOneYearAgo(0);
        carMileage.setGasolineConsumedSinceOneYear(1235.4);
        assertEquals(0.83, carMileage.calculateMileageInKilometersPerLiter());
    }

}