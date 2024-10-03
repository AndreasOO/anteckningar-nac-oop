package OOP.Sprint2.Uppgift4;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CarMileageWithScanner {
    private double drivenKilometersNow;
    private double drivenKilometersOneYearAgo;
    private double gasolineConsumedSinceOneYear;
    private String input;
    private Scanner scanner;
    CarMileageWithScanner() {
        scanner = new Scanner(System.in);
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
        System.out.println("Input kilometers driven as of today");
        input = scanner.nextLine();
        drivenKilometersNow = Double.parseDouble(input);
    }

    public void getInputDrivenKilometersOneYearAgo() {
        System.out.println("Input kilometers driven one year ago from today");
        input = scanner.nextLine();
        drivenKilometersOneYearAgo = Double.parseDouble(input);
    }

    public void getInputGasolineConsumedSinceOneYear() {
        System.out.println("Input gasoline consumed since one year");
        input = scanner.nextLine();
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
