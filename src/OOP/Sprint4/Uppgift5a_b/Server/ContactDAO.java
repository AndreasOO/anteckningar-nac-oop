package OOP.Sprint4.Uppgift5a_b.Server;

import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    List<Contact> contactList;

    public ContactDAO() {
        contactList = new ArrayList<>();
        contactList.add(new Contact("Andy Warhol", "001123552", "890302", "andy.warhol@gmail.com"));
        contactList.add(new Contact("Macy Benz", "2312312", "830201", "macy.benz@gmail.com"));
        contactList.add(new Contact("Simon Funked", "223311", "811205", "simon.funked@gmail.com"));
    }

    public String findContact(String name) {
        Contact result = contactList.stream().filter(contact -> contact.getName().equalsIgnoreCase(name.trim())).findFirst().orElse(null);
        return result == null ? "Person not found in phonebook" :
                                 String.format("Name: %s, Phone number %s, Birthdate: %s, Email: %s", result.getName(),
                                                                                                      result.getPhoneNumber(),
                                                                                                      result.getBirthDate(),
                                                                                                      result.getEmail());
    }
}
