package OOP.Sprint1.Uppgift10;

public abstract class Person {
    private String name;
    private int personalNumber;

    Person(String name, int personalNumber) {
        this.name = name;
        this.personalNumber = personalNumber;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(int personalNumber) {
        this.personalNumber = personalNumber;
    }
}
