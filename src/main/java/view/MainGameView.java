package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.StateGame;
import model.board.BoardImpl;
import model.box.Box;
import model.dice.DiceImpl;
import model.player.PlayerImpl;
import model.queue.QueueImpl;
import model.rank.RankImpl;
import utility.file.FileUtilityImpl;
import view.GamesViewType;
import view.MinigameStarter;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class MainGameController implements Initializable {
	
	@FXML
    private Button diceButton;
	@FXML
	private Label currentPlayerLabel;
	@FXML
	private ImageView diceImage;
	@FXML
	private Button mg1Button;
	@FXML
	private List<Label> scoreBoard;
	
	private final List<PlayerImpl> plList = new ArrayList<>();
	private final DiceImpl dice = new DiceImpl();
	private final QueueImpl playerQueue = new QueueImpl();
	private final RankImpl rank = new RankImpl();
	private final BoardImpl gameBoard = new BoardImpl(42);
	private final Map<PlayerImpl, Integer> throwDice = new HashMap<>();
	private boolean t = true;
	
	@Override
    public void initialize(final URL location, final ResourceBundle resources) {
		plList.add(new PlayerImpl("Ciao"));
		plList.add(new PlayerImpl("Ciao1"));
		gameBoard.generateBoard();
		playerQueue.setStartingQueue(plList);
		playerQueue.resetIterator();
		rank.setRanking(plList);
		updateView(rank.getRanking());
		diceButton.setOnAction(e -> startGame());
	}

	private void startGame() {
		
		if(t) {
			throwDice.put(playerQueue.next(), dice.roll());	
			if(throwDice.size() == plList.size()) {
				playerQueue.orderPlayerQueue(throwDice);
				playerQueue.resetIterator();
				updateView(playerQueue.getStartingQueue());
				t = false;
			}
		}else {
			playerQueue.getCurrent().addPosition(dice.roll());
			if(gameBoard.endGame(playerQueue.getCurrent()).equals(StateGame.ENDGAME)) {
				final FileUtilityImpl fu = new FileUtilityImpl();
				fu.saveFileRanking(rank.getRanking());
				Platform.exit();
				System.exit(0);
			}else {
				final Box box = gameBoard.getBox(playerQueue.getCurrent());
				checkMinigames(box);
				rank.updateRanking();
				updateView(rank.getRanking());
				playerQueue.next();
			}
		}
	}

	private void checkMinigames(final Box b) {
		final Stage s = new Stage();
		s.initModality(Modality.APPLICATION_MODAL);
        s.setMinHeight(600);
        s.setMinWidth(800);
        
        MinigameStarter minigameScene = null;
		switch(b) {
			case BONUS:
				minigameScene = new MinigameStarter(GamesViewType.GAME);
				break;
			case TICTACTOE:
				minigameScene = new MinigameStarter(GamesViewType.TICTACTOE);
				break;
			case EVEN_OR_ODD:
				minigameScene = new MinigameStarter(GamesViewType.EVEN_OR_ODD);
				break;
			case ROCK_PAPER_SCISSORS:
				minigameScene = new MinigameStarter(GamesViewType.ROCK_PAPER_SCISSORS);
				break;
			case CABLE_CONNECT:
				minigameScene = new MinigameStarter(GamesViewType.CABLE_CONNECT);
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
		//minigameScene.getResult();
	}
	
	private void updateView(final List<PlayerImpl> rankingList) {
		int i = 0;
		System.out.println(rankingList);
		for (final PlayerImpl player : rankingList) {
			scoreBoard.get(i).setText(player.getName() + " " + player.getBoardPosition());
			i++;
		}
		currentPlayerLabel.setText(playerQueue.getCurrent().getName());
	}
}