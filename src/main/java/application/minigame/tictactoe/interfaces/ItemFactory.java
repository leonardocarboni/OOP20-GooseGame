package application.minigame.tictactoe.interfaces;

import application.minigame.tictactoe.mvc.TTTControllerImpl;
import javafx.scene.control.Button;

public interface ItemFactory {

    Button gridButton(final TTTControllerImpl handler);

    /* metodo che restituisce il bottone presente alla fine del gioco */
    Button endGameButton(final String winner);

    Button gameDarkModeIcon(final TTTControllerImpl handler);
}
