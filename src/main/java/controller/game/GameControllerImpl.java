package controller.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import application.minigame.cableconnect.CableConnectController;
import application.minigame.evenodd.mainGame.EvenOdd;
import application.minigame.phrasecatch.PhraseCatchController;
import application.minigame.rockpaparscissors.RPSController;
import application.minigame.spaceshooter.mainGame.SpaceShooter;
import application.minigame.tictactoe.mainGame.TicTacToe;
import controller.minigame.MinigameController;
import controller.winscreen.WinScreen;
import controller.winscreen.WinScreenImpl;
import javafx.scene.paint.Color;
import model.box.Box;
import model.duration.Duration;
import model.duration.DurationImpl;
import model.game.GameImpl;
import model.game.StateGame;
import model.player.PlayerColor;
import model.player.PlayerImpl;
import org.apache.commons.lang3.time.StopWatch;

import view.ViewType;
import view.game.GameViewImpl;

public class GameControllerImpl {

    private final GameViewImpl view;
    private final GameImpl game;
    private final StopWatch stopwatch;

    public GameControllerImpl() {
        view = new GameViewImpl();
        game = new GameImpl();
        stopwatch = new StopWatch();
    }

    public void startGame(final List<PlayerImpl> playersList) {
        view.createStage(ViewType.GAME);
        game.start(playersList);
        stopwatch.start();

        view.changeAllBoxes(createMap(game.getScoreBoard()));
        view.changePlayerLabel(game.nextPlayer().getName());
        view.addButtonListener(event -> {
            changeViewGameState();
        });
        view.show();
    }
    /**
     * Load Minigames .
     * 
     * @param box - type of box where the player is now.
     * @return minigame result or 0 if is not a minigame
     */
    public int checkMinigames(final Box box) {
        MinigameController minigameScene = null;
        switch (box) {
        case BONUS:
            break;
        case TICTACTOE:
            minigameScene = new TicTacToe();
            break;
        case EVEN_OR_ODD:
            minigameScene = new EvenOdd();
            break;
        case ROCK_PAPER_SCISSORS:
            minigameScene = new RPSController();
            break;
        case CABLE_CONNECT:
            minigameScene = new CableConnectController();
            break;
        case PHRASE_CATCH:
            minigameScene = new PhraseCatchController();
            break;
        case SPACESHOOTER:
            minigameScene = new SpaceShooter();
            break;
        case MEMORY:
            minigameScene = null;
            break;
        default:
            break;
        }
        return minigameScene != null ? minigameScene.getResult() : 0;
    }

    /**
     * create a map that associates each player with their own View color.
     * 
     * @param list - players list
     * @return map
     */
    private Map<Color, Integer> createMap(final List<PlayerImpl> list) {
        final Map<Color, Integer> map = new HashMap<>();
        list.forEach(p -> {
            Color color;
            if (p.getColor() == PlayerColor.BLUE) {
                color = Color.BLUE;
            } else if (p.getColor() == PlayerColor.PINK) {
                color = Color.PINK;
            } else if (p.getColor() == PlayerColor.RED) {
                color = Color.RED;
            } else {
                color = Color.YELLOW;
            }
            map.put(color, p.getBoardPosition());
        });
        return map;
    }

    /**
     * Change view and call MODEL method according the game state.
     */
    public void changeViewGameState() {
        if (game.getStateGame().equals(StateGame.CHOOSE_STARTING_QUEUE)) {
            //view.changeGameStateLabel("Initial PHASE");
            view.changeImageDice(game.choosePlayersQueue());
        } else if (game.getStateGame().equals(StateGame.CONTINUE)) {
            //view.changeGameStateLabel("GAME");
            view.changeImageDice(game.rollCurrentPlayer());
            if (game.endGame()) {
                endGamefunction();
            }
            int miniGameResult = checkMinigames(game.playCurrentPlayer());
            game.movePlayer(miniGameResult);
            view.showResult(miniGameResult);
            view.changeScoreboard(game.getScoreBoard().stream().map(PlayerImpl::getName).collect(Collectors.toList()));
            view.changeAllBoxes(createMap(game.getScoreBoard()));
        }
        view.changePlayerLabel(game.nextPlayer().getName());
    }

    /**
     * Method groups all the things to do at the end of the game.
     */
    private void endGamefunction() {
        stopwatch.stop();
        final Duration duration = new DurationImpl(stopwatch.getTime());
        view.changeGameStateLabel("END_GAME - TIME: " + duration.getDuration());
        game.saveResultGame();
        view.close();
        final WinScreen winScreen = new WinScreenImpl();
        winScreen.start(game.getScoreBoard());
    }
}
