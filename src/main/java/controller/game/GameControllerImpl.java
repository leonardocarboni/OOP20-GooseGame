package controller.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import application.minigame.cableconnect.CableConnectController;
import application.minigame.phrasecatch.PhraseCatchController;
import application.minigame.spaceshooter.info.Info;
import controller.minigame.MinigameController;
import javafx.scene.paint.Color;
import model.StateGame;
import model.box.Box;
import model.duration.Duration;
import model.duration.DurationImpl;
import model.game.GameImpl;
import model.player.PlayerColor;
import model.player.PlayerImpl;
import org.apache.commons.lang3.time.StopWatch;
import view.GameView;
import view.GamesViewType;

public class GameControllerImpl {

	private final GameView view;
	private final GameImpl game;
	private final StopWatch stopwatch;

	public GameControllerImpl(final List<PlayerImpl> playersList) {
		view = new GameView();
		game = new GameImpl();
		view.createStage(GamesViewType.GAME);
		game.start(playersList);

		stopwatch = new StopWatch();
		stopwatch.start();

		view.changeAllButtons(createMap(game.getScoreBoard()));
		view.changePlayerLabel(game.nextPlayer().getName());
		view.addButtonListener(event -> {
			changeViewGameState();
		});
		view.show();
	}

	public int checkMinigames(final Box b) {
		MinigameController minigameScene = null;
		switch(b) {
			case BONUS:
				break;
			case TICTACTOE:
				break;
			case EVEN_OR_ODD:
				minigameScene = new Info();
				break;
			case ROCK_PAPER_SCISSORS:
				break;
			case CABLE_CONNECT:
				minigameScene = new CableConnectController();
				break;
			case PHRASE_CATCH:
				minigameScene = new PhraseCatchController();
			default:
				break;
		}
		return minigameScene != null ? minigameScene.getResult() : 0;
	}

	public Map<Color,Integer> createMap(final List<PlayerImpl> list){
		final Map<Color,Integer> map = new HashMap<>();
		list.forEach( p -> {
			Color color;
			if(p.getColor() == PlayerColor.BLUE) {
				color = Color.BLUE;
			}else if(p.getColor() == PlayerColor.PINK) {
				color = Color.PINK;
			}else if (p.getColor() == PlayerColor.RED) {
				color = Color.RED;
			}else {
				color = Color.YELLOW;
			}
			map.put(color,p.getBoardPosition());
		});
		return map;
	}

	public void changeViewGameState() {
		if(game.getStateGame().equals(StateGame.CHOOSE_STARTING_QUEUE)) {
			view.changeGameStateLabel("Initial PHASE");
			view.changeImageDice(game.choosePlayersQueue());
		}
		else if(game.getStateGame().equals(StateGame.CONTINUE)) {
			view.changeGameStateLabel("GAME");
			view.changeImageDice(game.rollCurrentPlayer());
			if(game.endGame()) {
				endGamefunction();
			}
			game.addMinigameResult(checkMinigames(game.playCurrentPlayer()));
			view.changeScoreboard(game.getScoreBoard().stream().map(PlayerImpl::getName).collect(Collectors.toList()));
			view.changeAllButtons(createMap(game.getScoreBoard()));
		}
		view.changePlayerLabel(game.nextPlayer().getName());
	}

	private void endGamefunction() {
		stopwatch.stop();
		final Duration duration = new DurationImpl(stopwatch.getTime());
		view.changeGameStateLabel("END_GAME - TIME: " + duration.getDuration());
		game.saveResultGame();
		//view.close();
	}
}