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
    public void addSingle() {
        this.numberOfSingles++;
    }

    public void addTwo() {
        this.numberOfTwos++;
    }

    public void addFive() {
        this.numberOfFives++;
    }

    public void addTen() {
        this.numberOfTens++;
    }

    public void addTwenty() {
        this.numberOfTwenties++;
    }

    public void addFifty() {
        this.numberOfFifties++;
    }

    public void addOneHundred() {
        this.numberOfHundreds++;
    }

    public void addTwoHundred() {
        this.numberOfTwoHundreds++;
    }

    public void addFiveHundred() {
        this.numberOfFiveHundreds++;
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
