package model.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.board.Board;
import model.board.BoardImpl;
import model.box.Box;
import model.dice.Dice;
import model.dice.DiceImpl;
import model.player.Player;
import model.queue.Queue;
import model.queue.QueueImpl;
import model.rank.Rank;
import model.rank.RankImpl;
import utility.file.FileUtilityImpl;

public final class GameImpl implements Game {

    private static final int BOARD_SIZE = 42;
    private static final String FILE_NAME = "GooseRanking.json";
    private final Dice dice;
    private final Queue playerQueue;
    private final Rank rank;
    private final Board gameBoard;
    private final Map<Player, Integer> throwDice;
    private List<Player> playerList;
    private StateGame stateGame;

    public GameImpl() {
        playerQueue = new QueueImpl();
        dice = new DiceImpl();
        rank = new RankImpl();
        throwDice = new HashMap<>();
        gameBoard = new BoardImpl();
        stateGame = StateGame.START;
    }

    @Override
    public void start(final List<Player> playerList) {
        this.playerList = playerList;
        initPlayers(playerList);
        stateGame = StateGame.CHOOSE_STARTING_QUEUE;
        gameBoard.setSize(BOARD_SIZE);
        gameBoard.generateBoard();
        playerQueue.setStartingQueue(playerList);
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
    public List<Player> getScoreBoard() {
        rank.updateRanking();
        return rank.getRanking();
    }

    @Override
    public Player nextPlayer() {
        return playerQueue.next();
    }

    @Override
    public boolean endGame() {
        if (playerQueue.getCurrent().getBoardPosition() == BOARD_SIZE - 1) {
            stateGame = StateGame.END;
        } else {
            goBeyoundLimit(playerQueue.getCurrent());
            stateGame = StateGame.CONTINUE;
        }
        return stateGame.equals(StateGame.END);
    }

    @Override
    public void saveResultGame() {
        final FileUtilityImpl<Player> fu = new FileUtilityImpl<>(FILE_NAME);
        fu.saveInformation(rank.getRanking(), false, Player.class);
    }

    @Override
    public StateGame getStateGame() {
        return stateGame;
    }

    /**
     * Check if player went above the board limit.
     * @param p
     */
    private void goBeyoundLimit(final Player p) {
        if (p.getBoardPosition() > BOARD_SIZE - 1) {
            p.addPosition(-(p.getBoardPosition() - (BOARD_SIZE - 1)) * 2);
        } else if (p.getBoardPosition() < 0) {
            p.resetPosition();
        }
    }

    /**
     * Check if all players have rolled the dice once.
    */
    private void checkEndChoosePhase() {
        if (throwDice.size() == playerList.size()) {
            playerQueue.orderPlayerQueue(throwDice);
            playerQueue.resetIterator();
            stateGame = StateGame.CONTINUE;
        }
    }

    /**
     * Reset all players position.
     * Useful with a second new game with same players.
     * 
     * @param players
     */
    private void initPlayers(final List<Player> players) {
        for (final Player p : players) {
            p.resetPosition();
        }
    }
}
