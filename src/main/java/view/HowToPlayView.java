package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.box.Box;

public class HowToPlayView extends NormalView {

    private static final String MAINGAMEDESC = "Main game desc";

    @FXML
    private Label howToPlayDescLabel, cableConnectDescLabel, ticTacToeDescLabel, phraseCatchDescLabel,
            memoryDescLabel, rockPaperScissorsDescLabel, spaceShooterDescLabel, evenOrOddDescLabel;

    public HowToPlayView() {
        super(ViewType.HOWTOPLAY);
        howToPlayDescLabel.setText(MAINGAMEDESC);
        cableConnectDescLabel.setText(Box.CABLE_CONNECT.getDescription());
        ticTacToeDescLabel.setText(Box.TICTACTOE.getDescription());
        phraseCatchDescLabel.setText(Box.PHRASE_CATCH.getDescription());
        memoryDescLabel.setText(Box.MEMORY.getDescription());
        rockPaperScissorsDescLabel.setText(Box.ROCK_PAPER_SCISSORS.getDescription());
        spaceShooterDescLabel.setText(Box.SPACESHOOTER.getDescription());
        evenOrOddDescLabel.setText(Box.EVEN_OR_ODD.getDescription());
    }


}
