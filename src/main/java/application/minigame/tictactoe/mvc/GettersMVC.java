package application.minigame.tictactoe.mvc;

import application.minigame.tictactoe.mainGame.TicTacToe;

public class GettersMVC {

    private TTTView view;
    private TTTController controller;
    private TTTModel model;

    public TTTView getView() {
        this.view = TicTacToe.view;
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

}
