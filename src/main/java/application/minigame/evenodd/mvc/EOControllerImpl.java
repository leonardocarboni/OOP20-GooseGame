package application.minigame.evenodd.mvc;

import application.minigame.evenodd.mainGame.EvenOdd;
import application.minigame.evenodd.mainGame.GettersMVC;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class EOControllerImpl {

    /**
     * This variable allows me to call up the functionality of the MODEL and the
     * view.
     **/
    private final GettersMVC getters = new GettersMVC();

    /**
     * If the button is clicked, this HANDLER is activated. It evaluates the text of
     * the button, and based on the latter I call the MODEL.
     *
     * If even I call checkWin with 2. If odd I call checkWin with 1. I disable the
     * buttons in the view.
     */
    private final EventHandler<Event> click = event -> {
        if (((Button) event.getSource()).getText() == "PARI") {
            getters.getModel().checkWin(2);
        } else {
            getters.getModel().checkWin(1);
        }

        getters.getView().getListButton().get(0).setDisable(true);
        getters.getView().getListButton().get(1).setDisable(true);
        getters.getView().getListButton().get(2).setDisable(false);
    };

    /**
     * This HANDLER close the application.
     */
    private final EventHandler<Event> exit = event -> {
        EvenOdd.PRIMARY_STAGE.close();
    };

    public EventHandler<Event> getClick() {
        return click;
    }

    public EventHandler<Event> getExit() {
        return exit;
    }

}
