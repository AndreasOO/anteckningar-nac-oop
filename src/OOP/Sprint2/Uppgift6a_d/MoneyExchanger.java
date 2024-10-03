package OOP.Sprint2.Uppgift6a_d;

public class MoneyExchanger {
    private double price;
    private double amountPaid;
    private double totalChange;

    private int numberOfSingles;
    private int numberOfTwos;
    private int numberOfFives;
    private int numberOfTens;
    private int numberOfTwenties;
    private int numberOfFifties;
    private int numberOfHundreds;
    private int numberOfTwoHundreds;
    private int numberOfFiveHundreds;

    public MoneyExchanger() {

    }


    public double calculateTotalChange() {
        return amountPaid - totalChange;
    }

    public String createOutput() {
        return "";
    }


}
