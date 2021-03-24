package application.minigame.evenodd.mvc;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.List;

public class TTTController {

    private List<Button> listButtonGrid;
    private List<Button> listBottomButton;
    private GettersMVC getters = new GettersMVC();



    public final EventHandler<Event> released = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            getters.getView().releaseButton(event);
        }
    };

    public final EventHandler<Event> changeDarkModeButton = new EventHandler<Event>() {


        @Override
        public void handle(Event event) {

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
