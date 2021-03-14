package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGame extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        final Parent root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/maingame.fxml"));
        final Scene scene = new Scene(root, 800, 600);

        /* Stage configuration */
        primaryStage.setTitle("[GooseGame] GooseGame");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
