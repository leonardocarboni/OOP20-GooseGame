package view;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MinigameView extends View {

    @FXML
    private Button quitButton;

    public MinigameView(final ViewType gameType) {
        super.createStage(gameType);
        this.getStage().setOnCloseRequest(Event::consume);
        quitButton.setDisable(true);
        quitButton.setOnAction(e -> this.close());
    }

    public void showAndWaitResult() {
        this.getStage().showAndWait();
    }

    public void enableQuitButton(){
        this.quitButton.setDisable(false);
    }
}
