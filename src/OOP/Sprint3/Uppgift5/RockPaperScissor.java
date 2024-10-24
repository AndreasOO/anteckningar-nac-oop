package OOP.Sprint3.Uppgift5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissor{
    JFrame frame;
    JPanel mainPanel;
    JPanel titleTopPanel;
    JPanel centralPanel;
    JPanel humanSidePanel;
    JPanel resultPanel;
    JPanel computerSidePanel;

    JLabel humanSideTopLabel;
    JLabel computerSideTopLabel;
    JLabel titleTopLabel;

    JButton humanRock;
    JButton humanPaper;
    JButton humanScissor;

    JButton computerRock;
    JButton computerPaper;
    JButton computerScissor;

    JLabel winnerTitleLabel;
    JLabel winnerResultLabel;

    JLabel scoreTitleLabel;
    JLabel scoreHumanTitleLabel;
    JLabel scoreComputerTitleLabel;
    int humanWinsCounter;
    int computerWinsCounter;




    public RockPaperScissor() {
        frame = new JFrame("Rock Paper Scissor");
        mainPanel = new JPanel();
        titleTopPanel = new JPanel();
        centralPanel = new JPanel();
        humanSidePanel = new JPanel();
        resultPanel = new JPanel();
        computerSidePanel = new JPanel();

        humanSideTopLabel = new JLabel("Human");
        computerSideTopLabel = new JLabel("Computer");
        titleTopLabel = new JLabel("Rock Paper Scissor");

        humanRock = new JButton("Rock");
        humanPaper = new JButton("Paper");
        humanScissor = new JButton("Scissor");
        computerRock = new JButton("Rock");
        computerPaper = new JButton("Paper");
        computerScissor = new JButton("Scissor");

        winnerTitleLabel = new JLabel("Winner");
        winnerResultLabel = new JLabel("Not yet decided");

        scoreTitleLabel = new JLabel("Score");
        scoreHumanTitleLabel = new JLabel("Human: 0");
        scoreComputerTitleLabel = new JLabel("Computer: 0");




    }

    public void init() {
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(mainPanel);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(titleTopPanel, BorderLayout.NORTH);
        mainPanel.add(centralPanel, BorderLayout.CENTER);

        titleTopPanel.setLayout(new GridLayout(1,3));
        titleTopLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        titleTopPanel.add(humanSideTopLabel);
        titleTopPanel.add(titleTopLabel);
        titleTopPanel.add(computerSideTopLabel);

        centralPanel.setLayout(new GridLayout(1,3));
        centralPanel.add(humanSidePanel);
        centralPanel.add(resultPanel);
        centralPanel.add(computerSidePanel);

        humanSidePanel.setLayout(new GridLayout(3,1));
        humanSidePanel.add(humanRock);
        humanSidePanel.add(humanPaper);
        humanSidePanel.add(humanScissor);

        computerSidePanel.setLayout(new GridLayout(3,1));
        computerSidePanel.add(computerRock);
        computerSidePanel.add(computerPaper);
        computerSidePanel.add(computerScissor);

        resultPanel.setLayout(new GridLayout(5,1));
        resultPanel.add(winnerTitleLabel);
        resultPanel.add(winnerResultLabel);
        resultPanel.add(scoreTitleLabel);
        resultPanel.add(scoreHumanTitleLabel);
        resultPanel.add(scoreComputerTitleLabel);


        addEventListeners();

    }

    private void addEventListeners() {
        humanRock.addActionListener(e -> {
            humanRock.setEnabled(false);
            battle(Choice.ROCK);
            resetGame();
        });


        humanPaper.addActionListener(e -> {
            humanPaper.setEnabled(false);
            battle(Choice.PAPER);
            resetGame();
        });

        humanScissor.addActionListener(e -> {
            humanScissor.setEnabled(false);
            battle(Choice.SCISSORS);
            resetGame();
        });
    }

    private void battle(Choice humanChoice) {
        Choice computerChoice = Choice.values()[new Random().nextInt(0,3)];

        switch (computerChoice) {
            case ROCK -> computerRock.setEnabled(false);
            case PAPER -> computerPaper.setEnabled(false);
            case SCISSORS -> computerScissor.setEnabled(false);
        }

        if (humanChoice == computerChoice) {
            winnerResultLabel.setText("Draw!");
        }
        else if (humanChoice == Choice.ROCK && computerChoice == Choice.SCISSORS) {

            winnerResultLabel.setText("Human winner!");
            scoreHumanTitleLabel.setText(String.format("Human: %d", ++humanWinsCounter));
        }
        else if (humanChoice == Choice.PAPER && computerChoice == Choice.ROCK) {
            winnerResultLabel.setText("Human winner!");
            scoreHumanTitleLabel.setText(String.format("Human: %d", ++humanWinsCounter));
        }
        else if (humanChoice == Choice.SCISSORS && computerChoice == Choice.PAPER) {
            winnerResultLabel.setText("Human winner!");
            scoreHumanTitleLabel.setText(String.format("Human: %d", ++humanWinsCounter));
        }
        else {
            winnerResultLabel.setText("Computer winner!");
            scoreComputerTitleLabel.setText(String.format("Computer: %d", ++computerWinsCounter));
        }



    }

    private void resetGame() {
        new Timer(1000, e -> {
            humanRock.setEnabled(true);
            humanPaper.setEnabled(true);
            humanScissor.setEnabled(true);
            computerRock.setEnabled(true);
            computerPaper.setEnabled(true);
            computerScissor.setEnabled(true);
        }).start();

    }
}
