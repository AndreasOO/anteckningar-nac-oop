package OOP.Sprint1.Extrauppgift;

public interface Revenuable {
    int VAT_IN_PERCENT = 25;
    double calculateRevenue();

    default int getVatInPercent() {
        return VAT_IN_PERCENT;
    }

    default double getVatInDecimal() {
        return VAT_IN_PERCENT/100.0;
    }
}
