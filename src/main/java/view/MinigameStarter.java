package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import controller.MinigameController;

public class MinigameStarter extends Application{
	
	private static final String URL_ICON = "logo.png";
	private final String title;
	private final String layout;
	private final Double height;
	private final Double width;
	private MinigameController minigameController;

	@Override
	public void start(final Stage primaryStage) throws Exception {
		final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(layout));
		final Parent root = loader.load();
		minigameController = loader.getController();
        final Scene scene = new Scene(root, width, height);

        //Stage configuration
        primaryStage.setTitle("[GooseGame]" + title);
        primaryStage.getIcons().add(new Image(URL_ICON));
        primaryStage.setOnHiding(e -> {
            primaryStage.setIconified(true);
        });
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
	}
	
	public MinigameStarter(final GamesViewType type) {
		final Rectangle2D screenBounds = Screen.getPrimary().getBounds();
		this.title = type.getTitle();
		this.layout = type.getLayoutLocation();
		this.width = screenBounds.getWidth() / type.getProportionWidth();
		this.height = screenBounds.getHeight() / type.getProportionHeight();
	}
	
	public void main(final String[] args) {
        launch(args);
    }

	public int getResult() {
		return minigameController.getResult();
	}
}
