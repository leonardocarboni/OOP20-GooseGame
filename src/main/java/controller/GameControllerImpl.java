package controller;

import java.util.List;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.GameImpl;
import model.box.Box;
import model.player.PlayerImpl;
import view.GamesViewType;
import view.MainGameView;
import view.MinigameStarter;

public class GameControllerImpl {

	private final MainGameView view;
	private final GameImpl game;
	
	public GameControllerImpl(final List<PlayerImpl> playersList) {
		view = new MainGameView();
		game = new GameImpl();
		view.show();
		game.start(playersList);
		view.addButtonListener(new test());
	}

	public void checkMinigames(final Box b) {
		final Stage s = new Stage();
		s.initModality(Modality.APPLICATION_MODAL);
	    s.setMinHeight(600);
	    s.setMinWidth(800);
	    
	    MinigameStarter minigameScene = null;
		switch(b) {
			case BONUS:
				minigameScene = new MinigameStarter(GamesViewType.GAME);
				break;
			case TICTACTOE:
				minigameScene = new MinigameStarter(GamesViewType.TICTACTOE);
				break;
			case EVEN_OR_ODD:
				minigameScene = new MinigameStarter(GamesViewType.EVEN_OR_ODD);
				break;
			case ROCK_PAPER_SCISSORS:
				minigameScene = new MinigameStarter(GamesViewType.ROCK_PAPER_SCISSORS);
				break;
			case CABLE_CONNECT:
				minigameScene = new MinigameStarter(GamesViewType.CABLE_CONNECT);
				break;
			default:
				break;
		}
		if(minigameScene != null) {
			try {
				//minigameScene.start(s);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//minigameScene.getResult();
	}

    public class test implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
        	game.playCurrentPlayer();
        	view.changeImageDice(1);
        	view.changeScoreboard(game.getScoreBoard().stream().map(PlayerImpl::getName).collect(Collectors.toList()));
        	view.changePlayerLabel(game.nextPlayer().getName());
        }
    }
}