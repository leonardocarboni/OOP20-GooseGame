package application.minigame.phrasecatch;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class PhraseCatchView{

    @FXML
    Button submitButton;
    @FXML
    TextField inputTextField;
    @FXML
    Label textLabel, timeLabel;

    private final Stage primaryStage = new Stage();
    private static final String LAYOUT_LOCATION = "layouts/phrasecatch.fxml";
    private static final String LOGO_LOCATION = "logo.png";

    public PhraseCatchView(){
        try {
            final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(LAYOUT_LOCATION));
            loader.setController(this);
            final Scene scene = new Scene(loader.load());
            primaryStage.initModality(Modality.APPLICATION_MODAL);
            primaryStage.setTitle("[GooseGame] Phrase Catch");
            primaryStage.getIcons().add(new Image(LOGO_LOCATION));
            primaryStage.setOnHiding(e -> primaryStage.setIconified(true));
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the view Sentence Text field and variable
     * @param sentence - the sentence to be copied
     */
    public void setPhrase(String sentence){
        this.textLabel.setText(sentence);
    }

    public Label getTimeLabel(){
        return timeLabel;
    }

    public String getInputText(){
        return inputTextField.getText();
    }

    public void show() {
        primaryStage.showAndWait();
    }

    public void addButtonListener(final EventHandler<ActionEvent> eventHandler) {
        submitButton.setOnAction(eventHandler);
    }

}
