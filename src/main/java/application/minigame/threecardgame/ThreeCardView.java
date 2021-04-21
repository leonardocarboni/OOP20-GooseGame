package application.minigame.threecardgame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ThreeCardView {

    @FXML
    private Button quitButton, sxButton, centerButton, dxButton, nextRoundButton;

    @FXML
    private Label playerScoreLabel, computerScoreLabel;

    @FXML
    private ImageView sxImage, centerImage, dxImage;

    private static final String LAYOUT_LOCATION = "layouts/three-card.fxml";
    private static final String LOGO_LOCATION = "logo.png";
    private static final String BACK_IMAGE = "logo.png";
    private static final String RIGHT_IMAGE = "threeCard/right.png";
    private static final String WRONG_IMAGE = "threeCard/wrong.png";

    private final Stage primaryStage = new Stage();


    public ThreeCardView() {
        try {
            final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(LAYOUT_LOCATION));
            loader.setController(this);
            final Scene scene = new Scene(loader.load());
            primaryStage.initModality(Modality.APPLICATION_MODAL);
            primaryStage.setTitle("[GooseGame] Three-Card game");
            primaryStage.getIcons().add(new Image(LOGO_LOCATION));
            primaryStage.setOnHiding(e -> primaryStage.setIconified(true));
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);

        }catch(IOException e) {
            e.printStackTrace();
        }
        setDisableNextRoundButton();
    }

    public void setSxButton(EventHandler<ActionEvent> e) {
        this.sxButton.setOnAction(e);
    }

    public void setCenterButton(EventHandler<ActionEvent> e) {
        this.centerButton.setOnAction(e);
    }

    public void setDxButton(EventHandler<ActionEvent> e) {
        this.dxButton.setOnAction(e);
    }

    public void setDisableButton() {
        this.sxButton.setDisable(true);
        this.centerButton.setDisable(true);
        this.dxButton.setDisable(true);
    }

    public void setEnableButton() {
        this.sxButton.setDisable(false);
        this.centerButton.setDisable(false);
        this.dxButton.setDisable(false);
    }

    public void setContinueButton(EventHandler<ActionEvent> e) {
        this.nextRoundButton.setOnAction(e);
    }

    public void setPlayerScoreLabel(int score) {
        playerScoreLabel.setText("" + score);
    }

    public void setComputerScoreLabel(int score) {
        computerScoreLabel.setText("" + score);
    }

    public void setImages(Choice choice) {
        switch (choice) {
            case SX_POS:
                sxImage.setImage(new Image(RIGHT_IMAGE));
                centerImage.setImage(new Image(WRONG_IMAGE));
                dxImage.setImage(new Image(WRONG_IMAGE));
                break;
            case CENTER_POS:
                centerImage.setImage(new Image(RIGHT_IMAGE));
                sxImage.setImage(new Image(WRONG_IMAGE));
                dxImage.setImage(new Image(WRONG_IMAGE));
                break;
            case DX_POS:
                dxImage.setImage(new Image(RIGHT_IMAGE));
                sxImage.setImage(new Image(WRONG_IMAGE));
                centerImage.setImage(new Image(WRONG_IMAGE));
                break;
        }
    }

    public void setBackImage() {
        sxImage.setImage(new Image(BACK_IMAGE));
        centerImage.setImage(new Image(BACK_IMAGE));
        dxImage.setImage(new Image(BACK_IMAGE));
    }

    public void show() {
        primaryStage.showAndWait();
    }

    public void setDisableNextRoundButton() {
        nextRoundButton.setDisable(true);
    }

    public void setEnableNextRoundButton() {
        nextRoundButton.setDisable(false);
    }
}
