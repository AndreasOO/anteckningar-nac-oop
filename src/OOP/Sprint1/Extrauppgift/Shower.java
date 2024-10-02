package OOP.Sprint1.Extrauppgift;

public enum Shower {
    NONE("No shower"),
    INDOOR_WATERFALL("Indoor Waterfall Shower"),
    OUTDOOR_WATERFALL("Outdoor Waterfall Shower");

    public final String DESCRIPTION;

    Shower(String description) {
        DESCRIPTION = description;
    }
}
