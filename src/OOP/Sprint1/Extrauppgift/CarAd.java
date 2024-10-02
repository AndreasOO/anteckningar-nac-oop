package OOP.Sprint1.Extrauppgift;


public class CarAd extends VehicleAd implements Publishable, Revenuable {
    private Colors COLOR;
    private Tires TIRES;

    CarAd(double price, String header, String description, int modelYear, double mileage, Colors color, Tires tires) {
        super(price,header,description,modelYear,mileage);
        this.COLOR = color;
        this.TIRES = tires;
    }

    @Override
    public void printHeader(){
        System.out.println(createHeader());
    }



    @Override
    public void printCompleteAd() {

    }

    public String createCompleteAd() {
        return String.format("%s\n" +
                "Model year: %s\n" +
                "Mileage in Kilometers: %.0f\n" +
                "Color: %s\n" +
                "Tires: %s\n" +
                "Description: %s\n",super.createHeader(), super.getModelYear(), super.getMileageInKilometers(), this.COLOR.DESCRIPTION, this.TIRES.DESCRIPTION, super.getDescription());
    }

    @Override
    public double calculateRevenue() {
        return (super.getPrice() / (1.00+getVatInDecimal()));
    }

}
