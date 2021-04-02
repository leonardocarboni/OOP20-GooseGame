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
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainGameView implements Initializable {
	
	@FXML
    private Button diceButton;
	@FXML
	private Label currentPlayerLabel;
	@FXML
	private ImageView diceImage;
	@FXML
	private List<Label> scoreBoard;
	
	private final Stage primaryStage = new Stage();
	private static final String LAYOUT_LOCATION = "layouts/maingame.fxml";
	private static final String LOGO_LOCATION = "logo.png";
	
	public MainGameView() {
		try {
    		final Rectangle2D screenBounds = Screen.getPrimary().getBounds();
	        final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(LAYOUT_LOCATION));
	        loader.setController(this);
	        final AnchorPane flowPane = loader.load();
	        final Scene scene = new Scene(flowPane, screenBounds.getWidth() / 2, screenBounds.getHeight() / 2);
	        /* Stage configuration */
	        primaryStage.setTitle("[GooseGame]");
	        primaryStage.getIcons().add(new Image(LOGO_LOCATION));
	        primaryStage.setOnHiding(e -> {
	            primaryStage.setIconified(true);
	        });
	        primaryStage.setScene(scene);
	        primaryStage.setResizable(false);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
	}
	
	public void show() {
		primaryStage.show();
	}
	
	@Override
    public void initialize(final URL location, final ResourceBundle resources) {
	}

	public void changeImageDice(final int value) {
		
	}

	public void changeScoreboard(final List<String> list) {
		int i = 0;
		for (final String p : list) {
			scoreBoard.get(i).setText(p);
			i++;
		}
	}

	public void changePlayerLabel(final String s) {
		currentPlayerLabel.setText(s);
	}

	public void addButtonListener(final EventHandler<ActionEvent> eventHandler) {
        diceButton.setOnAction(eventHandler);
    }
}