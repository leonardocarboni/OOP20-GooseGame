package application.minigame.evenodd.mainGame;

import application.minigame.evenodd.mvc.EOController;
import application.minigame.evenodd.mvc.EOModel;
import application.minigame.evenodd.mvc.EOView;
import javafx.scene.layout.StackPane;

/**
 * Questa classe ritorna la view, controller, model e stackPane dell'applicazione.
 * Esegue chiamate statiche alle classi EvenOdd e EOView per memorizzare la
 * view, model, controller e stackPane.
 *
 */

public class GettersMVC {

    private EOView view;
    private EOController controller;
    private EOModel model;

    public EOView getView() {
        this.view = EvenOdd.view;
        return this.view;
    }

    public EOController getController() {
        this.controller = EOView.handler;
        return this.controller;
    }

    public EOModel getModel() {
        this.model = EOView.model;
        return this.model;
    }

    public StackPane getPane(){
        return EvenOdd.pane;
    }


}
