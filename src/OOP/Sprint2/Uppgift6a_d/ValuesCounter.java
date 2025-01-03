package OOP.Sprint2.Uppgift6a_d;

import java.util.LinkedHashMap;
import java.util.Map;

public class ValuesCounter {
    private int numberOfSingles;
    private int numberOfTwos;
    private int numberOfFives;
    private int numberOfTens;
    private int numberOfTwenties;
    private int numberOfFifties;
    private int numberOfHundreds;
    private int numberOfTwoHundreds;
    private int numberOfFiveHundreds;

    public ValuesCounter() {

    }
    public void addSingle(int timesDenomination) {
        this.numberOfSingles+=timesDenomination;
    }

    public void addTwo(int timesDenomination) {
        this.numberOfTwos+=timesDenomination;
    }

    public void addFive(int timesDenomination) {
        this.numberOfFives+=timesDenomination;
    }

    public void addTen(int timesDenomination) {
        this.numberOfTens+=timesDenomination;
    }

    public void addTwenty(int timesDenomination) {
        this.numberOfTwenties+=timesDenomination;
    }

    public void addFifty(int timesDenomination) {
        this.numberOfFifties+=timesDenomination;
    }

    public void addOneHundred(int timesDenomination) {
        this.numberOfHundreds+=timesDenomination;
    }

    public void addTwoHundred(int timesDenomination) {
        this.numberOfTwoHundreds+=timesDenomination;
    }

    public void addFiveHundred(int timesDenomination) {
        this.numberOfFiveHundreds+=timesDenomination;
    }


    public int getNumberOfSingles() {
        return numberOfSingles;
    }

    public int getNumberOfTwos() {
        return numberOfTwos;
    }

    public int getNumberOfFives() {
        return numberOfFives;
    }

    public int getNumberOfTens() {
        return numberOfTens;
    }

    public int getNumberOfTwenties() {
        return numberOfTwenties;
    }

    public int getNumberOfFifties() {
        return numberOfFifties;
    }

    public int getNumberOfHundreds() {
        return numberOfHundreds;
    }

    public int getNumberOfTwoHundreds() {
        return numberOfTwoHundreds;
    }

    public int getNumberOfFiveHundreds() {
        return numberOfFiveHundreds;
    }

    public Map<String, Integer> organizeChange() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Single coins", this.numberOfSingles);
        map.put("Two coins", this.numberOfTwos);
        map.put("Five coins", this.numberOfFives);
        map.put("Ten coins", this.numberOfTens);
        map.put("Twenty nodes", this.numberOfTwenties);
        map.put("Fifties nodes", this.numberOfFifties);
        map.put("Hundreds nodes", this.numberOfHundreds);
        map.put("TwoHundreds nodes", this.numberOfTwoHundreds);
        map.put("FiveHundreds nodes", this.numberOfFiveHundreds);

        return map;
    }

    public String createOutput() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : organizeChange().entrySet()) {
            if (entry.getValue() > 0) {
                sb.append("Number of ");
                sb.append(entry.getKey());
                sb.append(": ");
                sb.append(entry.getValue());
                sb.append("\n");
            }


        }
        return sb.isEmpty() ? "No change back" : sb.toString();
    }
}
