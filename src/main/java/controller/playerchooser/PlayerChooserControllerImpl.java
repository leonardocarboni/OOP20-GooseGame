package controller.playerchooser;

import java.io.FileNotFoundException;
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
import utility.file.FileUtility;
import utility.file.FileUtilityImpl;
import view.ViewType;
import view.playerchooser.PlayersChooserViewImpl;

public class PlayerChooserControllerImpl implements PlayerChooser{

	final private static String FILE_NAME = "NamePlayers.json";
	
	final private PlayersChooserViewImpl view;
    final private List<PlayerImpl> playersList = new ArrayList<>();
    final private FileUtility<String> s = new FileUtilityImpl<>(FILE_NAME);

    public PlayerChooserControllerImpl() {
    	view = new PlayersChooserViewImpl();
    	view.createStage(ViewType.CHOOSE_PLAYER);
    	view.show();
    	view.addButtonListener(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent event) {
				checkContrains();
			}
		});
	}

    /*
     * Function to check if users wrote unique names and if there are at least two players
     * In this case this function create the controller of the Game
     */
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

    /*
     * Function to convert a string to an enum 
     * @param s color name passed as string
     * @return PlayerColor 
     */
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

    /*
     * Load names from the file and put them inside of ComboBox
     */
    public void loadNamesBox() {
    	try {
			final List<String> playerNames = s.loadInformation();
			//set it to Box
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }

    /*
     * Save names wrote by users in the file
     */
    public void saveNamesBox(final List<String> namePlayers) {
    	s.saveInformation(namePlayers);
    }
}
