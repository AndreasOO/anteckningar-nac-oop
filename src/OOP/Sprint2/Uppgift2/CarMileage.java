package OOP.Sprint2.Uppgift2;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CarMileage {
    private double drivenKilometersNow;
    private double drivenKilometersOneYearAgo;
    private double gasolineConsumedSinceOneYear;
    private String input;
    CarMileage() {

    }

    public void setDrivenKilometersNow(double drivenKilometersNow) {
        this.drivenKilometersNow = drivenKilometersNow;
    }

    public void setDrivenKilometersOneYearAgo(double drivenKilometersOneYearAgo) {
        this.drivenKilometersOneYearAgo = drivenKilometersOneYearAgo;
    }

    public void setGasolineConsumedSinceOneYear(double gasolineConsumedSinceOneYear) {
        this.gasolineConsumedSinceOneYear = gasolineConsumedSinceOneYear;
    }

    public void getInputDrivenKilometersNow() {
        input = JOptionPane.showInputDialog("Input kilometers driven as of today");
        drivenKilometersNow = Double.parseDouble(input);
    }

    public void getInputDrivenKilometersOneYearAgo() {
        input = JOptionPane.showInputDialog("Input kilometers driven one year ago from today");
        drivenKilometersOneYearAgo = Double.parseDouble(input);
    }

    public void getInputGasolineConsumedSinceOneYear() {
        input = JOptionPane.showInputDialog("Input gasoline consumed since one year");
        gasolineConsumedSinceOneYear = Double.parseDouble(input);
    }

    public String createOutput() {
        return String.format("Kilometers driven: %s\n" +
                "Gasoline consumed: %s\n" +
                "Mileage in liters per kilometer: %s", drivenKilometersNow-drivenKilometersOneYearAgo, gasolineConsumedSinceOneYear, calculateMileageInKilometersPerLiter());
    }

    public void showOutput() {
        JOptionPane.showMessageDialog(null, createOutput());
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }



    public double calculateMileageInKilometersPerLiter() {
        return new BigDecimal(gasolineConsumedSinceOneYear/(drivenKilometersNow-drivenKilometersOneYearAgo)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
