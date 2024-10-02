package OOP.Sprint1.Extrauppgift;

public abstract class VehicleAd {
    private final double price;
    private final String header;
    private final String description;
    private final int modelYear;
    private final double mileageInKilometers;

    public VehicleAd(double price, String header, String description, int modelYear, double mileage) {
        this.price = price;
        this.header = header;
        this.description = description;
        this.modelYear = modelYear;
        this.mileageInKilometers = mileage;
    }

    public String createHeader() {
        return String.format("%s, %.2f kr", getHeader(), getPrice());
    }

    public double getPrice() {
        return price;
    }

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    public int getModelYear() {
        return modelYear;
    }

    public double getMileageInKilometers() {
        return mileageInKilometers;
    }
}



