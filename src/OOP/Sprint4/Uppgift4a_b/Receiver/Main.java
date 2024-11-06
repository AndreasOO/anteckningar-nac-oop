package OOP.Sprint4.Uppgift4a_b.Receiver;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        try {
            ReportReceiver reportReceiver = new ReportReceiver(4442);
            reportReceiver.startProgram();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
