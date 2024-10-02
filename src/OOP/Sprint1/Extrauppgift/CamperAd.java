package OOP.Sprint1.Extrauppgift;


public class CamperAd extends VehicleAd implements Publishable, Revenuable {
        private final Shower SHOWER;
        private final int NUMBER_OF_BEDS;

    CamperAd(double price, String header, String description, int modelYear, double mileage, Shower shower, int numberOfBeds) {
        super(price,header,description,modelYear,mileage);
        this.SHOWER = shower;
        this.NUMBER_OF_BEDS = numberOfBeds;
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
                "Shower: %s\n" +
                "Number of beds: %s\n" +
                "Description: %s\n",super.createHeader(), super.getModelYear(), super.getMileageInKilometers(), this.SHOWER.DESCRIPTION, this.NUMBER_OF_BEDS, super.getDescription());
    }

    @Override
    public double calculateRevenue() {
        return (super.getPrice() / (1.00+getVatInDecimal()));
    }

}

