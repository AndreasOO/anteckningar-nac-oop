package OOP.Sprint2.Uppgift8a_b;

public class Main {
    public static void main(String[] args) {
        TempReaderWithFileReader tempReader = new TempReaderWithFileReader();
        tempReader.readFile();
        System.out.println(tempReader.getHighest());
        System.out.println(tempReader.getLowest());

        TempReaderWithScanner tempReaderWithScanner = new TempReaderWithScanner();
        tempReaderWithScanner.readFile();
        System.out.println(tempReaderWithScanner.getHighest());
        System.out.println(tempReaderWithScanner.getLowest());

    }
}
