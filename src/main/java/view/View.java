package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class View {

    private final Stage primaryStage = new Stage();
    private static final String LOGO_LOCATION = "logo.png";
    private Scene scene;

    public void createStage(final ViewType gameType) {
        try {
            final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(gameType.getLayoutLocation()));
            loader.setController(this);
            scene = new Scene(loader.load());
            primaryStage.setTitle("[GooseGame] " + gameType.getTitle());
            primaryStage.initModality(Modality.APPLICATION_MODAL);
            primaryStage.getIcons().add(new Image(LOGO_LOCATION));
            primaryStage.setOnHiding(e -> {
                primaryStage.setIconified(true);
            });
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        primaryStage.close();
    }

    public Stage getStage() {
        return this.primaryStage;
    }

    public Scene getScene(){
        return this.scene;
    }
}
