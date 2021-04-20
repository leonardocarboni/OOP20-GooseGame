package application.minigame.tictactoe.mvc;

import javafx.event.Event;
import javafx.event.EventHandler;

public class TTTControllerImpl {

    private GettersMVC getters = new GettersMVC();

    public final EventHandler<Event> eh = event -> getters.getView().drawX(event, TTTViewImpl.model.winCondition);

    public final EventHandler<Event> released = event -> getters.getView().releaseButton(event);

    public final EventHandler<Event> changeDarkModeButton = event -> getters.getView().changeColor();

}
