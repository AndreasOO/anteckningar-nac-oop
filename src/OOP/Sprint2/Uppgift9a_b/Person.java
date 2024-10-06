package OOP.Sprint2.Uppgift9a_b;

public class Person {
    private final String name;
    private final String address;
    private final String postalCodeAndArea;
    private final int age;
    private final int weight;
    private final int height;

    Person(String name, String address, String postalCodeAndArea, int age, int weight, int height) {
        this.name = name;
        this.address = address;
        this.postalCodeAndArea = postalCodeAndArea;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }


    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s\n" +
                             "%d, %d, %d\n", name, address, postalCodeAndArea, age, weight, height );
    }
}
