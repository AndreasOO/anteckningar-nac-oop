package OOP.Sprint3.Uppgift6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FocusEventHandler {
    JFrame frame;
    JPanel mainPanel;
    JButton button1;
    JButton button2;
    JTextField textField;
    int i;

    public FocusEventHandler() {
        frame = new JFrame("Focus Event");
        mainPanel = new JPanel();
        button1 = new JButton("Button One");
        button2 = new JButton("Button Two");
        textField = new JTextField("First");
    }

    public void init() {
        frame.setSize(200,100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);

        mainPanel.setLayout(new GridLayout(1,3));
        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(textField);

        addEventListeners();
    }

    public void addEventListeners() {


        frame.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                textField.requestFocusInWindow();
            }
        });

       textField.addFocusListener(new FocusAdapter() {
           @Override
           public void focusGained(FocusEvent e) {
               textField.setBackground(Color.blue);
           }
       });

        frame.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowLostFocus(WindowEvent e) {
                textField.setBackground(Color.white);
            }
        });

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                textField.setBackground(Color.white);
            }
        });
    }

}
