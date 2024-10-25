package OOP.Sprint3.Uppgift9;

public class MedicineIngestion implements Runnable {
    private final String medicineType;
    private final int timesIngestedPerMinutes;
    private final int intervalInMilliSeconds;

    public MedicineIngestion(String medicineType, int timesIngestedPerMinutes) {
        this.medicineType = medicineType;
        this.timesIngestedPerMinutes = timesIngestedPerMinutes;
        this.intervalInMilliSeconds = 60000/this.timesIngestedPerMinutes;
    }

    @Override
    public void run() {
        System.out.println(String.format("Medicine %s should be taken %d times per minute", medicineType, timesIngestedPerMinutes));
        while (true) {
            try {
                System.out.println(String.format("Time to take %s!", medicineType));
                Thread.sleep(intervalInMilliSeconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
}
