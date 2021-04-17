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


public class MemoryView {

    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9;

    @FXML
    private Button checkButton;

    @FXML
    private Label secretCodeLabel, resultLabel, TimeLabel;

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

    public void hideSecretLabel() {
        this.secretCodeLabel.setText("*****");
    }

    public Label getTime() {
        return this.TimeLabel;
    }

    public Label getResultLabel() {
        return this.resultLabel;
    }

    public void addButtonListener(final EventHandler<ActionEvent> eventHandler) {
        button1.setOnAction(eventHandler);
        button2.setOnAction(eventHandler);
        button3.setOnAction(eventHandler);
        button4.setOnAction(eventHandler);
        button5.setOnAction(eventHandler);
        button6.setOnAction(eventHandler);
        button7.setOnAction(eventHandler);
        button8.setOnAction(eventHandler);
        button9.setOnAction(eventHandler);
        checkButton.setOnAction(eventHandler);
    }

    public void show() {
        this.primaryStage.showAndWait();
    }

}
