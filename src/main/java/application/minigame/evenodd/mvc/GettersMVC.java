package application.minigame.evenodd.mvc;

import application.minigame.evenodd.mainGame.EvenOdd;

public class GettersMVC {

    private TTTView view;
    private TTTController controller;
    private TTTModel model;

    public TTTView getView() {
        this.view = EvenOdd.view;
        return this.view;
    }

    public TTTController getController() {
        this.controller = TTTView.handler;
        return this.controller;
    }

    public TTTModel getModel() {
        this.model = TTTView.model;
        return this.model;
    }

    public int getSize(){
        return EvenOdd.GRID_DIM;
    }

}
