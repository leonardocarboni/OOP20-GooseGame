package controller.game;

import java.util.List;
import java.util.stream.Collectors;

import application.minigame.cableconnect.CableConnectController;
import application.minigame.phrasecatch.PhraseCatchController;
import controller.minigame.MinigameController;
import model.box.Box;
import model.duration.Duration;
import model.duration.DurationImpl;
import model.game.GameImpl;
import model.player.PlayerImpl;
import org.apache.commons.lang3.time.StopWatch;
import view.GameView;

public class GameControllerImpl {

	private final GameView view;
	private final GameImpl game;

	public GameControllerImpl(final List<PlayerImpl> playersList) {
		view = new GameView();
		game = new GameImpl();

		StopWatch stopwatch = new StopWatch();
		stopwatch.start();

		game.start(playersList);
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
		});

		view.show();
		stopwatch.stop();
		Duration duration = new DurationImpl(stopwatch.getTime());
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
}