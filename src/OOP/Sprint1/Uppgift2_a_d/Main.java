package OOP.Sprint1.Uppgift2_a_d;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int speedInKMH = 12;
        int weightInKG = 15;
        int numOfGears = 6;
        int numOfWheels = 4;
        Car car = new Car(speedInKMH, weightInKG, numOfGears, numOfWheels);
        System.out.println(car.getCurrentGear());
        car.shiftGear(4);
        car.shiftGear(7);
        System.out.println(car.getCurrentGear());
        car.printMe();



        speedInKMH = 23;
        weightInKG = 3;
        int deadWeight = 200;
        Boat boat = new Boat(speedInKMH, weightInKG, deadWeight);
        boat.turn("Left");
        boat.turn("Right");
        boat.printMe();




        speedInKMH = 21;
        weightInKG = 544;
        int numberOfCarts = 4;
        Train train = new Train(speedInKMH, weightInKG, deadWeight);
        System.out.println(train.getNumberOfCarts());
        train.connectCart();
        train.printMe();


        speedInKMH = 12;
        weightInKG = 38;
        numOfGears = 18;
        numOfWheels = 2;
        Bike bike = new Bike(speedInKMH, weightInKG, numOfGears, numOfWheels);
        System.out.println(bike.getCurrentGear());
        bike.shiftGear(3);
        bike.shiftGear(19);
        System.out.println(bike.getCurrentGear());
        bike.printMe();

        List<Printable> list = new ArrayList<>();
        list.add(car);
        list.add(boat);
        list.add(train);
        list.add(bike);


        System.out.println("\nLOOPING HERE WITH PRINTABLE METHOD CALL\n");


        for (Printable printable : list) {
            printable.printMe();
        }


    }
}
