package application.minigame.tictactoe.mvc;

import javafx.event.Event;
import javafx.event.EventHandler;

public class TTTController {

    private GettersMVC getters = new GettersMVC();

    public final EventHandler<Event> eh = event -> getters.getView().drawX(event, TTTView.model.winCondition);

    public final EventHandler<Event> released = event -> getters.getView().releaseButton(event);

    public final EventHandler<Event> changeDarkModeButton = event -> getters.getView().changeColor();

}
