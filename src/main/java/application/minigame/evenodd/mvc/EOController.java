package application.minigame.evenodd.mvc;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.io.FileNotFoundException;
import java.util.List;

public class EOController{

    private GettersMVC getters = new GettersMVC();

    public final EventHandler<Event> click = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            getters.getView().startAnimation();
            if(((Button)event.getSource()).getText() == "PARI"){
                getters.getModel().checkWin(2);
            } else{
                getters.getModel().checkWin(1);
            }
            getters.getView().listButton.stream().forEach(i -> i.setDisable(true));
        }
    };



    public final EventHandler<Event> exit = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            System.exit(1);
        }
    };


}
