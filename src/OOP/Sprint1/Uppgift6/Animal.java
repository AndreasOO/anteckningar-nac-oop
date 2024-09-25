package OOP.Sprint1.Uppgift6;

abstract public class Animal {
    private final String nameOfSpecies;


    public Animal(String nameOfSpecies) {
        this.nameOfSpecies = nameOfSpecies;
    }

    public abstract void makeSound();
}
