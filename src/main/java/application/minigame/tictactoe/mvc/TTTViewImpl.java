package application.minigame.tictactoe.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import application.minigame.tictactoe.fxItem.BackgroundLoader;
import application.minigame.tictactoe.fxItem.ItemFactoryImpl;
import application.minigame.tictactoe.interfaces.TTTView;
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

    private int GRID_DIM;
    private int NUMBER_OF_BUTTON;

    /**
     * Create an instance of the controller.
     */
    public static final TTTControllerImpl handler = new TTTControllerImpl();

    /**
     * Create an instance of the controller for checks who is the winner.
     */
    public static final TTTModelImpl model = new TTTModelImpl();

    /**
     * Create the stage.
     */
    public Stage stage;



    private static List<Integer> number = new ArrayList<>();

    private static List<Integer> number2 = new ArrayList<>();

    /**
     * List of buttons present in the main 3x3 grid.
     */
    private static final List<Button> listButtonGrid = new ArrayList<>();

    /**
     * List of buttons under the 3x3 grid.
     */
    private final List<Button> listBottomButton = new ArrayList<>();

    /**
     * It is used to see if dark mode is selected
     */
    public boolean isDark = false;

    final ItemFactoryImpl btn = new ItemFactoryImpl();

    /**
     * Controller class constructor. Create the button list in the game.
     */
    public TTTViewImpl(final int gridDim) {
        GRID_DIM = gridDim;
        NUMBER_OF_BUTTON = GRID_DIM * GRID_DIM;

        for (int i = GRID_DIM - 2; i >= 0; i--) {
            for (int j = 0; j < 1; j++) {
                number2.add(j, i);
            }
        }

        for (int i = GRID_DIM - 1; i >= 0; i--) {
            for (int j = 0; j < GRID_DIM; j++) {
                number.add(j, i);
            }
        }

        /**
         * Add the buttons on the List.
         */
        for (int i = 0; i < NUMBER_OF_BUTTON; i++) {
            listButtonGrid.add(btn.gridButton(handler));
        }

        /**
         * Add the change color button.
         */
        listBottomButton.add(0, btn.gameDarkModeIcon(handler));

    }

    @Override
    public void drawO() {
        for (int i = 0; i < NUMBER_OF_BUTTON; i++) {
            final Random rnd = new Random();
            final int numCase = rnd.nextInt(GRID_DIM * GRID_DIM);
            if (listButtonGrid.get(numCase).getText().equals("")) {
                listButtonGrid.get(numCase).setText("O");
                model.winCondition.accept(model.checkWin());
                return;
            }
        }
    }

    @Override
    public void drawX(final Event evt, final Consumer<String> winCondition) {
        for (int i = 0; i < NUMBER_OF_BUTTON; i++) {
            if (evt.getSource().equals(listButtonGrid.get(i)) && listButtonGrid.get(i).getText().equals("")) {
                listButtonGrid.get(i).setText("X");
                winCondition.accept(model.checkWin());
                drawO();
            }
        }
    }

    @Override
    public GridPane createButton() {
        final GridPane root = new GridPane();

        listButtonGrid.stream().forEach(
                i -> root.add(i, listButtonGrid.indexOf(i) % GRID_DIM, number.get(listButtonGrid.indexOf(i)), 1, 1));
        listBottomButton.stream().forEach(i -> root.add(i, number2.get(listBottomButton.indexOf(i)), GRID_DIM, 1, 1));
        root.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
        return root;
    }

    @Override
    public void releaseButton(final Event event) {
        for (int i = 0; i < NUMBER_OF_BUTTON; i++) {
            if (event.getSource().equals(listButtonGrid.get(i)) && listButtonGrid.get(i).getText().equals("")) {
                if (!isDark) {
                } else {
                    listButtonGrid.get(i).setBackground(new Background(BackgroundLoader.gameButtonBackgroundBlack));
                }
            }
        }
    }

    @Override
    public void changeColor() {
        if (!isDark) {
            isDark = true;
            changeAllDark();
            listBottomButton.get(0).setBackground(new Background(BackgroundLoader.darkButtonIconDark));
        } else if (isDark) {
            isDark = false;
            changeAllWhite();
            listBottomButton.get(0).setBackground(new Background(BackgroundLoader.darkButtonIcon));
        }
    }

    /**
     * Function in support of color change, puts them black.
     */
    private void changeAllDark() {
        for (int i = 0; i < NUMBER_OF_BUTTON; i++) {
            listButtonGrid.get(i).setBackground(new Background(BackgroundLoader.gameButtonBackgroundBlack));
        }
    }

    /**
     * Function in support of color change, puts them white.
     */
    private void changeAllWhite() {
        for (int i = 0; i < NUMBER_OF_BUTTON; i++) {
            listButtonGrid.get(i).setBackground(new Background(BackgroundLoader.gameButtonBackground));
        }
    }

    /**
     * Clear the button text.
     */
    public static void clear(){
        listButtonGrid.stream().forEach(i -> i.setText(""));
    }

    public void setStage(final Stage stage) {
        this.stage = stage;
    }

    public static List<Button> getListButton() {
        return listButtonGrid;
    }

}
