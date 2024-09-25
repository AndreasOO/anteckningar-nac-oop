package OOP.Sprint1.Uppgift6;

public class Reptilian extends Animal {
    public Reptilian(String name) {
        super(name);
    }
    @Override
    public void makeSound() {
        System.out.println("Reptilian sound");
    }
}
