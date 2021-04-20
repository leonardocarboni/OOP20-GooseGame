package application.minigame.tictactoe.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import application.minigame.tictactoe.fxItem.BackgroundLoader;
import application.minigame.tictactoe.fxItem.ItemFactoryImpl;
import application.minigame.tictactoe.interfaces.TTTView;
import application.minigame.tictactoe.mainGame.TicTacToe;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * View of the game. {@link TTTView}
 */
public class TTTViewImpl implements TTTView {
    /**
     * Dimension of the grid
     */
    private int gridDim = TicTacToe.getGridDim();

    /**
     * Number of the button in the grid.
     */
    private int NUMBER_OF_BUTTON;

    /**
     * Create an instance of the controller.
     */
    public static final TTTControllerImpl HANDLER = new TTTControllerImpl();

    /**
     * Create an instance of the controller for checks who is the winner.
     */
    public static final TTTModelImpl MODEL = new TTTModelImpl();

    /**
     * Create the stage.
     */
    private Stage stage;



    private static List<Integer> number = new ArrayList<>();

    private static List<Integer> number2 = new ArrayList<>();

    /**
     * List of buttons present in the main 3x3 grid.
     */
    private static final List<Button> LIST_BUTTON_GRID = new ArrayList<>();

    /**
     * List of buttons under the 3x3 grid.
     */
    private final List<Button> listBottomButton = new ArrayList<>();

    /**
     * It is used to see if dark mode is selected
     */
    private boolean isDark = false;

    /**
     * Button factory for use button.
     */
    private final ItemFactoryImpl btn = new ItemFactoryImpl();

    /**
     * Controller class constructor. Create the button list in the game.
     */
    public TTTViewImpl() {
        NUMBER_OF_BUTTON = this.gridDim * this.gridDim;

        for (int i = this.gridDim - 2; i >= 0; i--) {
            for (int j = 0; j < 1; j++) {
                number2.add(j, i);
            }
        }

        for (int i = this.gridDim - 1; i >= 0; i--) {
            for (int j = 0; j < this.gridDim; j++) {
                number.add(j, i);
            }
        }

        /**
         * Add the buttons on the List.
         */
        for (int i = 0; i < NUMBER_OF_BUTTON; i++) {
            LIST_BUTTON_GRID.add(btn.gridButton(HANDLER));
        }

        /**
         * Add the change color button.
         */
        listBottomButton.add(0, btn.gameDarkModeIcon(HANDLER));

    }

    @Override
    public void drawO() {
        for (int i = 0; i < NUMBER_OF_BUTTON; i++) {
            final Random rnd = new Random();
            final int numCase = rnd.nextInt(gridDim * gridDim);
            if (LIST_BUTTON_GRID.get(numCase).getText().equals("")) {
                LIST_BUTTON_GRID.get(numCase).setText("O");
                MODEL.getWinCondition().accept(MODEL.checkWin());
                return;
            }
        }
    }

    @Override
    public void drawX(final Event evt, final Consumer<String> winCondition) {
        for (int i = 0; i < NUMBER_OF_BUTTON; i++) {
            if (evt.getSource().equals(LIST_BUTTON_GRID.get(i)) && LIST_BUTTON_GRID.get(i).getText().equals("")) {
                LIST_BUTTON_GRID.get(i).setText("X");
                winCondition.accept(MODEL.checkWin());
                drawO();
            }
        }
    }

    @Override
    public GridPane createButton() {
        final GridPane root = new GridPane();

        LIST_BUTTON_GRID.stream().forEach(
                i -> root.add(i, LIST_BUTTON_GRID.indexOf(i) % gridDim, number.get(LIST_BUTTON_GRID.indexOf(i)), 1, 1));
        listBottomButton.stream().forEach(i -> root.add(i, number2.get(listBottomButton.indexOf(i)), gridDim, 1, 1));
        root.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
        return root;
    }

    @Override
    public void releaseButton(final Event event) {
        for (int i = 0; i < NUMBER_OF_BUTTON; i++) {
            if (event.getSource().equals(LIST_BUTTON_GRID.get(i)) && LIST_BUTTON_GRID.get(i).getText().equals("")) {
                if (!isDark) {
                } else {
                    LIST_BUTTON_GRID.get(i).setBackground(new Background(BackgroundLoader.GAME_BUTTON_BACKGROUND_BLACK));
                }
            }
        }
    }

    @Override
    public void changeColor() {
        if (!isDark) {
            isDark = true;
            changeAllDark();
            listBottomButton.get(0).setBackground(new Background(BackgroundLoader.CHANGE_COLOR_BUTTON));
        } else if (isDark) {
            isDark = false;
            changeAllWhite();
            listBottomButton.get(0).setBackground(new Background(BackgroundLoader.DARK_BUTTON_ICON));
        }
    }

    /**
     * Function in support of color change, puts them black.
     */
    private void changeAllDark() {
        for (int i = 0; i < NUMBER_OF_BUTTON; i++) {
            LIST_BUTTON_GRID.get(i).setBackground(new Background(BackgroundLoader.GAME_BUTTON_BACKGROUND_BLACK));
        }
    }

    /**
     * Function in support of color change, puts them white.
     */
    private void changeAllWhite() {
        for (int i = 0; i < NUMBER_OF_BUTTON; i++) {
            LIST_BUTTON_GRID.get(i).setBackground(new Background(BackgroundLoader.GAME_BUTTON_BACKGROUND));
        }
    }

    /**
     * Clear the button text.
     */
    public static void clear(){
        LIST_BUTTON_GRID.stream().forEach(i -> i.setText(""));
    }

    public void setStage(final Stage stage) {
        this.stage = stage;
    }

    public static List<Button> getListButton() {
        return LIST_BUTTON_GRID;
    }

    public Stage getStage() {
        return stage;
    }

    public boolean isDark() {
        return isDark;
    }
}