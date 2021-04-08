package controller.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import application.minigame.cableconnect.CableConnectController;
import application.minigame.cableconnect.Colors;
import application.minigame.phrasecatch.PhraseCatchController;
import controller.minigame.MinigameController;
import javafx.scene.paint.Color;
import model.box.Box;
import model.duration.Duration;
import model.duration.DurationImpl;
import model.game.GameImpl;
import model.player.PlayerColor;
import model.player.PlayerImpl;
import org.apache.commons.lang3.time.StopWatch;
import view.GameView;

public class GameControllerImpl {

	private final GameView view;
	private final GameImpl game;

	public GameControllerImpl(final List<PlayerImpl> playersList) {
		view = new GameView();
		game = new GameImpl();

		final StopWatch stopwatch = new StopWatch();
		stopwatch.start();

		game.start(playersList);
		//aggiungere createMap
		view.changePlayerLabel(game.nextPlayer().getName());
		view.addButtonListener(event -> {
			view.changeImageDice(game.rollCurrentPlayer());
			if(game.end()) {
				game.saveResultGame();
				view.close();
			}
			game.addMinigameResult(checkMinigames(game.playCurrentPlayer()));
			view.changeScoreboard(game.getScoreBoard().stream().map(PlayerImpl::getName).collect(Collectors.toList()));
			view.changePlayerLabel(game.nextPlayer().getName());
			System.out.println(game.getScoreBoard());
			view.changeAllButtons(createMap(game.getScoreBoard()));
		});

		view.show();
		stopwatch.stop();
		final Duration duration = new DurationImpl(stopwatch.getTime());
		//System.out.println("DURATION: " + duration.getDuration());

	}

	public int checkMinigames(final Box b) {
		System.out.println(b);
		MinigameController minigameScene = null;
		switch(b) {
			case BONUS:
				break;
			case TICTACTOE:
				break;
			case EVEN_OR_ODD:
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
}