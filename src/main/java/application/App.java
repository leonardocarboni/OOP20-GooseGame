package application;

import application.minigame.threecardgame.TreeCardController;
import controller.menu.MenuController;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final TreeCardController menu = new TreeCardController();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}
