package OOP.Sprint3.Uppgift3;

public enum Denomination {
    THOUSAND(1000.0),
    FIVE_HUNDRED(500.0),
    TWO_HUNDRED(200.0),
    ONE_HUNDRED(100.0),
    FIFTY(50.0),
    TWENTY(20.0),
    TEN(10.0),
    FIVE(5.0),
    TWO(2.0),
    ONE(1.0);

    public final double value;

    Denomination(double value) {
        this.value = value;
    }
}