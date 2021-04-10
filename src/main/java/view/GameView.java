package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Map.Entry;

public class GameView extends View implements Initializable {
	
	@FXML
    private Button diceButton;
	@FXML
	private Label currentPlayerLabel;
	@FXML
	private ImageView diceImage;
	@FXML
	private List<Label> scoreBoard;
	@FXML 
	private List<HBox> gameboard;
	@FXML
	private Label gameState;

	@Override
    public void initialize(final URL location, final ResourceBundle resources) {
	}

	public void changeImageDice(final int value) {
		String nameDiceImage = "";
		switch(value) {
		case 1:
			nameDiceImage = "diceOne.png";
			break;
		case 2:
			nameDiceImage = "diceTwo.png";
			break;
		case 3:
			nameDiceImage = "diceThree.png";
			break;
		case 4:
			nameDiceImage = "diceFour.png";
			break;
		case 5:
			nameDiceImage = "diceFive.png";
			break;
		case 6:
			nameDiceImage = "diceSix.png";
			break;
		}
		diceImage.setImage(new Image(ClassLoader.getSystemResource("dice/" + nameDiceImage).toString()));
	}

	public void changeScoreboard(final List<String> list) {
		int i = 0;
		for (final String p : list) {
			scoreBoard.get(i).setText(p);
			i++;
		}
	}

	public void changeGameStateLabel(final String s) {
		gameState.setText(s);
	}

	public void changePlayerLabel(final String s) {
		currentPlayerLabel.setText(s);
	}

	public void addButtonListener(final EventHandler<ActionEvent> eventHandler) {
        diceButton.setOnAction(eventHandler);
    }
	
	public void resetAllButtons() {
		for(int i = 0; i < gameboard.size(); i++) {
			gameboard.get(i).getChildren().clear();
		}
	}

	public void changeAllButtons(final Map<Color,Integer> position) {
		resetAllButtons();
		for (final Entry<Color,Integer> p : position.entrySet()) {
			System.out.println(p.getValue());
			gameboard.get(p.getValue()).getChildren().add(createCircle(p.getKey()));
		}
	}
	
	private Circle createCircle(final Color c) {
		final Circle circle = new Circle();
		circle.setFill(c);
		circle.setRadius(5.0f);
		return circle;
	}
}