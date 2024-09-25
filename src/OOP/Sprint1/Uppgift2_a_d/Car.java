package OOP.Sprint1.Uppgift2_a_d;

public class Car extends Vehicle implements Printable, Wheelborn {

    private int numberOfGears;
    private int currentGear;
    private int numberOfWheels;

    Car(int speedInKilometersPerHour, int weightInKilograms, int numberOfGears, int numberOfWheels) {
        super(speedInKilometersPerHour, weightInKilograms);
        this.numberOfGears = numberOfGears;
        this.currentGear = 1;
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public void printMe() {
        System.out.println(String.format("Type of vehicle: %s \n" +
                                         "Number of gears: %d \n" +
                                         "Current gear: %d\n" +
                                         "Speed in Kilometers per hour: %d\n" +
                                         "Weight in Kilograms: %d \n" +
                                         "Number of wheels: %d\n" , this.getClass().getSimpleName(),
                                                                        this.numberOfGears,
                                                                        this.currentGear,
                                                                        super.getSpeedInKilometersPerHour(),
                                                                        super.getWeightInKilograms(),
                                                                        this.numberOfWheels));
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void shiftGear(int newGear)  {
        if (newGear > 0 && newGear <= numberOfGears) {
            currentGear = newGear;
        } else {
            System.out.println("Invalid Gear");
        }
    }

    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public int getCurrentGear() {
        return currentGear;
    }
}
