package application.minigame.tictactoe.mainGame;

import application.minigame.tictactoe.mvc.TTTViewImpl;
import controller.minigame.MinigameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class TicTacToe extends Application implements MinigameController {
    /**
     * Dimension of the grid.
     */
    private static int gridDim = roll();

    /**
     * Width and Height of the game.
     */
    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 480;

    /**
     * When you win this variable becomes true. If you lose it remains false.
     */
    private static boolean isWin = false;

    /**
     * Create an instance of the view.
     */
    private static TTTViewImpl view = new TTTViewImpl();
    /**
     * Set the primary stage.
     */
    public static final Stage PRIMARY_STAGE = new Stage();


    public TicTacToe() {
        start(PRIMARY_STAGE);
    }

    /**
     * Start the game.
     *
     * @param primaryStage
     */
    @Override
    public void start(final Stage primaryStage) {

        /**
         * Set the principal Stage
         */

        view.setStage(primaryStage);

        primaryStage.setTitle("TicTacToe");

        /**
         * The view return the grid panel with buttons in it
         */
        GridPane root = view.createButton();

        primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public int getResult() {
        TTTViewImpl.clear();
        if (isWin) {
            return 3;
        } else {
            return 0;
        }
    }

    public static int getGridDim() {
        return gridDim;
    }

    public static boolean isWin() {
        return isWin;
    }

    public static void setWin(final boolean isWin) {
        TicTacToe.isWin = isWin;
    }

    public static int getSceneWidth() {
        return SCENE_WIDTH;
    }

    public static int getSceneHeight() {
        return SCENE_HEIGHT;
    }

    public static TTTViewImpl getView() {
        return view;
    }

    private static int roll() {
        return new Random().nextInt(4) + 3;
    }
}
