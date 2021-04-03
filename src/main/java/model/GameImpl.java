package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.glass.ui.EventLoop.State;

import javafx.application.Platform;
import model.board.BoardImpl;
import model.box.Box;
import model.dice.DiceImpl;
import model.player.PlayerImpl;
import model.queue.QueueImpl;
import model.rank.RankImpl;
import utility.file.FileUtilityImpl;

public class GameImpl {

	private static final int BOARD_SIZE = 42;
	private static final String FILE_NAME = "GooseRanking.json";
	private final DiceImpl dice;
	private final QueueImpl playerQueue;
	private final RankImpl rank;
	private final BoardImpl gameBoard;
	private final Map<PlayerImpl, Integer> throwDice = new HashMap<>();
	private List<PlayerImpl> pl = new ArrayList<>();
	private StateGame stateGame;

	public GameImpl() {
		dice = new DiceImpl();
		playerQueue = new QueueImpl();
		rank = new RankImpl();
		gameBoard = new BoardImpl(BOARD_SIZE);
		stateGame = StateGame.START;
	}

	public void start(final List<PlayerImpl> playerList){
		gameBoard.generateBoard();
		stateGame = StateGame.CHOOSE_STARTING_QUEUE;
		pl = playerList;
		playerQueue.setStartingQueue(playerList);
		playerQueue.resetIterator();
		rank.setRanking(playerList);
	}

	public void playCurrentPlayer() {
		if(stateGame.equals(StateGame.CHOOSE_STARTING_QUEUE)) {
			throwDice.put(playerQueue.getCurrent(), dice.roll());
			checkEndChoosePhase();
		}else {
			playerQueue.getCurrent().addPosition(dice.roll());
			if(gameBoard.endGame(playerQueue.getCurrent()).equals(StateGame.END)) {
				final FileUtilityImpl fu = new FileUtilityImpl(FILE_NAME);
				fu.saveInformation(rank.getRanking());
			}else {
				final Box box = gameBoard.getBox(playerQueue.getCurrent());
				rank.updateRanking();
			}
		}
	}
	

	public List<PlayerImpl> getScoreBoard(){
		return rank.getRanking(); 
	}
	
	private void checkEndChoosePhase() {
		if(throwDice.size() == pl.size()) {
			playerQueue.orderPlayerQueue(throwDice);
			playerQueue.resetIterator();
			stateGame = StateGame.START;
		}
	}

	public PlayerImpl nextPlayer() {
		return playerQueue.next();
	}

	public void end() {

	}
}
