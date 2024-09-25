package OOP.Sprint1.Uppgift6;

public class Fish extends Animal {
    public Fish(String name) {
        super(name);
    }
    @Override
    public void makeSound() {
        System.out.println("Fish sound");
    }
}
