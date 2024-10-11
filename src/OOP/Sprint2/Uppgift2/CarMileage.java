package OOP.Sprint2.Uppgift2;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CarMileage {
    private double drivenKilometersNow;
    private double drivenKilometersOneYearAgo;
    private double gasolineConsumedSinceOneYear;
    private double mileageInLiterPerKilometers;
    private String input;

    public CarMileage() {

    }

    public void runProgram() {
        getInputDrivenKilometersNow();
        getInputDrivenKilometersOneYearAgo();
        getInputGasolineConsumedSinceOneYear();
        calculateMileageInKilometersPerLiter();
        createOutput();
        showOutput();
    }




    public void getInputDrivenKilometersNow() {
        input = JOptionPane.showInputDialog("Input kilometers driven as of today");
        validateUserInput();
        drivenKilometersNow = Double.parseDouble(input);
    }

    public void getInputDrivenKilometersOneYearAgo() {
        input = JOptionPane.showInputDialog("Input kilometers driven one year ago from today");
        validateUserInput();
        drivenKilometersOneYearAgo = Double.parseDouble(input);
    }

    public void getInputGasolineConsumedSinceOneYear() {
        input = JOptionPane.showInputDialog("Input gasoline consumed since one year");
        validateUserInput();
        gasolineConsumedSinceOneYear = Double.parseDouble(input);
    }


    public void calculateMileageInKilometersPerLiter() {
        mileageInLiterPerKilometers = new BigDecimal(gasolineConsumedSinceOneYear/(drivenKilometersNow-drivenKilometersOneYearAgo)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public String createOutput() {
        return String.format("Kilometers driven: %s\n" +
                "Gasoline consumed: %s\n" +
                "Mileage in liters per kilometer: %s", drivenKilometersNow-drivenKilometersOneYearAgo, gasolineConsumedSinceOneYear, mileageInLiterPerKilometers);
    }


    public void validateUserInput() {
        if (input.matches("[^0-9]+")) {
            throw new IllegalArgumentException();
        }
    }

    public double getMileageInLiterPerKilometers() {
        return mileageInLiterPerKilometers;
    }

    public void showOutput() {
        JOptionPane.showMessageDialog(null, createOutput());
    }

    void setDrivenKilometersNow(double drivenKilometersNow) {
        this.drivenKilometersNow = drivenKilometersNow;
    }

    void setDrivenKilometersOneYearAgo(double drivenKilometersOneYearAgo) {
        this.drivenKilometersOneYearAgo = drivenKilometersOneYearAgo;
    }

    void setGasolineConsumedSinceOneYear(double gasolineConsumedSinceOneYear) {
        this.gasolineConsumedSinceOneYear = gasolineConsumedSinceOneYear;
    }

    public void setInput(String input) {
        this.input = input;
    }


}
