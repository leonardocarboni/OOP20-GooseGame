package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;

public class View {

	try {
		final Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(LAYOUT_LOCATION));
        loader.setController(this);
        final AnchorPane flowPane = loader.load();
        final Scene scene = new Scene(flowPane, screenBounds.getWidth() / 2, screenBounds.getHeight() / 2);
        /* Stage configuration */
        primaryStage.setTitle("[GooseGame]");
        primaryStage.getIcons().add(new Image(LOGO_LOCATION));
        primaryStage.setOnHiding(e -> {
            primaryStage.setIconified(true);
        });
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
	}catch(IOException e) {
		e.printStackTrace();
	}
	
	public void show() {
		primaryStage.show();
	}
}
