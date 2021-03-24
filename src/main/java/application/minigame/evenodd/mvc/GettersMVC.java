package application.minigame.evenodd.mvc;

import application.minigame.evenodd.mainGame.EvenOdd;

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

    public int getSize(){
        return EvenOdd.GRID_DIM;
    }

}
