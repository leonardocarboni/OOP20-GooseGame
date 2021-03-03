package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application{

    private static final int SCENE_WIDTH = 600;
    private static final int SCENE_HEIGHT = 480;


    @Override
	public void start(Stage primaryStage) throws Exception {
        final Parent root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/menu.fxml"));
        final Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        /* Stage configuration */
        primaryStage.setTitle("[GooseGame] Menu");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
		
	}
	
	public static void main(String[] args) {
        launch(args);
    }
}