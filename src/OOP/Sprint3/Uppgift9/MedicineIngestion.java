package OOP.Sprint3.Uppgift9;

public class MedicineIngestion implements Runnable {
    private final String medicineType;
    private final int timesIngestedPerMinutes;

    public MedicineIngestion(String medicineType, int timesIngestedPerMinutes) {
        this.medicineType = medicineType;
        this.timesIngestedPerMinutes = timesIngestedPerMinutes;
    }

    @Override
    public void run() {
        System.out.println(String.format("Medicine %s should be taken %d times per minute", medicineType, timesIngestedPerMinutes));
    }
}
