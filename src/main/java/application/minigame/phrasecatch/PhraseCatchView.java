package application.minigame.phrasecatch;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.View;
import view.ViewType;

public class PhraseCatchView extends View {

    @FXML
    Button submitButton;
    @FXML
    TextField inputTextField;
    @FXML
    Label textLabel, timeLabel;

    public PhraseCatchView(){
        super.createStage(ViewType.PHRASE_CATCH);
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

    public void addButtonListener(final EventHandler<ActionEvent> eventHandler) {
        submitButton.setOnAction(eventHandler);
    }

}
