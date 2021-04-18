package application.minigame.memory;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;


public class MemoryView {

    @FXML
    private List<Button> buttonList;

    @FXML
    private Button checkButton, quitButton;

    @FXML
    private Label secretCodeLabel, timeLabel;

    private static final String LAYOUT_LOCATION = "layouts/memory2.fxml";
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

    public void showSecretLabel(final String code) {
        this.secretCodeLabel.setText(code);
    }

    public Label getTime() {
        return this.timeLabel;
    }

    public void checkButtonListener(final EventHandler<ActionEvent> eventHandler) {
        checkButton.setOnAction(eventHandler);
    }

    public void buttonListener(final EventHandler<ActionEvent> eventHandler) {
        buttonList.forEach(b -> b.setOnAction(eventHandler));
    }

    public void show() {
        this.primaryStage.showAndWait();
    }



}
