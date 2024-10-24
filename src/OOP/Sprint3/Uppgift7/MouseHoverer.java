package OOP.Sprint3.Uppgift7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHoverer {
    JFrame frame;
    JPanel panel;
    JButton button;

    public MouseHoverer() {
        frame = new JFrame();
        panel = new JPanel();
        button = new JButton("Hover me");
    }

    public void init() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(panel);
        frame.setSize(100,100);

        panel.add(button);

        addEventListeners();
    }

    private void addEventListeners() {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                button.setText("Exited");

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setText("Entered");

            }
        });
    }
}
