package controller.playerchooser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import controller.game.GameControllerImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.player.PlayerColor;
import model.player.PlayerImpl;
import view.PlayersChooserView;

public class PlayerChooserControllerImpl {

	final private PlayersChooserView view;
    final private List<PlayerImpl> playersList = new ArrayList<>();

    public PlayerChooserControllerImpl() {
    	view = new PlayersChooserView();
    	view.addButtonListener(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent event) {
				checkContrains();
			}
		});
	}
    
    public void checkContrains () {
    	
    	final Map<String,String> playersNameNotNull = view.getPlayersInfo()
    										.entrySet()
    										.stream()
											.filter(t -> !"".equals(t.getValue()))
											.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    	System.out.println(playersNameNotNull);
    	final int numPlayers = playersNameNotNull.size();
        final int numUniqueNames = (int) playersNameNotNull
        									.values()
        									.stream()
        									.distinct()
        									.count();
        if (numPlayers < 2){
        	view.setErrorLabelText("YOU MUST ENTER AT LEAST 2 PLAYERS");
        } else if (numPlayers == numUniqueNames) {
        	for (final Entry<String, String> player : playersNameNotNull.entrySet()) {
				playersList.add(new PlayerImpl(player.getValue(),stringToEnum(player.getKey())));
			}
            view.close();
            final GameControllerImpl c = new GameControllerImpl(playersList);
        }
        else{
        	view.setErrorLabelText("EVERY PLAYER MUST HAVE AN UNIQUE NAME");
        }
    	
    }

    public PlayerColor stringToEnum(final String s) {
    	PlayerColor color;
    	if("pink".equals(s)) {
    		color = PlayerColor.PINK;
    	}else if ("red".equals(s)) {
    		color = PlayerColor.RED;
    	}else if ("yellow".equals(s)) {
    		color = PlayerColor.YELLOW;
    	}else { 
    		color = PlayerColor.BLUE;
    	}
    	return color;
    }
}
