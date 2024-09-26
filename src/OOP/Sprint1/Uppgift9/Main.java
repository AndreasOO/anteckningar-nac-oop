package OOP.Sprint1.Uppgift9;

public class Main {
    public static void main(String[] args) {
        for (RomanNumbers romanNumber : RomanNumbers.values()) {
            System.out.println(romanNumber + ": " + romanNumber.latinNumber);
        }
    }
}
