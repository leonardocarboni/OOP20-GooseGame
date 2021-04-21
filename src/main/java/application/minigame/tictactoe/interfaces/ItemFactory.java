package application.minigame.tictactoe.interfaces;

import application.minigame.tictactoe.mvc.TTTControllerImpl;
import javafx.scene.control.Button;

public interface ItemFactory {

    Button gridButton(TTTControllerImpl handler);

    /* metodo che restituisce il bottone presente alla fine del gioco */
    Button endGameButton(String winner);

    Button gameDarkModeIcon(TTTControllerImpl handler);
}
