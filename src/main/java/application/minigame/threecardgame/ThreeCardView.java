package application.minigame.threecardgame;

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

public class ThreeCardView {

    @FXML
    private Button quitButton, sxButton, centerButton, dxButton;

    @FXML
    private Label playerScoreLabel, computerScoreLabel;

    private static final String LAYOUT_LOCATION = "layouts/tree-card.fxml";
    private static final String LOGO_LOCATION = "logo.png";

    private final Stage primaryStage = new Stage();
    private Image image;

    public ThreeCardView() {
        try {
            final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(LAYOUT_LOCATION));
            loader.setController(this);
            final Scene scene = new Scene(loader.load());
            primaryStage.initModality(Modality.APPLICATION_MODAL);
            primaryStage.setTitle("[GooseGame] Tree-Card game");
            primaryStage.getIcons().add(new Image(LOGO_LOCATION));
            primaryStage.setOnHiding(e -> primaryStage.setIconified(true));
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void setSxButton(EventHandler<ActionEvent> e) {
        this.sxButton.setOnAction(e);
    }

    public void setCenterButton(EventHandler<ActionEvent> e) {
        this.centerButton.setOnAction(e);
    }

    public void setDxButton(EventHandler<ActionEvent> e) {
        this.centerButton.setOnAction(e);
    }

    public void setPlayerScoreLabel(int score) {
        playerScoreLabel.setText("" + score);
    }

    public void setComputerScoreLabel(int score) {
        computerScoreLabel.setText("" + score);
    }

    public void show() {
        primaryStage.showAndWait();
    }
}
