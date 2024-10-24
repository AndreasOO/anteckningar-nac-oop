package OOP.Sprint3.Uppgift9;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        while (true) {
            String medicine = JOptionPane.showInputDialog("Enter type of medicine");
            if (medicine == null) {
                System.exit(0);
            }

            String timesPerMinute = JOptionPane.showInputDialog("Enter times per minute");
            if (timesPerMinute == null) {
                System.exit(0);
            }
            int timesPerMinuteAsInt = Integer.parseInt(timesPerMinute);

            Thread thread = new Thread(new MedicineIngestion(medicine,timesPerMinuteAsInt));
            thread.start();
        }
    }
}
