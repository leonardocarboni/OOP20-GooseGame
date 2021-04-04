package controller.game;

import java.util.List;
import java.util.stream.Collectors;

import application.minigame.cableconnect.CableConnectController;
import application.minigame.phrasecatch.PhraseCatchController;
import controller.minigame.MinigameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.box.Box;
import model.game.GameImpl;
import model.player.PlayerImpl;
import view.GameView;

public class GameControllerImpl {

	private final GameView view;
	private final GameImpl game;
	
	public GameControllerImpl(final List<PlayerImpl> playersList) {
		view = new GameView();
		game = new GameImpl();
		view.show();
		game.start(playersList);
		view.changePlayerLabel(game.nextPlayer().getName());
		view.addButtonListener(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent event) {
				view.changeImageDice(game.rollCurrentPlayer());
	        	if(game.end()) {
	        		game.saveResultGame();
	        		view.close();
	        	}
	        	game.addMinigameResult(checkMinigames(game.playCurrentPlayer()));
	        	view.changeScoreboard(game.getScoreBoard().stream().map(PlayerImpl::getName).collect(Collectors.toList()));
	        	view.changePlayerLabel(game.nextPlayer().getName());
	        	System.out.println(game.getScoreBoard());
			}
		});
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