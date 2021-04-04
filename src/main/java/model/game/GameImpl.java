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
		playerQueue.setStartingQueue(pl);
		playerQueue.resetIterator();
		rank.setRanking(playerList);
	}

	public int rollCurrentPlayer() {
		final int diceValue = dice.roll();
		if(stateGame.equals(StateGame.CHOOSE_STARTING_QUEUE)) {
			throwDice.put(playerQueue.getCurrent(), diceValue);
			checkEndChoosePhase();
		}else {
			playerQueue.getCurrent().addPosition(diceValue);
		}
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

	public boolean end() {
		return endGame(playerQueue.getCurrent()).equals(StateGame.END);
	}

	public StateGame endGame(final PlayerImpl p) {
		if (p.getBoardPosition() == BOARD_SIZE) {
			return StateGame.END;
		}else {
			goBeyoundLimit(p);
			return StateGame.CONTINUE;
		}
	}

	private void goBeyoundLimit(final PlayerImpl p) {
		if(p.getBoardPosition() > BOARD_SIZE ) {
			p.addPosition(-(p.getBoardPosition() - BOARD_SIZE)*2);
		}else if (p.getBoardPosition() < 0) {
			p.resetPosition();
		}
	}
	
	public void saveResultGame() {
		final FileUtilityImpl fu = new FileUtilityImpl(FILE_NAME);
		fu.saveInformation(rank.getRanking());
	}
}
