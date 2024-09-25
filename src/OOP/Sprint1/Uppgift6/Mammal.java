package OOP.Sprint1.Uppgift6;

public class Mammal extends Animal {
    public Mammal(String name) {
        super(name);
    }
    @Override
    public void makeSound() {
        System.out.println("Mammal sound");
    }
}
