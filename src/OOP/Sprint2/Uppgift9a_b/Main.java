package OOP.Sprint2.Uppgift9a_b;

public class Main {
    public static void main(String[] args) {
        PersonReader personReader = new PersonReader();
        personReader.readFile();

        personReader.getListsOfIncludedPersons().forEach(System.out::println);

        personReader.writeToFile();
    }
}
