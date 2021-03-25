package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.StateGame;
import model.board.BoardImpl;
import model.box.Box;
import model.dice.DiceImpl;
import model.player.PlayerImpl;
import model.queue.QueueImpl;
import model.rank.RankImpl;
import utility.fileUtility.FileUtilityImpl;
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
	private Label currentPlayerLabel, firstPlayer,secondPlayer,thirdPlayer,fourthPlayer;

	@Override
    public void initialize(final URL location, final ResourceBundle resources) {
		final DiceImpl dice = new DiceImpl();
		final List<PlayerImpl> l = new ArrayList<>();
		l.add(new PlayerImpl("Ciao"));
		l.add(new PlayerImpl("Ciao2"));
		l.add(new PlayerImpl("Ciao22"));
		final QueueImpl playerQueue = new QueueImpl();
		startingDice(l,dice,playerQueue);
		playerQueue.resetIterator();
		final RankImpl rank = new RankImpl(l);
		final BoardImpl gameBoard = new BoardImpl(42);
		gameBoard.generateBoard();
		currentPlayerLabel.setText(playerQueue.getCurrent().getName());
		diceButton.setOnMouseClicked((event) -> {
			final int diceValue = dice.roll();
			playerQueue.getCurrent().addPosition(diceValue);
			rank.updateRanking();
			if(gameBoard.endGame(playerQueue.getCurrent()).equals(StateGame.ENDGAME)) {
				final FileUtilityImpl fu = new FileUtilityImpl();
				fu.saveFileRanking(rank.getRanking());
				/*Game Ending*/
			}else {
				final Box box = gameBoard.getBox(playerQueue.getCurrent());
				check(box);
				updateViewRank(rank.getRanking());
				playerQueue.next();
				currentPlayerLabel.setText(playerQueue.getCurrent().getName());
			}		
		});
	}

	private void check(final Box b) {
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

	private void startingDice(final List<PlayerImpl> p,final DiceImpl dice, final QueueImpl q) {
		final Iterator<PlayerImpl> i = p.iterator();
		final Map<PlayerImpl, Integer> throwDice = new HashMap<>();
		while(i.hasNext()){
			final int value = dice.roll();
			final PlayerImpl ps = i.next();
			throwDice.put(ps, value);
		}
		q.orderPlayerQueue(throwDice);
		System.out.println(throwDice);
	}
	
	private void updateViewRank(final List<PlayerImpl> rankingList) {
		firstPlayer.setText(rankingList.get(0).getName());
		secondPlayer.setText(rankingList.get(1).getName());
		thirdPlayer.setText(rankingList.size() == 3 ? rankingList.get(2).getName() : "");
		fourthPlayer.setText(rankingList.size() == 4 ? rankingList.get(3).getName() : ""); 
	}
}
