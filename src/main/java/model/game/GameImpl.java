package model.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.board.BoardImpl;
import model.box.Box;
import model.dice.DiceImpl;
import model.player.PlayerImpl;
import model.queue.QueueImpl;
import model.rank.RankImpl;
import utility.file.FileUtilityImpl;

public class GameImpl implements Game {

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

    @Override
    public void start(final List<PlayerImpl> playerList) {
        gameBoard.generateBoard();
        stateGame = StateGame.CHOOSE_STARTING_QUEUE;
        pl = playerList;
        initPlayers(playerList);
        playerQueue.setStartingQueue(pl);
        playerQueue.resetIterator();
        rank.setRanking(playerList);
    }

    @Override
    public int choosePlayersQueue() {
        final int diceValue = dice.roll();
        throwDice.put(playerQueue.getCurrent(), diceValue);
        checkEndChoosePhase();
        return diceValue;
    }

    @Override
    public int rollCurrentPlayer() {
        final int diceValue = dice.roll();
        movePlayer(diceValue);
        return diceValue;
    }

    @Override
    public void movePlayer(final int value) {
        playerQueue.getCurrent().addPosition(value);
    }

    @Override
    public Box playCurrentPlayer() {
        return gameBoard.getBox(playerQueue.getCurrent());
    }

    @Override
    public List<PlayerImpl> getScoreBoard() {
        rank.updateRanking();
        return rank.getRanking();
    }

    @Override
    public PlayerImpl nextPlayer() {
        return playerQueue.next();
    }

    @Override
    public boolean endGame() {
        if (playerQueue.getCurrent().getBoardPosition() == BOARD_SIZE) {
            stateGame = StateGame.END;
        } else {
            goBeyoundLimit(playerQueue.getCurrent());
            stateGame = StateGame.CONTINUE;
        }
        return stateGame.equals(StateGame.END);
    }

    @Override
    public void saveResultGame() {
        final FileUtilityImpl<PlayerImpl> fu = new FileUtilityImpl<>(FILE_NAME);
        fu.saveInformation(rank.getRanking());
    }

    @Override
    public StateGame getStateGame() {
        return stateGame;
    }

    /**
     * 
     * @param p
     */
    private void goBeyoundLimit(final PlayerImpl p) {
        if (p.getBoardPosition() > BOARD_SIZE) {
            p.addPosition(-(p.getBoardPosition() - BOARD_SIZE) * 2);
        } else if (p.getBoardPosition() < 0) {
            p.resetPosition();
        }
    }

    /**
     * Check end phase.
    */
    private void checkEndChoosePhase() {
        if (throwDice.size() == pl.size()) {
            playerQueue.orderPlayerQueue(throwDice);
            playerQueue.resetIterator();
            stateGame = StateGame.CONTINUE;
        }
    }

    /**
     * Reset all players position.
     * Usefull with a second new game with same players.
     * @param players
     */
    private void initPlayers(final List<PlayerImpl> players) {
        for (final PlayerImpl p : players) {
            p.resetPosition();
        }
    }
}
