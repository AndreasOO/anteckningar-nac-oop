package OOP.Sprint3.Uppgift2;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class GasCalculator {
    private final JFrame frame;
    private final JPanel mainPanel;
    private final JPanel inputPanel;
    private final JPanel outputPanel;
    private final JTextField textFieldKilometersDrivenNow;
    private final JTextField textFieldKilometersDrivenOneYearAgo;
    private final JTextField textFieldGasUsedInLiters;
    private final JLabel labelKilometersDrivenNow;
    private final JLabel labelKilometersDrivenOneYearAgo;
    private final JLabel labelGasUsedInLiters;

    private final JLabel outputLabelKilometersDriven;
    private final JLabel outputLabelGasUsedInLiters;
    private final JLabel outputMileageInGasPerKilometers;



    public GasCalculator() {
        frame = new JFrame("Gas Calculator");
        mainPanel = new JPanel();
        inputPanel = new JPanel();
        outputPanel = new JPanel();
        textFieldKilometersDrivenNow = new JTextField();
        textFieldKilometersDrivenOneYearAgo = new JTextField();
        textFieldGasUsedInLiters = new JTextField();
        labelKilometersDrivenNow = new JLabel("Kilometers Driven Now");
        labelKilometersDrivenOneYearAgo = new JLabel("Kilometers Driven One Year Ago");
        labelGasUsedInLiters = new JLabel("Gas Used In Liters");
        outputLabelKilometersDriven = new JLabel("Kilometers Driven: ");
        outputLabelGasUsedInLiters = new JLabel("Gas Used in Liters: ");
        outputMileageInGasPerKilometers = new JLabel("Mileage in Gas Per Kilometers: ");

    }

    public void init() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(outputPanel, BorderLayout.SOUTH);

        inputPanel.setLayout(new GridLayout(3,2));
        inputPanel.add(labelKilometersDrivenNow);
        inputPanel.add(textFieldKilometersDrivenNow);
        inputPanel.add(labelKilometersDrivenOneYearAgo);
        inputPanel.add(textFieldKilometersDrivenOneYearAgo);
        inputPanel.add(labelGasUsedInLiters);
        inputPanel.add(textFieldGasUsedInLiters);

        outputPanel.setLayout(new GridLayout(1,3));
        outputPanel.add(outputLabelKilometersDriven);
        outputPanel.add(outputLabelGasUsedInLiters);
        outputPanel.add(outputMileageInGasPerKilometers);

        frame.setVisible(true);
        frame.pack();

        addEventListeners();
    }

    private void addEventListeners() {
        textFieldKilometersDrivenNow.addActionListener((e) -> {
            calculateOutput();
        });
        textFieldKilometersDrivenOneYearAgo.addActionListener((e) -> {
            calculateOutput();
        });
        textFieldGasUsedInLiters.addActionListener((e) -> {
            calculateOutput();;
        });
    }

    private void calculateOutput() {
        if (textFieldKilometersDrivenNow.getText().equals("") ||
            textFieldKilometersDrivenOneYearAgo.getText().equals("") ||
            textFieldGasUsedInLiters.getText().equals("")) {
                JOptionPane.showMessageDialog(frame, "Please fill all the fields");
        } else {
            try {
                double kilometersNow = Double.parseDouble(textFieldKilometersDrivenNow.getText());
                double kilometersOneYearAgo = Double.parseDouble(textFieldKilometersDrivenOneYearAgo.getText());
                double gasUsedInLiters = Double.parseDouble(textFieldGasUsedInLiters.getText());

                outputMileageInGasPerKilometers.setText(String.format("Mileage in Gas Per Kilometers: %.2f       ",
                                       new BigDecimal(gasUsedInLiters/(kilometersNow-kilometersOneYearAgo))
                                               .setScale(2, RoundingMode.HALF_UP)
                                               .doubleValue()));

                outputLabelKilometersDriven.setText(String.format("Kilometers Driven: %.2f",kilometersNow-kilometersOneYearAgo));
                outputLabelGasUsedInLiters.setText(String.format("Gas Used in Liters: %.2f",gasUsedInLiters));

                frame.pack();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Incorrect format of number");
            }
        }
    }
}


