package OOP.Sprint4.Uppgift5a_b.Server;

public class Contact {
    private final String name;
    private final String phoneNumber;
    private final String birthDate;
    private final String email;

    public Contact(String name, String phoneNumber, String birthDate, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }
}
