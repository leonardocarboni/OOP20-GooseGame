package application.minigame.evenodd.mvc;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.io.FileNotFoundException;
import java.util.List;

public class EOController{

    /**
     * Questa variabile mi permette di richiamare le funzionalità del model e della view.
    **/
    private GettersMVC getters = new GettersMVC();

    /**
     * In caso di click del bottone viene attivato questo handler.
     * Esso valuta il testo del bottone, e in base a quest'ultimo chiamo la model.
     *
     * Se pari chiamo la checkWin con 2.
     * Se dispari chiamo la checkWin con 1.
     * Disattivo i bottoni nella view.
     */
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
