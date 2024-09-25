package OOP.Sprint1.Uppgift6;

public class Lizard extends Reptilian {
    public Lizard(String name) {
        super(name);
    }
    @Override
    public void makeSound() {
        System.out.println("Make Lizard sound");
    }
}
