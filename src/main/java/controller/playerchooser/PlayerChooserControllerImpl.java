package controller.playerchooser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import controller.game.GameControllerImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.player.PlayerImpl;
import view.PlayersChooserView;

public class PlayerChooserControllerImpl {

	final private PlayersChooserView view;
    final private List<PlayerImpl> playersList = new ArrayList<>();
    
    public PlayerChooserControllerImpl() {
    	view = new PlayersChooserView();
    	view.addButtonListener(new Test());
	}
    
    private void checkContrains () {
    	final List<String> playersName = view.getPlayersNames()
    										.stream()
											.filter(t -> !"".equals(t))
											.collect(Collectors.toList());
    	final int numEnabled = playersName.size();
        //number of unique names (only of the enabled player)
        final int numNames = (int) playersName.stream()
        									.distinct()
        									.count();
        if (numEnabled < 2){
        	view.setErrorLabelText("YOU MUST ENTER AT LEAST 2 PLAYERS");
        } else if (numEnabled == numNames) {
        	playersName.forEach(t -> playersList.add(new PlayerImpl(t)));
            final GameControllerImpl c = new GameControllerImpl(playersList);
            view.close();
        }
        else{
        	view.setErrorLabelText("EVERY PLAYER MUST HAVE AN UNIQUE NAME");
        }
    	
    }

    public class Test implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
        	checkContrains();
        }
    }
}
