package OOP.Sprint4.Uppgift4b.Sender;

import javax.swing.*;

public class GUISender {
    JFrame frame;
    JPanel panel;
    JTextField textField;
    JButton button;

    public GUISender(String title) {
        frame = new JFrame(title);
        panel = new JPanel();
        textField = new JTextField();
        button = new JButton("Report");
    }

    public void init() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setSize(200,100);

        panel.add(textField);
        panel.add(button);

        textField.setColumns(10);

    }

    public JTextField getTextFieldInput() {
        return textField;
    }

    public JButton getButton() {
        return button;
    }

    protected JFrame getFrame() {
        return frame;
    }
}
