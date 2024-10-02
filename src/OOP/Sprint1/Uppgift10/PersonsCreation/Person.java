package OOP.Sprint1.Uppgift10.PersonsCreation;

public abstract class Person {
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

}
