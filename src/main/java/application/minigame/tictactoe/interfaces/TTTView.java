package application.minigame.tictactoe.interfaces;

import java.util.function.Consumer;

import javafx.event.Event;
import javafx.scene.layout.GridPane;

public interface TTTView {

    /**
     * The computer sees where it can draw an "O" randomly.
     */
    void drawO();

    /**
     * Draw an X, creating a random number and checking that index in the list of
     * buttons, if that value is "" then draw an X, otherwise do it again the
     * procedure.
     *
     * @param evt ,to get the clicked button.
     * @param winCondition , check if I won.
     */
    void drawX(Event evt, Consumer<String> winCondition);

    /**
     * I insert the buttons created in the constructor in the panel.
     *
     * @return Grid with bottoni
     */
    GridPane createButton();

    /**
     * In case darkMode is selected I have to put a specific color.
     *
     * @param event
     */
    void releaseButton(Event event);

    /**
     * If I select the darkMode I change the color of all the buttons.
     */
    void changeColor();
}
