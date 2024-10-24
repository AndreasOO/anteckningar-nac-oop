package OOP.Sprint3.Uppgift5;

public class GameReseter implements Runnable {

    RockPaperScissor game;

    GameReseter(RockPaperScissor game) {
        this.game = game;
    }
    @Override
    public void run() {

        game.humanRock.setEnabled(true);
        game.humanPaper.setEnabled(true);
        game.humanScissor.setEnabled(true);
        game.computerRock.setEnabled(true);
        game.computerPaper.setEnabled(true);
        game.computerScissor.setEnabled(true);
    }
}
