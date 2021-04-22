package controller.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import controller.cableconnect.CableConnectController;
import controller.memory.MemoryController;
import application.minigame.evenodd.mainGame.EvenOdd;
import controller.phrasecatch.PhraseCatchController;
import controller.rockpaperscissors.RockPaperScissorsController;
import controller.threecardgame.ThreeCardController;
import application.minigame.spaceshooter.mainGame.SpaceShooter;
import application.minigame.tictactoe.mainGame.TicTacToe;
import controller.minigame.MinigameController;
import controller.winscreen.WinScreen;
import controller.winscreen.WinScreenImpl;
import javafx.scene.paint.Color;
import model.box.Box;
import model.duration.GameDuration;
import model.duration.GameDurationImpl;
import model.game.GameImpl;
import model.game.StateGame;
import model.player.Player;
import model.player.PlayerColor;
import org.apache.commons.lang3.time.StopWatch;

import view.ViewType;
import view.game.GameView;

public class GameControllerImpl {

    private final GameView view;
    private final GameImpl game;
    private final StopWatch stopwatch;

    public GameControllerImpl() {
        view = new GameView();
        game = new GameImpl();
        stopwatch = new StopWatch();
    }

    public void startGame(final List<Player> playersList) {
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
        case TICTACTOE:
            minigameScene = new TicTacToe();
            break;
        case EVEN_OR_ODD:
            minigameScene = new EvenOdd();
            break;
        case ROCK_PAPER_SCISSORS:
            minigameScene = new RockPaperScissorsController();
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
            minigameScene = new MemoryController();
            break;
        case THREE_CARD_GAME:
            minigameScene = new ThreeCardController();
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
    private Map<Color, Integer> createMap(final List<Player> list) {
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
                color = Color.GREEN;
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
            view.changeImageDice(game.choosePlayersQueue());
        } else if (game.getStateGame().equals(StateGame.CONTINUE)) {
            view.changeGameStateLabel("GAME");
            view.changeImageDice(game.rollCurrentPlayer());
            if (game.endGame()) {
                view.changeAllBoxes(createMap(game.getScoreBoard()));
                endGameFunction();
            }
            view.changeAllBoxes(createMap(game.getScoreBoard()));
            final int miniGameResult = checkMinigames(game.playCurrentPlayer());
            game.movePlayer(miniGameResult);
            view.showResult(miniGameResult);
            if (game.endGame()) {
                endGameFunction();
            }
            view.changeScoreboard(game.getScoreBoard().stream().map(Player::getName).collect(Collectors.toList()));
            view.changeAllBoxes(createMap(game.getScoreBoard()));
        }
        view.changePlayerLabel(game.nextPlayer().getName());
    }

    /**
     * Method groups all the things to do at the end of the game.
     */
    private void endGameFunction() {
        final GameDuration duration = new GameDurationImpl(stopwatch.getTime());
        stopwatch.reset();
        game.saveResultGame();
        view.close();
        final WinScreen winScreen = new WinScreenImpl();
        winScreen.start(game.getScoreBoard(), duration);
    }
}
