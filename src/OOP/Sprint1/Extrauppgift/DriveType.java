package OOP.Sprint1.Extrauppgift;

public enum DriveType {
    CHAIN("Chain Driven"),
    CARDAN("Cardan Driven");

    public final String DESCRIPTION;

    DriveType(String description) {
        this.DESCRIPTION = description;
    }
}
