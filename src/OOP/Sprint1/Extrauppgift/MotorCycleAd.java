package OOP.Sprint1.Extrauppgift;


public class MotorCycleAd extends VehicleAd implements Publishable, Revenuable {
    private final double engineVolumePerCubicCentimeter;
    private final DriveType DRIVE_TYPE;
    private int rebateInPercent = 10;
    private final double rebateInDecimal = rebateInPercent / 100.0;

    MotorCycleAd(double price, String header, String description, int modelYear, double mileage, double engineVolumePerCubicCentimeter, DriveType driveType) {
        super(price,header,description,modelYear,mileage);
        this.engineVolumePerCubicCentimeter = engineVolumePerCubicCentimeter;
        this.DRIVE_TYPE = driveType;
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
                "Engine Volume: %.0f cm3\n" +
                "Drive Type: %s\n" +
                "Description: %s\n",super.createHeader(), super.getModelYear(), super.getMileageInKilometers(), this.engineVolumePerCubicCentimeter, this.DRIVE_TYPE.DESCRIPTION, super.getDescription());
    }

    @Override
    public double calculateRevenue() {
        return (super.getPrice() / (1.00+getVatInDecimal()))*(1.00-this.rebateInDecimal);
    }

}
