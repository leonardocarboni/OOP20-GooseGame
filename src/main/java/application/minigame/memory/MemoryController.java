package application.minigame.memory;

import controller.minigame.MinigameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MemoryController implements MinigameController {

    private final MemoryView view;
    private final SecretCode secretCode;

    public MemoryController() {
        view = new MemoryView();
        secretCode = new SecretCodeImpl();
        view.show();
    }

    @Override
    public int getResult() {
        return 0;
    }


    /**
     * An inner class for the event catching in the minigame view.
     */
    public class SecretCodeCheckHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
        }
    }


}
