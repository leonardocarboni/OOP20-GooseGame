package application.minigame.tictactoe.mvc;

import java.util.List;
import java.util.function.Consumer;

import application.minigame.tictactoe.interfaces.TTTModel;
import application.minigame.tictactoe.mainGame.EndgameThread;
import application.minigame.tictactoe.mainGame.TicTacToe;
import javafx.scene.control.Button;

/**
 * Model of the game. {@link TTTModel}
 */
public class TTTModelImpl implements TTTModel {

    private int numberOfClick = 0;
    private final GettersMVC getters = new GettersMVC();

    /**
     * This is the grid dim, used for algorithm.
     */
    private final int bound = getters.getSize();

    /**
     * Button of the grid.
     */
    private List<Button> listButtonGrid;
    private final List<String> sign = List.of("X", "O");

    @Override
    public String checkWin() {
        this.numberOfClick++;
        this.listButtonGrid = TTTViewImpl.getListButton();
        for (int i = 0; i <= (bound) * (bound - 1); i += bound) {
            for (int j = 0; j < 2; j++) {
                int counter = 0;
                for (int k = 0; k < bound; k++) {
                    if (listButtonGrid.get(i + k).getText().equals(sign.get(j))) {
                        counter++;
                    }
                    if (counter == bound) {
                        return sign.get(j);
                    }
                }
            }
        }
        for (int i = 0; i < bound; i++) {
            for (int j = 0; j < 2; j++) {
                int counter = 0;
                for (int k = 0; k <= (bound) * (bound - 1); k += bound) {
                    if (listButtonGrid.get(i + k).getText().equals(sign.get(j))) {
                        counter++;
                    }
                    if (counter == bound) {
                        return sign.get(j);
                    }
                }
            }
        }
        for (int j = 0; j < 2; j++) {
            int counter = 0;
            for (int i = 0; i <= (bound * bound)-1; i += bound+1 ) {
                if (listButtonGrid.get(i).getText().equals(sign.get(j))) {
                    counter++;
                }
                if (counter == bound) {
                    return sign.get(j);
                }
            }
        }
        for (int j = 0; j < 2; j++) {
            int counter = 0;
            for (int i = bound - 1; i <= (bound * bound); i += bound - 1) {
                if (listButtonGrid.get(i).getText().equals(sign.get(j))) {
                    counter++;
                }
                if (counter == bound) {
                    return sign.get(j);
                }
            }
        }

        if (numberOfClick >= bound * bound) {
            return "No one";
        }
        return "";
    }

    /**
     * Used for check the winner and start the end game thread.
     */
    public final Consumer<String> winCondition = winner -> {
        if (!winner.equals("")) {
            TicTacToe.isWin = true;

            EndgameThread my = new EndgameThread(winner);
            my.start();
        }
    };

}
