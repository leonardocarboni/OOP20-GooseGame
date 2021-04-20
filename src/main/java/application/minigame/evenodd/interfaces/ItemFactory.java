package application.minigame.evenodd.interfaces;

import application.minigame.evenodd.mvc.EOControllerImpl;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public interface ItemFactory {

    /**
     * Create the even button, you can click it and choose Even.
     * @param handler
     * @return the even button
     */
    Button evenButton(EOControllerImpl handler);

    /**
     * Create the odd button, you can choose odd by click it.
     * @param handler
     * @return the odd butto
     */
    Button oddButton(EOControllerImpl handler);

    /**
     * The exit button for close the game
     * @param handler
     * @return the exit button
     */
    Button exitButton(EOControllerImpl handler);

    /**
     * This create a text.
     * @param string
     * @param resultValue
     * @param positionY
     * @return the text
     */
    Text createText(String string, String resultValue, int positionY);
}
