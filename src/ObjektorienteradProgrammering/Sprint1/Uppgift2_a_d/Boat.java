package ObjektorienteradProgrammering.Sprint1.Uppgift2_a_d;

public class Boat extends Vehicle implements Printable {
    private int deadWeight;

    Boat(int speedInKilometersPerHour, int weightInKilograms, int deadWeight) {
        super(speedInKilometersPerHour, weightInKilograms);
        this.deadWeight = deadWeight;
    }

    public void turn(String direction) {
        System.out.println("Turning " + direction);
    }

    @Override
    public void printMe() {
        System.out.println(String.format("Type of vehicle: %s \n" +
                        "Dead Weight: %d \n" +
                        "Speed in Kilometers per hour: %d\n" +
                        "Weight in Kilograms: %d \n", this.getClass().getSimpleName(),
                this.deadWeight,
                super.getSpeedInKilometersPerHour(),
                super.getWeightInKilograms()));
    }

    public int getDeadWeight() {
        return deadWeight;
    }

    public void setDeadWeight(int deadWeight) {
        this.deadWeight = deadWeight;
    }
}