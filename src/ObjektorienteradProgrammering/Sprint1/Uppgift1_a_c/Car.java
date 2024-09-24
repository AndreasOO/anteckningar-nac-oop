package ObjektorienteradProgrammering.Sprint1.Uppgift1_a_c;

public class Car {
    private String registrationNumber;
    private String model;
    private String brand;
    private CarOwner owner;


    public Car() {
        this.registrationNumber = "DOES NOT EXIST";
        this.model = "DOES NOT EXIST";
        this.brand = "DOES NOT EXIST";

    }

    public Car(String registrationNumber, String model, String brand) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", owner=" + owner.getName() +
                '}';
    }

    public void resetOwner() {
        this.owner = null;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setOwner(CarOwner owner) {
        this.owner = owner;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public CarOwner getOwner() {
        return owner;
    }
}
