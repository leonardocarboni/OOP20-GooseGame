package application;

import controller.MainGameController;
import controller.PlayersChooserController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainGame extends Application {

	private static final String LAYOUT_LOCATION = "layouts/maingame.fxml";
	private static final String LOGO_LOCATION = "logo.png";

    @Override
    public void start(final Stage primaryStage) throws Exception {
		try {
    		final Rectangle2D screenBounds = Screen.getPrimary().getBounds();
	        final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(LAYOUT_LOCATION));
	        final MainGameController controller = new MainGameController();
	        loader.setController(controller);
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
	        primaryStage.show();

    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
