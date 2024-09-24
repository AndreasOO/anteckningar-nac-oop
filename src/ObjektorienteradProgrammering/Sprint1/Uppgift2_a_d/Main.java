package ObjektorienteradProgrammering.Sprint1.Uppgift2_a_d;

public class Main {
    public static void main(String[] args) {
        int speedInKMH = 12;
        int weightInKG = 15;
        int numOfGears = 6;
        Car car = new Car(speedInKMH, weightInKG, numOfGears);

        car.printMe();



        speedInKMH = 23;
        weightInKG = 3;
        int deadWeight = 200;
        Boat boat = new Boat(speedInKMH, weightInKG, deadWeight);

        boat.printMe();





    }
}
