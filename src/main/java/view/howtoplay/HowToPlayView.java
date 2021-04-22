package view.howtoplay;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.box.Box;
import view.NormalView;
import view.ViewType;

public class HowToPlayView extends NormalView {

    private static final String MAINGAMEDESC = "Start by choosing the names of the players and their color,\n"
            + "remember that you can not play with less than two people and players can not have the same name!\n"
            + "The game starts with an initial phase in which all players must roll the dice,\n"
            + "the starting order is based on the score you make.\n"
            + "To advance, just roll the dice until you reach the final square.\n"
            + "In the path there are various mini-games that can help you to advance or turn back.\n"
            + "If by rolling the dice you overtake the final square, you will go back by the number you overtook it.\n";

    @FXML
    private Label howToPlayDescLabel, cableConnectDescLabel, ticTacToeDescLabel, phraseCatchDescLabel,
            memoryDescLabel, rockPaperScissorsDescLabel, spaceShooterDescLabel, evenOrOddDescLabel, threeCardDescLabel;

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
        threeCardDescLabel.setText(Box.THREE_CARD_GAME.getDescription());
    }


}
