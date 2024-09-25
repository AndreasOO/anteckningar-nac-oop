package OOP.Sprint1.Uppgift1_a_c;

public class CarOwner extends Person {
    Car ownedCar;

    CarOwner(String name, String address, int age) {
        super(name, address, age);
    }

    CarOwner(String name, String address, int age, Car ownedCar) {
        super(name, address, age);
        this.ownedCar = ownedCar;
    }

    CarOwner(Person person) {
        super(person.getName(), person.getAddress(), person.getAge());
    }


    public void buyCarFromSeller(Car car, CarOwner seller) {
        this.getOwnedCar().resetOwner();
        this.setOwnedCar(car);
        car.setOwner(this);
        seller.setOwnedCar(new Car());
    }

    public void buyCarFromRetailer(Car car) {

        this.setOwnedCar(car);
        car.setOwner(this);
    }

    public void sellCar(Car car, CarOwner buyer) {
        buyer.buyCarFromSeller(car, this);
    }


    public void setOwnedCar(Car ownedCar) {
        this.ownedCar = ownedCar;
        ownedCar.setOwner(this);
    }

    public Car getOwnedCar() {
        return ownedCar;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ownedCar=" + ownedCar.getRegistrationNumber() +
                "} ";
    }
}
