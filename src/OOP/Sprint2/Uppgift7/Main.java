package OOP.Sprint2.Uppgift7;

public class Main {
    public static void main(String[] args) {
        InterestCalculator interestCalculator = new InterestCalculator(100,10);

        System.out.println(interestCalculator.createOutputCompoundInterestForYears(10));
    }
}
