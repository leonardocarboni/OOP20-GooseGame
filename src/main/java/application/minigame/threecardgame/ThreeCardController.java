package application.minigame.threecardgame;

import controller.minigame.MinigameController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ThreeCardController implements MinigameController {

    private ThreeCardView view;

    public ThreeCardController() {
        view = new ThreeCardView();

        view.show();
    }

    @Override
    public int getResult() {
        return 0;
    }

    /**
     * An inner class for the event catching in the minigame view
     */
    public class SxClickHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

        }
    }

    /**
     * An inner class for the event catching in the minigame view
     */
    public class CenterClickHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

        }
    }

    /**
     * An inner class for the event catching in the minigame view
     */
    public class DxClickHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

        }
    }


}
