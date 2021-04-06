package view;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class HowToPlayView {

    private final Stage primaryStage = new Stage();
    private static final String LAYOUT_LOCATION = "layouts/howtoplay.fxml";
    private static final String LOGO_LOCATION = "logo.png";

    public HowToPlayView(){
        try {
            final Rectangle2D screenBounds = Screen.getPrimary().getBounds();
            final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(LAYOUT_LOCATION));
            loader.setController(this);
            final TabPane tabPane = loader.load();
            final Scene scene = new Scene(tabPane, screenBounds.getWidth() / 2, screenBounds.getHeight() / 2);
            /* Stage configuration */
            primaryStage.setTitle("[GooseGame] How To Play");
            primaryStage.initModality(Modality.APPLICATION_MODAL);
            primaryStage.getIcons().add(new Image(LOGO_LOCATION));
            primaryStage.setOnHiding(e -> {
                primaryStage.setIconified(true);
            });
            primaryStage.setScene(scene);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        primaryStage.show();
    }

}
