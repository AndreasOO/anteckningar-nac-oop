package OOP.Sprint2.Uppgift9a_b;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PersonReader {
    private int INCLUSION_REQUIREMENT_IN_CENTIMETER = 200;
    private List<Person> listsOfIncludedPersons;
    private Path FILEPATH_INPUT = Paths.get("src/OOP/Sprint2/Uppgift9a_b/personuppgifter.txt");
    private Path FILEPATH_OUTPUT = Paths.get("src/OOP/Sprint2/Uppgift9a_b/output.txt");


    public PersonReader() {
        listsOfIncludedPersons = new ArrayList<>();
    }




    public void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILEPATH_INPUT.toFile()))) {
            String line;
            String[] nameAddressPostalCodeAndArea;
            String[] ageHeightWeight;
            while ((line = reader.readLine()) != null) {

                nameAddressPostalCodeAndArea = line.split(",");
                line = reader.readLine();
                ageHeightWeight = line.split(",");

                Person person = new Person(nameAddressPostalCodeAndArea[0].trim(),
                                           nameAddressPostalCodeAndArea[1].trim(),
                                           nameAddressPostalCodeAndArea[2].trim(),
                                           Integer.parseInt(ageHeightWeight[0].trim()),
                                           Integer.parseInt(ageHeightWeight[1].trim()),
                                           Integer.parseInt(ageHeightWeight[2].trim()));

                if (person.getHeight() > INCLUSION_REQUIREMENT_IN_CENTIMETER) {
                    listsOfIncludedPersons.add(person);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error while reading file");
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Could not read file");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not read file");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Could not handle numeric conversion");
        }
    }

    public void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH_OUTPUT.toFile()))) {
            for (Person person : listsOfIncludedPersons) {
                writer.write(person.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while writing file");
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Could not find file to write to");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unexpected Error");
        }
    }

    public List<Person> getListsOfIncludedPersons() {
        return listsOfIncludedPersons;
    }

    public int getINCLUSION_REQUIREMENT_IN_CENTIMETER() {
        return INCLUSION_REQUIREMENT_IN_CENTIMETER;
    }

    public void setINCLUSION_REQUIREMENT_IN_CENTIMETER(int INCLUSION_REQUIREMENT_IN_CENTIMETER) {
        this.INCLUSION_REQUIREMENT_IN_CENTIMETER = INCLUSION_REQUIREMENT_IN_CENTIMETER;
    }

    public void setListsOfIncludedPersons(List<Person> listsOfIncludedPersons) {
        this.listsOfIncludedPersons = listsOfIncludedPersons;
    }

    public Path getFILEPATH_INPUT() {
        return FILEPATH_INPUT;
    }

    public void setFILEPATH_INPUT(Path FILEPATH_INPUT) {
        this.FILEPATH_INPUT = FILEPATH_INPUT;
    }

    public Path getFILEPATH_OUTPUT() {
        return FILEPATH_OUTPUT;
    }

    public void setFILEPATH_OUTPUT(Path FILEPATH_OUTPUT) {
        this.FILEPATH_OUTPUT = FILEPATH_OUTPUT;
    }
}
