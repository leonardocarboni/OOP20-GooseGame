package application.minigame.tictactoe.mvc;

import javafx.event.Event;
import javafx.event.EventHandler;

public class TTTControllerImpl {

    private final GettersMVC getters = new GettersMVC();

    /**
     * This is the HANDLER of the button in the grid.
     * This HANDLER call the drawX method in the View.
     */
    private final EventHandler<Event> click = event -> getters.getView().drawX(event, TTTViewImpl.MODEL.getWinCondition());
    /**
     * This HANDLER change the color of the button. It goes on the change icon button.
     */
    private final EventHandler<Event> changeDarkModeButton = event -> getters.getView().changeColor();

    public EventHandler<Event> getClick() {
        return click;
    }

    public EventHandler<Event> getChangeDarkModeButton() {
        return changeDarkModeButton;
    }

}
