package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.player.PlayerImpl;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

public class PlayersChooserController implements Initializable {
    @FXML
    private Button startButton;
    @FXML
    private TextField name1, name2, name3, name4;
    @FXML
    private Label errorLabel;

    final private Set<TextField> textFiledSet = new HashSet<>();
    final private List<PlayerImpl> playersList = new ArrayList<>();

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        initializeSet();
        initializeEventHandlers();
    }

    /**
     * Initializes players selection set
     */
    private void initializeSet(){
        textFiledSet.add(name1);
        textFiledSet.add(name2);
        textFiledSet.add(name3);
        textFiledSet.add(name4);
    }

    /**
     * Initializes event handlers (mouse click on start)
     */
    private void initializeEventHandlers() {
        startButton.setOnMouseClicked(e -> {

            //number of players enabled
            final int numEnabled = textFiledSet.stream().mapToInt(tf -> tf.getText().trim().isEmpty() ? 0 : 1).sum();

            //number of unique names (only of the enabled player)
            int numNames = (int) textFiledSet.stream().filter(tf -> !tf.getText().trim().isEmpty())
                    .map(tf -> tf.getText()).distinct().count();

            if (numEnabled < 2){
                errorLabel.setText("YOU MUST ENTER AT LEAST 2 PLAYERS");
            } else if (numEnabled == numNames) {

                textFiledSet.stream().filter(tf -> !tf.getText().isEmpty())
                        .forEach(tf -> playersList.add(new PlayerImpl(tf.getText())));

                final Stage newStage = new Stage();
                final Stage s = (Stage) errorLabel.getParent().getScene().getWindow();
                s.close();
                newStage.initModality(Modality.APPLICATION_MODAL);
                newStage.setMinHeight(800);
                newStage.setMinWidth(600);
                //MainGame gameScene = new MainGame(playersList);
                try {
                	//gameScene.start(newStage);
                } catch (Exception ex){
                	System.out.println(ex);
                    System.out.println("Errore nell'apertura");
                }
            }
            else{
                errorLabel.setText("EVERY PLAYER MUST HAVE AN UNIQUE NAME");
            }
        });
    }
}
