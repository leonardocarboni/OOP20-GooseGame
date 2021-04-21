package application.minigame.evenodd.mainGame;

import application.minigame.evenodd.mvc.EOControllerImpl;
import application.minigame.evenodd.mvc.EOModelImpl;
import application.minigame.evenodd.mvc.EOViewImpl;

/**
 * This class returns the view, controller, MODEL, and stackPane of the
 * application. Make static calls to the EvenOdd and EOView classes to store the
 * view, MODEL, controller and stackPane.
 *
 */

public class GettersMVC {

    private EOViewImpl view;
    private EOControllerImpl controller;
    private EOModelImpl model;

    public EOViewImpl getView() {
        this.view = EvenOdd.EO_VIEW;
        return this.view;
    }

    public EOControllerImpl getController() {
        this.controller = EOViewImpl.HANDLER;
        return this.controller;
    }

    public EOModelImpl getModel() {
        this.model = EOViewImpl.MODEL;
        return this.model;
    }

}
