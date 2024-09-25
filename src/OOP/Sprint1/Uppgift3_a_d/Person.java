package OOP.Sprint1.Uppgift3_a_d;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String legalGender;
    public Person(String firstName, String lastName, int age, String legalGender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.legalGender = legalGender;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLegalGender(String legalGender) {
        this.legalGender = legalGender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getLegalGender() {
        return legalGender;
    }
}
