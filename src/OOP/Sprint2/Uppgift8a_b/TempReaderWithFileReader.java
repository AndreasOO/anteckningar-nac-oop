package OOP.Sprint2.Uppgift8a_b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.DoubleSummaryStatistics;

public class TempReaderWithFileReader {
    private final Path filePath;
    DoubleSummaryStatistics stats;

    public TempReaderWithFileReader() {
        this.filePath = Paths.get("src/OOP/Sprint2/Uppgift8a_b/temp.txt");

    }

    public void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
            stats = reader.lines().
                           mapToDouble(line -> Double.parseDouble(line.replace(",","."))).
                           summaryStatistics();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Network error");
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Could not find file");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("File values incorrect, value was not double format");
        }
    }

    public double getLowest() {
        return stats.getMin();
    }

    public double getHighest() {
        return stats.getMax();
    }
}
