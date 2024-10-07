package OOP.Sprint2.Uppgift13a_b;

public enum Operators {
    ADDITION('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/');

    public final char character;

    Operators(char character) {
        this.character = character;
    }
}
