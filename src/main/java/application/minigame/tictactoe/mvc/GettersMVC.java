package application.minigame.tictactoe.mvc;

import application.minigame.tictactoe.mainGame.TicTacToe;

/**
 * Method that return view, model and controller.
 */
public class GettersMVC {

    private TTTViewImpl view;
    private TTTControllerImpl controller;
    private TTTModelImpl model;

    public TTTViewImpl getView() {
        this.view = TicTacToe.view;
        return this.view;
    }

    public TTTControllerImpl getController() {
        this.controller = TTTViewImpl.handler;
        return this.controller;
    }

    public TTTModelImpl getModel() {
        this.model = TTTViewImpl.model;
        return this.model;
    }

    public int getSize() {
        return TicTacToe.GRID_DIM;
    }

}
