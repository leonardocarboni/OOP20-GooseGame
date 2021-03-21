package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Board;
import model.Dice;
import model.Player;
import model.StateGame;
import utility.Boxes;
import utility.FileUtility;
import utility.Queue;
import utility.Rank;
import view.GamesViewType;
import view.SceneStarter;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class MainGameController implements Initializable {
	
	@FXML
    private Button diceButton;
    
	@Override
    public void initialize(final URL location, final ResourceBundle resources) {
		final Dice dice = new Dice();
		final Queue playerQueue = new Queue();
		final List<Player> l = new ArrayList<>();
		startingDice(l,dice,playerQueue);
		final Rank rank = new Rank(playerQueue.getStartingQueue());
		final Board gameBoard = new Board(42);
		final Iterator<Player> i = playerQueue.getStartingQueue().iterator();
		diceButton.setOnMouseClicked((event) -> {
			final int diceValue = dice.rollDice();
			final Player currentPlayer = i.next();
			currentPlayer.addPosition(diceValue);
			rank.updateRanking();
			if(gameBoard.endGame(currentPlayer).equals(StateGame.ENDGAME)) {
				final FileUtility fu = new FileUtility();
				fu.saveFileRanking(rank.getRanking());
				/*Game Ending*/
			}else {
				final Boxes box = gameBoard.getBox(currentPlayer);
				check(box);
			}
					
		});
	}

	private void check(final Boxes b) {
		final Stage s = new Stage();
		s.initModality(Modality.APPLICATION_MODAL);
        s.setMinHeight(600);
        s.setMinWidth(800);
        SceneStarter minigameScene = null;
		switch(b) {
			case BONUS:
				minigameScene = new SceneStarter(GamesViewType.GAME);
				break;
			case TICTACTOE:
				minigameScene = new SceneStarter(GamesViewType.TICTACTOE);
				break;
			case EVEN_OR_ODD:
				minigameScene = new SceneStarter(GamesViewType.EVEN_OR_ODD);
				break;
			case ROCK_PAPER_SCISSORS:
				minigameScene = new SceneStarter(GamesViewType.ROCK_PAPER_SCISSORS);
				break;
			case CABLE_CONNECT:
				minigameScene = new SceneStarter(GamesViewType.CABLE_CONNECT);
				break;
		default:
			break;
		}
		try {
			minigameScene.start(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void startingDice(final List<Player> p,final Dice dice, final Queue q) {
		final Iterator<Player> i = p.iterator();
		final Map<Player, Integer> throwDice = new HashMap<>();
		while(i.hasNext()) {
			throwDice.put(i.next(), dice.rollDice());
		}
		q.orderPlayerQueue(throwDice);
	}
}
