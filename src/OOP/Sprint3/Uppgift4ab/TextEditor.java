package OOP.Sprint3.Uppgift4ab;



import javax.swing.*;
import java.awt.*;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;


public class TextEditor {
    private final JFrame frame;
    private final JPanel mainPanel;
    private final JPanel toolbarPanel;
    private final JLabel fileNameLabel;
    private final JTextField fileNameTextField;
    private final JButton openButton;
    private final JButton saveButton;
    private final JButton printButton;
    private final JButton exitButton;
    private final JPanel textAreaPanel;
    private final JScrollPane scrollPane;
    private final JTextArea textArea;
    private final List<Path> availableFiles;


    TextEditor(){
        frame = new JFrame("Text Editor");
        mainPanel = new JPanel();
        toolbarPanel = new JPanel();
        fileNameLabel = new JLabel("File Name:");
        fileNameTextField = new JTextField();
        openButton = new JButton("Open");
        saveButton = new JButton("Save");
        printButton = new JButton("Print");
        exitButton = new JButton("Exit");
        textAreaPanel = new JPanel();
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);

        availableFiles = populateFileNames(Paths.get("textfiles-sprint3"));
    }

    public void init() {
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(mainPanel);

        textAreaPanel.setLayout(new GridLayout(1,1));
        textAreaPanel.add(scrollPane);


        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(toolbarPanel, BorderLayout.NORTH);
        mainPanel.add(textAreaPanel, BorderLayout.CENTER);

        toolbarPanel.setLayout(new GridLayout(1,6));
        toolbarPanel.add(fileNameLabel);
        toolbarPanel.add(fileNameTextField);
        toolbarPanel.add(openButton);
        toolbarPanel.add(saveButton);
        toolbarPanel.add(printButton);
        toolbarPanel.add(exitButton);


        addEventListeners();


    }



    private void addEventListeners() {

        fileNameTextField.addActionListener(e -> {
            textArea.setText(openFile(fileNameTextField.getText()));
        });


        openButton.addActionListener(e -> {
            if (e.getSource() == openButton) {
                textArea.setText(openFile(fileNameTextField.getText()));
            }
        });

        saveButton.addActionListener(e -> {
            if (e.getSource() == saveButton) {
                saveToFile(fileNameTextField.getText());
            }
        });

        printButton.addActionListener(e -> {
            if (e.getSource() == printButton) {
                JOptionPane.showMessageDialog(frame, "Printing document...");
            }
        });

        exitButton.addActionListener(e -> {
            if (e.getSource() == exitButton) {
                System.exit(0);
            }
        });
    }

    private String openFile(String fileName) {
        try {
            Path path = findFileName(fileName);
            return getFileContent(path);
        } catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(frame, e.getMessage());
        }
        return "something went wrong";
    }

    private void saveToFile(String fileName) {
        try {
            Path path = findFileName(fileName);
            writeToFile(path);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(frame, e.getMessage());
        }
    }

    private Path findFileName(String fileName) {
        for (Path path : availableFiles) {
            if (fileName.equals(path.getFileName().toString())) {
                return path;
            }
        } throw new IllegalArgumentException(("Incorrect filename"));
    }

    private String getFileContent(Path path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            reader.lines().forEach(line -> sb.append(line).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private void writeToFile(Path path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(), true))) {
            writer.write("\n" + textArea.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private java.util.List<Path> populateFileNames(Path directoryPath){
        List<Path> list = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath)) {
            for (Path file: stream) {
                list.add(file);
            }
        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }
        return list;
    }

}
