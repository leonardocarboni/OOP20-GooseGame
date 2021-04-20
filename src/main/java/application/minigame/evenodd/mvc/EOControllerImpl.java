package application.minigame.evenodd.mvc;

import application.minigame.evenodd.mainGame.EvenOdd;
import application.minigame.evenodd.mainGame.GettersMVC;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class EOControllerImpl {

    /**
     * This variable allows me to call up the functionality of the model and the
     * view.
     **/
    private final GettersMVC getters = new GettersMVC();

    /**
     * If the button is clicked, this handler is activated. It evaluates the
     * text of the button, and based on the latter I call the model.
     *
     * If even I call checkWin with 2. If odd I call checkWin with 1.
     * I disable the buttons in the view.
     */
    public final EventHandler<Event> click = event -> {
        if (((Button) event.getSource()).getText() == "PARI") {
            getters.getModel().checkWin(2);
        } else {
            getters.getModel().checkWin(1);
        }


        getters.getView().listButton.get(0).setDisable(true);
        getters.getView().listButton.get(1).setDisable(true);
        getters.getView().listButton.get(2).setDisable(false);
    };

    /**
     * This handler close the application.
     */
    public final EventHandler<Event> exit = event -> {
        EvenOdd.primaryStage.close();
    };

}
