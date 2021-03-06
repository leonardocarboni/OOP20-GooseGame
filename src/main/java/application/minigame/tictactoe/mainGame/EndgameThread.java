package application.minigame.tictactoe.mainGame;

import application.minigame.tictactoe.fxItem.BackgroundLoader;
import application.minigame.tictactoe.fxItem.ItemFactoryImpl;
import application.minigame.tictactoe.mvc.GettersMVC;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * Final thread.
 */
public class EndgameThread extends Thread {

    private final GettersMVC getters = new GettersMVC();
    private final String winner;
    /**
     * Duration of animation.
     */
    private final int msOfAnimation = 2000;
    /**
     * It print the winner.
     * @param winner
     */
    public EndgameThread(final String winner) {
        this.winner = winner;
    }

    private Task<Void> sleep = new Task<Void>() {
        @Override
        public Void call() {
            try {
                Thread.sleep(1000);
                Platform.runLater(() -> {
                    getters.getView().getStage().close();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    /**
     * Create the pane and close it after 1 sec.
     */
    public void run() {
        Platform.runLater(() -> {
            final StackPane pane = new StackPane();
            final ItemFactoryImpl button = new ItemFactoryImpl();

            pane.getChildren().add(button.endGameButton(winner));
            if (!getters.getView().isDark()) {
                pane.setBackground(new Background(BackgroundLoader.END_GAME_BUTTON_BACKGROUND));
            } else {
                pane.setBackground(new Background(BackgroundLoader.END_GAME_BUTTON_BACKGROUND_BLACK));
            }

            final FadeTransition ft = new FadeTransition(Duration.millis(msOfAnimation), pane);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();

            getters.getView().getStage().setScene(new Scene(pane, 600, 480));
            new Thread(sleep).start();
        });
    }
}
