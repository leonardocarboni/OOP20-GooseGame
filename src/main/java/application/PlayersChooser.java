package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlayersChooser extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        final Parent root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/playerselection.fxml"));
        final Scene scene = new Scene(root, 830, 510);

        /* Stage configuration */
        primaryStage.setTitle("[GooseGame] Choose Players");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

}
