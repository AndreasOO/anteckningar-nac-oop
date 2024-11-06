package OOP.Sprint4.Uppgift4b.Sender;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        while (true) {
            int choice = JOptionPane.showConfirmDialog(null,"Add a city");

            if (choice == JOptionPane.YES_OPTION) {
                try {
                    new Thread(new ReportSender(4442)).start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (choice == JOptionPane.NO_OPTION) {
                // bad solution but lazy
                Thread.sleep(100000000);
            }
        }


    }
}
