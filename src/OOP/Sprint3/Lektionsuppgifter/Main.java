package OOP.Sprint3.Lektionsuppgifter;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Spännande text");
        JButton btn = new JButton("Knapp");

        panel.add(label);
        panel.add(btn);

        JFrame frame = new JFrame("Lektionsuppgifter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);

        frame.add(panel);

        frame.setVisible(true);


    }
}
