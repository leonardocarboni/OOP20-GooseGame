package application.minigame.memory;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import view.MinigameView;
import view.ViewType;

import java.util.List;

public class MemoryView extends MinigameView {

    @FXML
    private List<Button> buttonList;

    @FXML
    private Button checkButton, quitButton;

    @FXML
    private Label secretCodeLabel, timeLabel;

    public MemoryView() {
        super(ViewType.MEMORY);
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

}
