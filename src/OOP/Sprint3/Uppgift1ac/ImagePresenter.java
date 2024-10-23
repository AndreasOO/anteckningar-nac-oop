package OOP.Sprint3.Uppgift1ac;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class ImagePresenter {
    private final JFrame frame;
    private final JPanel panel;
    private final JLabel label;
    private final JButton button;
    private final List<String> imageList;
    private final Path filePath;
    private final List<Path> imageFileNames;


    public ImagePresenter(Path filePath) {
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.label = new JLabel();
        this.button = new JButton("Change picture");
        this.imageList = new ArrayList<>();
        this.filePath = filePath;
        this.imageFileNames = populateFileNames(Paths.get("pictures"));

    }

    public void init() {
        this.frame.setSize(800, 600);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);

        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
        this.panel.add(this.label);
        this.panel.add(this.button);

        this.label.setIcon(new ImageIcon(filePath.toString()));

        this.frame.add(this.panel);
        this.frame.pack();

        addEventListeners();



    }

    protected List <Path> populateFileNames(Path directoryPath){
        List<Path> list = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath)) {
            for (Path file: stream) {
                list.add(file);
            }
        } catch (IOException | DirectoryIteratorException x) {
            x.printStackTrace();
        }
        return list;
    }

    private void addEventListeners() {
        this.button.addActionListener(e -> {
            if (e.getSource() == this.button) {
                changePicture();
            }
        });
    }

    private void changePicture() {
        int index = new Random().nextInt(0,imageFileNames.size());
        this.label.setIcon(new ImageIcon(imageFileNames.get(index).toString()));
    }
}
