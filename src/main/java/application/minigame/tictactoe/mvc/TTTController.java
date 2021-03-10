package application.minigame.tictactoe.mvc;

import application.minigame.tictactoe.mainGame.TicTacToe;
import javafx.event.Event;
import javafx.event.EventHandler;
import java.util.List;
import javafx.scene.control.Button;

public class TTTController {

    private List<Button> listButtonGrid;
    private List<Button> listBottomButton;
    private GettersMVC getters = new GettersMVC();

    public final EventHandler<Event> eh = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) { getters.getView().drawX(event, TTTView.model.winCondition); }
    };

    public final EventHandler<Event> released = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            getters.getView().releaseButton(event);
        }
    };

    public final EventHandler<Event> changeDarkModeButton = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            getters.getView().changeColor();
        }
    };

    public final EventHandler<Event> exit = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            System.exit(1);
        }
    };

    public void setListButton(final List<Button> listButton){
        this.listButtonGrid = listButton;
    }

    public void setListButtonBottom(final List<Button> listBottomButton){
        this.listBottomButton = listBottomButton;
    }

}
