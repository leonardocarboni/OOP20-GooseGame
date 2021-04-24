package application.minigame.tictactoe.mvc;

import application.minigame.tictactoe.mainGame.TicTacToe;

/**
 * Method that return view, MODEL and controller.
 */
public class GettersMVC {

    private TTTViewImpl view;
    private TTTControllerImpl controller;
    private TTTModelImpl model;

    public TTTViewImpl getView() {
        this.view = TicTacToe.getView();
        return this.view;
    }

    public TTTControllerImpl getController() {
        this.controller = TTTViewImpl.HANDLER;
        return this.controller;
    }

    public TTTModelImpl getModel() {
        this.model = TTTViewImpl.MODEL;
        return this.model;
    }

    public int getSize() {
        return TicTacToe.getGridDim();
    }

}
