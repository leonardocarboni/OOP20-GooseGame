package controller.playerchooser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import controller.game.GameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.player.Player;
import model.player.PlayerColor;
import model.player.PlayerImpl;
import utility.file.FileUtilityImpl;
import view.ViewType;
import view.playerchooser.PlayersChooserView;

public class PlayerChooserController {

    private static final String FILE_NAME = "NamePlayers.json";

    private final PlayersChooserView view;
    private final List<Player> playersList = new ArrayList<>();
    private final FileUtilityImpl<String> s = new FileUtilityImpl<>(FILE_NAME);

    public PlayerChooserController() {
        view = new PlayersChooserView();
    }

    public void start() {
        view.createStage(ViewType.CHOOSE_PLAYER);
        view.setTextComboBox(loadNamesBox());
        view.addButtonListener(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                checkContrains();
            }
        });
        view.show();
    }

    /**
     * Function to check if users wrote unique names and if there are at least two
     * players. In this case this function create the controller of the Game
     */
    private void checkContrains() {
        final Map<String, String> playersNameNotNull = view.getPlayersInfo()
                                                           .entrySet()
                                                           .stream()
                                                           .filter(t -> !"".equals(t.getValue()))
                                                           .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        final int numPlayers = playersNameNotNull.size();
        final int numUniqueNames = (int) playersNameNotNull.values().stream().distinct().count();

        if (numPlayers < 2) {
            view.setErrorLabelText("YOU MUST ENTER AT LEAST 2 PLAYERS");
        } else if (numPlayers == numUniqueNames) {
            final List<String> playerNames = new ArrayList<>();
            for (final Entry<String, String> player : playersNameNotNull.entrySet()) {
                playersList.add(new PlayerImpl(player.getValue(), stringToEnum(player.getKey())));
                playerNames.add(player.getValue());
            }
            view.close();
            saveNamesBox(playerNames);
            final GameController c = new GameController();
            c.startGame(playersList);
        } else {
            view.setErrorLabelText("EVERY PLAYER MUST HAVE AN UNIQUE NAME");
        }
    }

    /**
     * Function to convert a string to an enumeration.
     * 
     * @param s color name passed as string
     * @return PlayerColor
     */
    private PlayerColor stringToEnum(final String s) {
        PlayerColor color;
        if ("pink".equals(s)) {
            color = PlayerColor.PINK;
        } else if ("red".equals(s)) {
            color = PlayerColor.RED;
        } else if ("green".equals(s)) {
            color = PlayerColor.GREEN;
        } else {
            color = PlayerColor.BLUE;
        }
        return color;
    }

    /**
     * Load names from the file and put them inside of ComboBox.
     * 
     * @return list with names loaded from file.
     */
    private List<String> loadNamesBox() {
        List<String> playerNames;
        try {
            playerNames = s.loadInformation(String.class);
        } catch (FileNotFoundException e) {
            playerNames = new ArrayList<>();
        }
        return playerNames;
    }

    /**
     * Save names wrote by users in the file.
     * 
     * @param namePlayers
     */
    private void saveNamesBox(final List<String> namePlayers) {
        s.saveInformation(namePlayers, true, String.class);
    }
}
