package application.minigame.evenodd.mvc;

import application.minigame.evenodd.mainGame.EvenOdd;
import application.minigame.evenodd.mainGame.GettersMVC;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class EOController {

    /**
     * Questa variabile mi permette di richiamare le funzionalità del model e della
     * view.
     **/
    private final GettersMVC getters = new GettersMVC();

    /**
     * In caso di click del bottone viene attivato questo handler. Esso valuta il
     * testo del bottone, e in base a quest'ultimo chiamo la model.
     *
     * Se pari chiamo la checkWin con 2. Se dispari chiamo la checkWin con 1.
     * Disattivo i bottoni nella view.
     */
    public final EventHandler<Event> click = event -> {
        getters.getView().startAnimation();
        if (((Button) event.getSource()).getText() == "PARI") {
            getters.getModel().checkWin(2);
        } else {
            getters.getModel().checkWin(1);
        }
        getters.getView().listButton.stream().forEach(i -> i.setDisable(true));
        getters.getView().listButton.get(2).setDisable(false);
    };

    public final EventHandler<Event> exit = event -> {
        EvenOdd.primaryStage.close();
    };

}
