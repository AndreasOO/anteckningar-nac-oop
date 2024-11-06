package OOP.Sprint4.Uppgift4b.Receiver;

import javax.swing.*;

public class GUIReceiver {
    JFrame frame;
    JPanel panel;
    JLabel label;

    public GUIReceiver() {
        frame = new JFrame();
        panel = new JPanel();
        label = new JLabel();
    }

    public void init() {
        frame.setSize(300,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(label);

        label.setText("Stockholm, 32");
        panel.add(new JLabel("Fiji, 39"));



    }

    protected JFrame getFrame() {
        return frame;
    }

    protected JPanel getPanel() {
        return panel;
    }
}
