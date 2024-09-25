package OOP.Sprint1.Uppgift6;

public class Salmon extends Fish {
    public Salmon(String name) {
        super(name);
    }
    @Override
    public void makeSound() {
        System.out.println("Make Salmon sound");
    }
}
