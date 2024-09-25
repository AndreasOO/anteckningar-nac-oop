package OOP.Sprint1.Uppgift2_a_d;

abstract public class Vehicle {
    private int speedInKilometersPerHour;
    private int weightInKilograms;

    Vehicle(int speedInKilometersPerHour, int weightInKilograms) {
        this.speedInKilometersPerHour = speedInKilometersPerHour;
        this.weightInKilograms = weightInKilograms;
    }

    abstract public void printMe();



    public void setSpeedInKilometersPerHour(int speedInKilometersPerHour) {
        this.speedInKilometersPerHour = speedInKilometersPerHour;
    }

    public void setWeightInKilograms(int weightInKilograms) {
        this.weightInKilograms = weightInKilograms;
    }

    public int getSpeedInKilometersPerHour() {
        return speedInKilometersPerHour;
    }

    public int getWeightInKilograms() {
        return weightInKilograms;
    }
}
