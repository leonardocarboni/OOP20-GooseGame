package view;

import controller.menu.MenuController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuView implements Initializable {

    @FXML
    private Button playButton;
    @FXML
    private Button howToPlayButton;
    @FXML
    private Button exitButton;
    
	private static final String LAYOUT_LOCATION = "layouts/menu.fxml";
	private static final String LOGO_LOCATION = "logo.png";
	private final Stage stage = new Stage();

    public MenuView() {
    	try {
            final FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(LAYOUT_LOCATION));    
            loader.setController(this);
            final Scene scene = new Scene(loader.load());
            
            stage.setTitle("[GooseGame]");
            stage.getIcons().add(new Image(LOGO_LOCATION));
            stage.setOnHiding(e -> {
            	stage.setIconified(true);
            });
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    
    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
    	exitButton.setOnAction(e -> closeStage());
    }

    public void addPlayButtonListener(final EventHandler<ActionEvent> playClicked) {
    	playButton.setOnAction(playClicked);
    }
    
    public void closeStage() {
    	stage.close();
    }

    public void addHowToPlayButtonListener(MenuController.HowToPlayClicked howToPlayClicked) {
        howToPlayButton.setOnAction(howToPlayClicked);
    }
}
