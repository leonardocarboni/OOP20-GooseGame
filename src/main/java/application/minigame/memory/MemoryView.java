package application.minigame.memory;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MemoryView {

    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9;

    @FXML
    private Button checkButton;

    @FXML
    private Label secretCodeLabel, resultLabel;

    private static final String LAYOUT_LOCATION = "layouts/memory.fxml";
    private static final String LOGO_LOCATION = "logo.png";
    private final Stage primaryStage = new Stage();

    public MemoryView() {
        try {
            System.out.println(ClassLoader.getSystemResource(LAYOUT_LOCATION));

            final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(LAYOUT_LOCATION));
            loader.setController(this);
            final Scene scene = new Scene(loader.load());
            primaryStage.initModality(Modality.APPLICATION_MODAL);
            primaryStage.setTitle("[GooseGame] Memory");
            primaryStage.getIcons().add(new Image(LOGO_LOCATION));
            primaryStage.setOnHiding(e -> primaryStage.setIconified(true));
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);


        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public Label getSecretCodeLabel() {
        return this.secretCodeLabel;
    }

    public void show() {
        this.primaryStage.showAndWait();
    }
}
