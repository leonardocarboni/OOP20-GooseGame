package model.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.StateGame;
import model.board.BoardImpl;
import model.box.Box;
import model.dice.DiceImpl;
import model.player.PlayerImpl;
import model.queue.QueueImpl;
import model.rank.RankImpl;
import utility.file.FileUtilityImpl;

public class GameImpl {

	private static final int BOARD_SIZE = 41;
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
		playerQueue.setStartingQueue(pl);
		playerQueue.resetIterator();
		rank.setRanking(playerList);
	}

	public int choosePlayersQueue() {
		final int diceValue = dice.roll();
		throwDice.put(playerQueue.getCurrent(), diceValue);
		checkEndChoosePhase();
		return diceValue;
	}

	public int rollCurrentPlayer() {
		final int diceValue = dice.roll();
		playerQueue.getCurrent().addPosition(diceValue);
		return diceValue;
	}

	public void addMinigameResult(final int value) {
		playerQueue.getCurrent().addPosition(value);
	}
	
	public Box playCurrentPlayer() {
		return gameBoard.getBox(playerQueue.getCurrent());
	}

	public List<PlayerImpl> getScoreBoard(){
		rank.updateRanking();
		return rank.getRanking(); 
	}

	public PlayerImpl nextPlayer() {
		return playerQueue.next();
	}

	public boolean endGame() {
		if (playerQueue.getCurrent().getBoardPosition() == BOARD_SIZE) {
			stateGame =  StateGame.END;
		}else {
			goBeyoundLimit(playerQueue.getCurrent());
			stateGame =  StateGame.CONTINUE;
		}
		return stateGame.equals(StateGame.END);
	}

	public void saveResultGame() {
		final FileUtilityImpl<PlayerImpl> fu = new FileUtilityImpl<>(FILE_NAME);
		fu.saveInformation(rank.getRanking());
	}

	public StateGame getStateGame() {
		return stateGame;
	}
	
	private void goBeyoundLimit(final PlayerImpl p) {
		if(p.getBoardPosition() > BOARD_SIZE ) {
			p.addPosition(-(p.getBoardPosition() - BOARD_SIZE)*2);
		}else if (p.getBoardPosition() < 0) {
			p.resetPosition();
		}
	}

	private void checkEndChoosePhase() {
		if(throwDice.size() == pl.size()) {
			playerQueue.orderPlayerQueue(throwDice);
			playerQueue.resetIterator();
			stateGame = StateGame.CONTINUE;
		}
	}
}
