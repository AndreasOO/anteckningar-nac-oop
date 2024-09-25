package OOP.Sprint1.Uppgift6;

public class Avian extends Animal {
    public Avian(String name) {
        super(name);
    }
    @Override
    public void makeSound() {
        System.out.println("Avian sound");
    }
}
