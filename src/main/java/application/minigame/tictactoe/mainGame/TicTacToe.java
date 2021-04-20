package application.minigame.tictactoe.mainGame;

import application.minigame.tictactoe.interfaces.TTTView;
import application.minigame.tictactoe.mvc.TTTViewImpl;
import controller.minigame.MinigameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToe extends Application implements MinigameController {


    public static int GRID_DIM;

    /**
     * Width and Height of the game.
     */
    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 480;

    /**
     * When you win this variable becomes true.
     * If you lose it remains false.
     */
    public static boolean isWin = false;

    /**
     * Create an instance of the view.
     */
    public static final TTTViewImpl view = new TTTViewImpl(GRID_DIM);

    public static final Stage primaryStage = new Stage();

    /**
     * Constructor, it takes a grid dim.
     * The dim can be: 3,4,5,6
     * @param gridDim
     */
    public TicTacToe(int gridDim)  {
        GRID_DIM = gridDim;
        start(primaryStage);
    }

    /**
     * Start the game
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
            return 1;
        } else {
            return 0;
        }
    }
}
