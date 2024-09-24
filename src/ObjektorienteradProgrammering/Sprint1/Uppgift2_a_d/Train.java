package ObjektorienteradProgrammering.Sprint1.Uppgift2_a_d;

public class Train extends Vehicle {
    private int numberOfCarts;

    Train(int speedInKilometersPerHour, int weightInKilograms, int numberOfCarts) {
        super(speedInKilometersPerHour, weightInKilograms);
        this.numberOfCarts = numberOfCarts;
    }

    @Override
    public void printMe() {
        System.out.println(String.format("Type of vehicle: %s \n" +
                        "Number of carts: %d \n" +
                        "Speed in Kilometers per hour: %d\n" +
                        "Weight in Kilograms: %d \n", this.getClass().getSimpleName(),
                this.numberOfCarts,
                super.getSpeedInKilometersPerHour(),
                super.getWeightInKilograms()));
    }


    public void connectCart() {
        this.numberOfCarts++;
    }



    public void setNumberOfCarts(int numberOfCarts) {
        this.numberOfCarts = numberOfCarts;
    }

    public int getNumberOfCarts() {
        return numberOfCarts;
    }
}
