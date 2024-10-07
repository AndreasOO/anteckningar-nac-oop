package OOP.Sprint2.Uppgift14.PersonsCreation;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private String name;

    Person(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
