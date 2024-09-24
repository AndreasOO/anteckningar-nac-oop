package ObjektorienteradProgrammering.Sprint1.Uppgift1_a_c;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("person1", "address1", 1);
        Person person2 = new Person("person2", "address2", 2);

        CarOwner carOwner1 = new CarOwner(person1);
        CarOwner carOwner2 = new CarOwner(person2);

        Car car1 = new Car("111", "111", "111");
        Car car2 = new Car("222", "222", "222");


        carOwner1.setOwnedCar(car1);
        carOwner2.setOwnedCar(car2);

        carOwner2.buyCarFromSeller(car1, carOwner1);

        System.out.println("After sale");
        System.out.println(carOwner1.toString());
        System.out.println(carOwner2.toString());


        carOwner2.sellCar(car1, carOwner1);


        System.out.println("After sale");
        System.out.println(carOwner1.toString());
        System.out.println(carOwner2.toString());


        carOwner2.buyCarFromRetailer(car2);
        System.out.println("After sale");
        System.out.println(carOwner1.toString());
        System.out.println(carOwner2.toString());

    }
}
