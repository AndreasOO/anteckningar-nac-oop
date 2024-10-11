package OOP.Sprint2.Uppgift2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarMileageTest {

    CarMileage carMileage = new CarMileage();



    @Test
    void validateInput() {
        carMileage.setInput("dasda");
        assertThrows(IllegalArgumentException.class, () -> {
            carMileage.validateUserInput();
        });
    }

    @Test
    void calculateMileage() {

        carMileage.setDrivenKilometersNow(1487);
        carMileage.setDrivenKilometersOneYearAgo(0);
        carMileage.setGasolineConsumedSinceOneYear(1235.4);
        carMileage.calculateMileageInKilometersPerLiter();
        assertEquals(0.83, carMileage.getMileageInLiterPerKilometers());
    }

    @Test
    void createOutput() {
        carMileage.setDrivenKilometersNow(1487);
        carMileage.setDrivenKilometersOneYearAgo(0);
        carMileage.setGasolineConsumedSinceOneYear(1235.4);
        carMileage.calculateMileageInKilometersPerLiter();

        assertEquals("Kilometers driven: 1487.0\n" +
                             "Gasoline consumed: 1235.4\n" +
                             "Mileage in liters per kilometer: 0.83", carMileage.createOutput());
    }


}