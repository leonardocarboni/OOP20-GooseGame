package view.threecard;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.choice.ThreeCardGameChoice;
import view.MinigameView;
import view.ViewType;


public class ThreeCardView extends MinigameView {

    @FXML
    private Button quitButton, sxButton, centerButton, dxButton, nextRoundButton;

    @FXML
    private Label playerScoreLabel, computerScoreLabel;

    @FXML
    private ImageView sxImage, centerImage, dxImage;

    private static final String BACK_IMAGE = "logo.png";
    private static final String RIGHT_IMAGE = "threeCard/right.png";
    private static final String WRONG_IMAGE = "threeCard/wrong.png";


    public ThreeCardView() {
        super(ViewType.THREE_CARD_GAME);
        nextRoundButton.setDisable(true);
    }

    public void setSxButton(final EventHandler<ActionEvent> e) {
        this.sxButton.setOnAction(e);
    }

    public void setCenterButton(final EventHandler<ActionEvent> e) {
        this.centerButton.setOnAction(e);
    }

    public void setDxButton(final EventHandler<ActionEvent> e) {
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

    public void setContinueButton(final EventHandler<ActionEvent> e) {
        this.nextRoundButton.setOnAction(e);
    }

    public void setPlayerScoreLabel(final int score) {
        playerScoreLabel.setText(" " + score);
    }

    public void setComputerScoreLabel(final int score) {
        computerScoreLabel.setText(" " + score);
    }

    public void setImages(final ThreeCardGameChoice choice) {
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
        default:
            break;
        }
    }

    public void setBackImage() {
        sxImage.setImage(new Image(BACK_IMAGE));
        centerImage.setImage(new Image(BACK_IMAGE));
        dxImage.setImage(new Image(BACK_IMAGE));
    }

    public void setDisableNextRoundButton() {
        nextRoundButton.setDisable(true);
    }

    public void setEnableNextRoundButton() {
        nextRoundButton.setDisable(false);
    }
}
