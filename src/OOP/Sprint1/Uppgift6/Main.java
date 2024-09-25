package OOP.Sprint1.Uppgift6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Mammal mammal = new Mammal("mammal species");
        Avian avian = new Avian("avian species");
        Reptilian reptilian = new Reptilian("reptilian species");
        Fish fish = new Fish("fish species");
        Human human = new Human("human species");
        Seagull seagull = new Seagull ("seagull species");
        Lizard lizard = new Lizard("lizard species");
        Salmon salmon = new Salmon("salmon species");

        List<Animal> list = new ArrayList<>();
        list.add(mammal);
        list.add(avian);
        list.add(reptilian);
        list.add(fish);
        list.add(human);
        list.add(seagull);
        list.add(lizard);
        list.add(salmon);

        for (Animal animal : list) {
            animal.makeSound();
        }
    }
}
