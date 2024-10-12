package OOP.Sprint2.Uppgift14.GUI;

import OOP.Sprint2.Uppgift14.ChangeLog.ChangeLog;
import OOP.Sprint2.Uppgift14.ChangeLog.LoanApprovalChangeLogItem;
import OOP.Sprint2.Uppgift14.PersonsCreation.BankStaff;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class BankStaffGUI {
    private final BankStaff bankStaffUser;
    private boolean showAll = true;
    private final JFrame frame;
    private final JPanel toolPanel;
    private final JPanel loginPanel;
    private final JPanel changeLogPanel;
    private final JPanel mainPanel;
    private JScrollPane mainPanelScrollPane;
    private JPanel mainPanelContent;

    private final JButton toolBtnAddCustomer;
    private final JButton toolBtnOpenAccount;
    private final JButton toolBtnApproveLoan;
    private final JButton toolBtnAccountInterestChange;
    private final JButton toolBtnLoanInterestChange;

    private final JLabel loginStatusLabel;
    private final JLabel loginUserInfoLabel;


    private final JLabel changeLogTitleLabel;
    private final JList changeLogItemList;
    private final JScrollPane changeLogScrollPane;
    private final JButton changeLogBtnShowDetails;

    private final JLabel changeLogFilterLabel;
    private final JButton changeLogBtnFilterShowMine;
    private final JButton changeLogBtnFilterShowAll;

    private final JComboBox changeLogItemTypeSelector;
    private final JLabel changeLogFilterDescriptionLabel;




    public BankStaffGUI(BankStaff bankStaffUser) {
        this.bankStaffUser = bankStaffUser;

        frame = new JFrame("Bank System");
        frame.setLayout(new BorderLayout());
        toolPanel = new JPanel();
        loginPanel = new JPanel();
        changeLogPanel = new JPanel();
        mainPanel = new JPanel();


        toolBtnAddCustomer = new JButton("Add Customer");
        toolBtnOpenAccount = new JButton("Open Account");
        toolBtnApproveLoan = new JButton("Approve Loan");
        toolBtnAccountInterestChange = new JButton("Account Interest Change");
        toolBtnLoanInterestChange = new JButton("Loan Interest Change");

        loginStatusLabel = new JLabel("Logged in as employee");
        loginUserInfoLabel = new JLabel(bankStaffUser.getName() + " ------- Employment ID: " + bankStaffUser.getEmploymentID());


        changeLogTitleLabel = new JLabel("Change Log            ");
        changeLogItemList = new JList<>(new DefaultListModel<>());
        changeLogItemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        changeLogScrollPane = new JScrollPane(changeLogItemList);
        changeLogBtnShowDetails = new JButton("Show Log Item Details");

        changeLogFilterLabel = new JLabel("Filter Options");
        changeLogBtnFilterShowAll = new JButton("All Employees");
        changeLogBtnFilterShowMine = new JButton("Only mine");

        changeLogItemTypeSelector = new JComboBox<>(new String[]{"All changes", "Approved Loans", "Created Accounts", "Approved Loan Interest Change", "Approved Account Interest Change"});
        changeLogFilterDescriptionLabel = new JLabel("Select a type of item to filter on");
    }

    public void init() {
        setupFrame();
        setupToolPanel();
        setupLoginPanel();
        setupChangeLogPanel();
        setupMainPanel();
        addEventListeners();
        loadData();
        showGUI();
    }

    private void setupFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 1200);
        frame.setLocationRelativeTo(null);
    }

    private void setupToolPanel() {
        toolPanel.setLayout(new GridLayout(5,1));
        toolPanel.setSize(300,1000);
        toolPanel.add(toolBtnAddCustomer);
        toolPanel.add(toolBtnOpenAccount);
        toolPanel.add(toolBtnApproveLoan);
        toolPanel.add(toolBtnAccountInterestChange);
        toolPanel.add(toolBtnLoanInterestChange);

        frame.add(toolPanel, BorderLayout.WEST);
    }

    private void setupLoginPanel() {
        loginPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        loginPanel.setSize(1600, 200);
        loginStatusLabel.setFont(new Font("Arial", Font.BOLD, 30));
        loginPanel.add(loginStatusLabel);
        loginUserInfoLabel.setFont(new Font("Arial", Font.BOLD, 30));
        loginPanel.add(loginUserInfoLabel);
        frame.add(loginPanel, BorderLayout.NORTH);
    }

    private void setupChangeLogPanel() {
        changeLogPanel.setLayout(new BoxLayout(changeLogPanel, BoxLayout.Y_AXIS));
        changeLogTitleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        changeLogFilterLabel.setFont(new Font("Arial", Font.BOLD, 20));
        changeLogFilterDescriptionLabel.setFont(new Font("Arial", Font.ITALIC, 10));
        changeLogPanel.add(changeLogTitleLabel);
        changeLogPanel.add(changeLogScrollPane);

        JPanel jp2 = new JPanel(new GridLayout(10,1));
        jp2.add(changeLogBtnShowDetails);
        jp2.add(changeLogFilterLabel);
        jp2.add(changeLogBtnFilterShowMine);
        jp2.add(changeLogBtnFilterShowAll);
        jp2.add(changeLogFilterDescriptionLabel);
        jp2.add(changeLogItemTypeSelector);
        changeLogPanel.add(jp2);


        frame.add(changeLogPanel, BorderLayout.EAST);
    }
    private void setupMainPanel() {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setSize(1000, 1000);
        mainPanelContent = new JPanel();
        mainPanelContent.setLayout(new BoxLayout(mainPanelContent, BoxLayout.Y_AXIS));
        mainPanelContent.setSize(new Dimension(1000, 500));


        mainPanelScrollPane = new JScrollPane(mainPanelContent);
        mainPanel.add(mainPanelScrollPane);
        frame.add(mainPanel, BorderLayout.CENTER);
    }

    private void loadData() {
        changeLogItemList.setListData(ChangeLog.getInstance().createHeadersForJList());
    }

    private void addEventListeners() {
        changeLogBtnShowDetails.addActionListener(e -> {
            if (e.getSource() == changeLogBtnShowDetails && changeLogItemList.getSelectedValue() != null) {
                showLogItemInMainPanel(changeLogItemList.getSelectedValue().toString());
            }
        });

        changeLogBtnFilterShowMine.addActionListener(e -> {
            if (e.getSource() == changeLogBtnFilterShowMine) {
                showAll = false;
                filterLogItemsByType(changeLogItemTypeSelector.getSelectedItem());
            }
        });
        changeLogBtnFilterShowAll.addActionListener(e -> {
            if (e.getSource() == changeLogBtnFilterShowAll) {
                showAll = true;
                filterLogItemsByType(changeLogItemTypeSelector.getSelectedItem());
            }
        });

        changeLogItemTypeSelector.addActionListener(e -> {
            if (e.getSource() == changeLogItemTypeSelector) {
                filterLogItemsByType(changeLogItemTypeSelector.getSelectedItem());
            }
        });


    }

    private void filterLogItemsByType(Object selectedItem) {
        if (selectedItem instanceof String itemType) {
            switch (itemType) {
                case "All changes" -> filterLogItemByAllTypes();

                case "Approved Loans" -> filterLogItemByApprovedLoans();

                case "Created Accounts" -> filterLogItemByCreatedAccounts();

                case "Approved Loan Interest Change" -> filterLogItemByLoanInterestChange();

                case "Approved Account Interest Change" -> filterLogItemByAccountInterestChange();

            }
        }
    }

    private void filterLogItemByAllTypes() {
        if (showAll) {
            changeLogItemList.setListData(ChangeLog.getInstance().createHeadersForJList());
        } else {
            changeLogItemList.setListData(ChangeLog.getInstance().createHeadersForJListFilterByEmployeeID(this.bankStaffUser.getEmploymentID()));
        }
    }

    private void filterLogItemByApprovedLoans() {
        if (showAll) {
            changeLogItemList.setListData(ChangeLog.getInstance().createHeadersForJListFilterByLoanApproval());
        } else {
            changeLogItemList.setListData(ChangeLog.getInstance().createHeadersForJListFilterByLoanApprovalAndEmployeeID(this.bankStaffUser.getEmploymentID()));
        }
    }

    private void filterLogItemByCreatedAccounts() {
        if (showAll) {
            changeLogItemList.setListData(ChangeLog.getInstance().createHeadersForJListFilterByCreatedAccounts());
        } else {
            changeLogItemList.setListData(ChangeLog.getInstance().createHeadersForJListFilterByCreatedAccountsAndEmployeeID(this.bankStaffUser.getEmploymentID()));
        }
    }

    private void filterLogItemByLoanInterestChange() {
        if (showAll) {
            changeLogItemList.setListData(ChangeLog.getInstance().createHeadersForJListFilterByLoanInterestChange());
        } else {
            changeLogItemList.setListData(ChangeLog.getInstance().createHeadersForJListFilterByLoanInterestChangeAndEmployeeID(this.bankStaffUser.getEmploymentID()));
        }
    }

    private void filterLogItemByAccountInterestChange() {
        if (showAll) {
            changeLogItemList.setListData(ChangeLog.getInstance().createHeadersForJListFilterByAccountInterestChange());
        } else {
            changeLogItemList.setListData(ChangeLog.getInstance().createHeadersForJListFilterByAccountInterestChangeAndEmployeeID(this.bankStaffUser.getEmploymentID()));
        }
    }



    private void showLogItemInMainPanel(String logItemHeader) {
        int logItemID = Integer.parseInt(logItemHeader.split(" ")[2]);
        String logItemContent = ChangeLog.getInstance().getLogItemContentByID(logItemID);
        String[] strArr = logItemContent.split("\n");

        for (Component comp : mainPanelContent.getComponents()) {
            comp.setVisible(false);
        }

        JLabel label;
        for (String str : strArr) {
            label = new JLabel(str);
            label.setFont(new Font("Arial", Font.BOLD, 20));
            mainPanelContent.add(label);
        }
        mainPanelContent.validate();
    }


    private void showGUI() {

        frame.setVisible(true);
    }
}
