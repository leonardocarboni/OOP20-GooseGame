package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class SceneStarter extends Application{
	
	private static final String URL_ICON = "logo.png";
	private final String title;
	private final String layout;
	private final Double height;
	private final Double width;
	
	@Override
	public void start(final Stage primaryStage) throws Exception {
		final Parent root = FXMLLoader.load(ClassLoader.getSystemResource(layout));
        final Scene scene = new Scene(root, width, height);

        /* Stage configuration */
        primaryStage.setTitle("[GooseGame]" + title);
        primaryStage.getIcons().add(new Image(URL_ICON));
        primaryStage.setOnHiding(e -> {
            primaryStage.setIconified(true);
        });
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
	}
	
	public SceneStarter(final GamesViewType type) {
		final Rectangle2D screenBounds = Screen.getPrimary().getBounds();
		this.title = type.getTitle();
		this.layout = type.getLayoutLocation();
		this.width = screenBounds.getWidth() / type.getProportionWidth();
		this.height = screenBounds.getHeight() / type.getProportionHeight();
	}
	
}
