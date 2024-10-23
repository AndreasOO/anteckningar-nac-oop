package OOP.Sprint3.Uppgift3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChangeCalculator {
    private final JFrame frame;
    private final JPanel mainPanel;
    private final JPanel topPanel;
    private final JPanel centerPanel;
    private final JPanel centerTopPanel;
    private final JPanel centerBottomPanel;
    private final JPanel bottomPanel;

    private final JLabel topPanelLabel;

    private final JLabel priceLabel;
    private final JTextField priceTextField;
    private final JLabel amountPaidLabel;
    private final JTextField amountPaidTextField;

    private final JPanel checkboxPanel;
    private final JCheckBox checkBoxOneThousandDenomination;
    private final JCheckBox checkBoxFiveHundredDenomination;
    private final JCheckBox checkBoxTwoHundredDenomination;
    private final JCheckBox checkBoxOneHundredDenomination;
    private final JCheckBox checkBoxFiftyDenomination;
    private final JCheckBox checkBoxTwentyDenomination;
    private final JCheckBox checkBoxTenDenomination;
    private final JCheckBox checkBoxFiveDenomination;
    private final JCheckBox checkBoxTwoDenomination;
    private final JCheckBox checkBoxOneDenomination;

    private final JPanel changeBackPanel;
    private final JLabel changeBackResultTitleLabel;
    private final JLabel changeBackResultThousandDenomination;
    private final JLabel changeBackResultFiveHundredDenomination;
    private final JLabel changeBackResultTwoHundredDenomination;
    private final JLabel changeBackResultOneHundredDenomination;
    private final JLabel changeBackResultFiftyDenomination;
    private final JLabel changeBackResultTwentyDenomination;
    private final JLabel changeBackResultTenDenomination;
    private final JLabel changeBackResultFiveDenomination;
    private final JLabel changeBackResultTwoDenomination;
    private final JLabel changeBackResultOneDenomination;

    private final JButton calculateChangeBackButton;

    public ChangeCalculator() {
        frame = new JFrame();
        mainPanel = new JPanel();
        topPanel = new JPanel();
        centerPanel = new JPanel();
        centerTopPanel = new JPanel();
        centerBottomPanel = new JPanel();
        bottomPanel = new JPanel();
        topPanelLabel = new JLabel("Calculate your change");

        priceLabel = new JLabel("Price: ");
        priceTextField = new JTextField();
        amountPaidLabel = new JLabel("Amount paid: ");
        amountPaidTextField = new JTextField();

        checkboxPanel = new JPanel();
        checkBoxOneThousandDenomination = new JCheckBox("One thousand denomination");
        checkBoxFiveHundredDenomination = new JCheckBox("Five hundred denomination");
        checkBoxTwoHundredDenomination = new JCheckBox("Two hundred denomination");
        checkBoxOneHundredDenomination = new JCheckBox("One hundred denomination");
        checkBoxFiftyDenomination = new JCheckBox("Fifty denomination");
        checkBoxTwentyDenomination = new JCheckBox("Twenty denomination");
        checkBoxTenDenomination = new JCheckBox("Ten denomination");
        checkBoxFiveDenomination = new JCheckBox("Five denomination");
        checkBoxTwoDenomination = new JCheckBox("Two denomination");
        checkBoxOneDenomination = new JCheckBox("One denomination");

        changeBackPanel = new JPanel();
        changeBackResultTitleLabel = new JLabel("Change back: ");
        changeBackResultThousandDenomination = new JLabel("Thousands: 0");
        changeBackResultFiveHundredDenomination = new JLabel("Five hundreds: 0");
        changeBackResultTwoHundredDenomination = new JLabel("Two hundreds: 0");
        changeBackResultOneHundredDenomination = new JLabel("One hundreds: 0");
        changeBackResultFiftyDenomination = new JLabel("Fifties: 0");
        changeBackResultTwentyDenomination = new JLabel("Twenties: 0");
        changeBackResultTenDenomination = new JLabel("Tens: 0");
        changeBackResultFiveDenomination = new JLabel("Fives: 0");
        changeBackResultTwoDenomination = new JLabel("Twos: 0");
        changeBackResultOneDenomination = new JLabel("Ones: 0");

        calculateChangeBackButton = new JButton("Calculate change back");

    }

    public void init() {
        frame.setTitle("Change Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(mainPanel);
        frame.setVisible(true);
        frame.setSize(1200,800);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        topPanelLabel.setFont(new Font("Times New Roman", Font.PLAIN, 34));
        topPanel.add(topPanelLabel);

        centerPanel.setLayout(new GridLayout(2,1));
        centerPanel.add(centerTopPanel);
        centerPanel.add(centerBottomPanel);

        centerTopPanel.setLayout(new GridLayout(2,2));
        centerTopPanel.add(priceLabel);
        centerTopPanel.add(priceTextField);
        centerTopPanel.add(amountPaidLabel);
        centerTopPanel.add(amountPaidTextField);

        centerBottomPanel.setLayout(new GridLayout(1,2));
        centerPanel.add(checkboxPanel);
        centerPanel.add(changeBackPanel);

        checkboxPanel.setLayout(new GridLayout(10,1));
        checkboxPanel.add(checkBoxOneThousandDenomination);
        checkboxPanel.add(checkBoxFiveHundredDenomination);
        checkboxPanel.add(checkBoxTwoHundredDenomination);
        checkboxPanel.add(checkBoxOneHundredDenomination);
        checkboxPanel.add(checkBoxFiftyDenomination);
        checkboxPanel.add(checkBoxTwentyDenomination);
        checkboxPanel.add(checkBoxTenDenomination);
        checkboxPanel.add(checkBoxFiveDenomination);
        checkboxPanel.add(checkBoxTwoDenomination);
        checkboxPanel.add(checkBoxOneDenomination);

        changeBackPanel.setLayout(new GridLayout(11,1));
        changeBackPanel.add(changeBackResultTitleLabel);
        changeBackPanel.add(changeBackResultThousandDenomination);
        changeBackPanel.add(changeBackResultFiveHundredDenomination);
        changeBackPanel.add(changeBackResultTwoHundredDenomination);
        changeBackPanel.add(changeBackResultOneHundredDenomination);
        changeBackPanel.add(changeBackResultFiftyDenomination);
        changeBackPanel.add(changeBackResultTwentyDenomination);
        changeBackPanel.add(changeBackResultTenDenomination);
        changeBackPanel.add(changeBackResultFiveDenomination);
        changeBackPanel.add(changeBackResultTwoDenomination);
        changeBackPanel.add(changeBackResultOneDenomination);

        bottomPanel.setLayout(new GridLayout(1,1));
        bottomPanel.add(calculateChangeBackButton);

        addEventListeners();
    }

    private void addEventListeners() {
        calculateChangeBackButton.addActionListener((event) -> {
            if (event.getSource() == calculateChangeBackButton) {
                try {
                    calculateChangeBack();
                } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(frame,"Incorrect format of price or amount");
            }
            }
        });
    }

    private void calculateChangeBack() {
        if (priceTextField.getText().isEmpty() || amountPaidTextField.getText().isEmpty()) {
            return;
        }
        clearPreviousCalculation();

        double totalChangeBack = Double.parseDouble(amountPaidTextField.getText()) - Double.parseDouble(priceTextField.getText());

        ArrayList<Denomination> checkedDenominations = getDenominations();

        for (Denomination denomination : checkedDenominations) {
            switch (denomination) {
                case THOUSAND -> changeBackResultThousandDenomination.setText(String.format("Thousands: %d", (int) (totalChangeBack / Denomination.THOUSAND.value)));

                case FIVE_HUNDRED -> changeBackResultFiveHundredDenomination.setText(String.format("Five hundreds: %d", (int) (totalChangeBack / Denomination.FIVE_HUNDRED.value)));

                case TWO_HUNDRED -> changeBackResultTwoHundredDenomination.setText(String.format("Two hundreds: %d", (int) (totalChangeBack / Denomination.TWO_HUNDRED.value)));

                case ONE_HUNDRED -> changeBackResultOneHundredDenomination.setText(String.format("One hundreds: %d", (int) (totalChangeBack / Denomination.ONE_HUNDRED.value)));

                case FIFTY -> changeBackResultFiftyDenomination.setText(String.format("Fifties: %d", (int) (totalChangeBack / Denomination.FIFTY.value)));

                case TWENTY -> changeBackResultTwentyDenomination.setText(String.format("Twenties: %d", (int) (totalChangeBack / Denomination.TWENTY.value)));

                case TEN -> changeBackResultTenDenomination.setText(String.format("Tens: %d", (int) (totalChangeBack / Denomination.TEN.value)));

                case FIVE -> changeBackResultFiveDenomination.setText(String.format("Fives: %d", (int) (totalChangeBack / Denomination.FIVE.value)));

                case TWO -> changeBackResultTwoDenomination.setText(String.format("Twos: %d", (int) (totalChangeBack / Denomination.TWO.value)));

                case ONE -> changeBackResultOneDenomination.setText(String.format("Ones: %d", (int) (totalChangeBack / Denomination.ONE.value)));
            }

            totalChangeBack -= ((int) (totalChangeBack / denomination.value))*denomination.value;
        }
        JOptionPane.showMessageDialog(frame, "Calculated change according to settings, remaining change: " + totalChangeBack);
    }

    private ArrayList<Denomination> getDenominations() {
        ArrayList<Denomination> checkedDenominations = new ArrayList<>();
        if (checkBoxOneThousandDenomination.isSelected()) {
            checkedDenominations.add(Denomination.THOUSAND);
        }
        if (checkBoxFiveHundredDenomination.isSelected()) {
            checkedDenominations.add(Denomination.FIVE_HUNDRED);
        }
        if (checkBoxTwoHundredDenomination.isSelected()) {
            checkedDenominations.add(Denomination.TWO_HUNDRED);
        }
        if (checkBoxOneHundredDenomination.isSelected()) {
            checkedDenominations.add(Denomination.ONE_HUNDRED);
        }
        if (checkBoxFiftyDenomination.isSelected()) {
            checkedDenominations.add(Denomination.FIFTY);
        }
        if (checkBoxTwentyDenomination.isSelected()) {
            checkedDenominations.add(Denomination.TWENTY);
        }
        if (checkBoxTenDenomination.isSelected()) {
            checkedDenominations.add(Denomination.TEN);
        }
        if (checkBoxFiveDenomination.isSelected()) {
            checkedDenominations.add(Denomination.FIVE);
        }
        if (checkBoxTwoDenomination.isSelected()) {
            checkedDenominations.add(Denomination.TWO);
        }
        if (checkBoxOneDenomination.isSelected()) {
            checkedDenominations.add(Denomination.ONE);
        }
        return checkedDenominations;
    }

    private void clearPreviousCalculation() {
        changeBackResultThousandDenomination.setText("Thousands: 0");
        changeBackResultFiveHundredDenomination.setText("Five hundreds: 0");
        changeBackResultTwoHundredDenomination.setText("Two hundreds: 0");
        changeBackResultOneHundredDenomination.setText("One hundreds: 0");
        changeBackResultFiftyDenomination.setText("Fifties: 0");
        changeBackResultTwentyDenomination.setText("Twenties: 0");
        changeBackResultTenDenomination.setText("Tens: 0");
        changeBackResultFiveDenomination.setText("Fives: 0");
        changeBackResultTwoDenomination.setText("Twos: 0");
        changeBackResultOneDenomination.setText("Ones: 0");
    }
}
