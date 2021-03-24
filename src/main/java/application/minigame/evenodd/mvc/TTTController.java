package application.minigame.evenodd.mvc;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.List;

public class TTTController {

    private GettersMVC getters = new GettersMVC();



    public final EventHandler<Event> released = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {

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


}
