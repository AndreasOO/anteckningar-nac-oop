package OOP.Sprint2.Uppgift9a_b;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class PersonReaderTest {

    PersonReader personReader = new PersonReader();


    @Test
    void readFile() {
        personReader.readFile();
        assertEquals(2, personReader.getListsOfIncludedPersons().size());
        assertEquals("Rulle Rullson, Xvägen 3, 12345 Ystad\n" +
                             "56, 35, 201\n", personReader.getListsOfIncludedPersons().getFirst().toString());

    }

    @Test
    void readFileNotFoundException() {
        personReader.setFILEPATH_INPUT(Paths.get("testinput.txt"));
        // should log FileNotFoundException
        personReader.readFile();
        assertEquals(0, personReader.getListsOfIncludedPersons().size());
    }

    @Test
    void readFileEmptyException() {
        personReader.setFILEPATH_INPUT(Paths.get("src/OOP/Sprint2/Uppgift9a_b/personuppgifterTEST_EMPTYFILE.txt"));
        personReader.readFile();
        assertEquals(0, personReader.getListsOfIncludedPersons().size());
    }

    @Test
    void writeToFile() {
        personReader.writeToFile();
    }
}