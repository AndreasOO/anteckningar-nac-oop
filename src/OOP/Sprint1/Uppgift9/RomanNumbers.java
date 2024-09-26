package OOP.Sprint1.Uppgift9;

public enum RomanNumbers {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    public final int latinNumber;

    RomanNumbers(int latinNumber) {
        this.latinNumber = latinNumber;
    }
}




