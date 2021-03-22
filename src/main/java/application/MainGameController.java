package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	
	@FXML
	private Label currentPlayerLabel;
    
	@Override
    public void initialize(final URL location, final ResourceBundle resources) {
		final Dice dice = new Dice();
		final List<Player> l = new ArrayList<>();
		l.add(new Player("Ciao"));
		l.add(new Player("Ciao2"));
		l.add(new Player("Ciao22"));
		final Queue playerQueue = new Queue();
		startingDice(l,dice,playerQueue);
		playerQueue.resetIterator();
		final Rank rank = new Rank(l);
		final Board gameBoard = new Board(42);
		gameBoard.generateBoard();
		currentPlayerLabel.setText(playerQueue.getCurrent().getName());
		diceButton.setOnMouseClicked((event) -> {
			final int diceValue = dice.roll();
			playerQueue.getCurrent().addPosition(diceValue);
			rank.updateRanking();
			if(gameBoard.endGame(playerQueue.getCurrent()).equals(StateGame.ENDGAME)) {
				final FileUtility fu = new FileUtility();
				fu.saveFileRanking(rank.getRanking());
				/*Game Ending*/
			}else {
				final Boxes box = gameBoard.getBox(playerQueue.getCurrent());
				check(box);
				playerQueue.next();
				System.out.println(playerQueue.getCurrent().getBoardPosition());
				currentPlayerLabel.setText(playerQueue.getCurrent().getName());
				System.out.println(rank.getRanking());
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
		if(minigameScene != null) {
			try {
				//minigameScene.start(s);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void startingDice(final List<Player> p,final Dice dice, final Queue q) {
		final Iterator<Player> i = p.iterator();
		final Map<Player, Integer> throwDice = new HashMap<>();
		while(i.hasNext()){
			final int value = dice.roll();
			final Player ps = i.next();
			System.out.println(ps + "" + value);
			throwDice.put(ps, value);
		}
		q.orderPlayerQueue(throwDice);
		System.out.println(throwDice);
	}
}
