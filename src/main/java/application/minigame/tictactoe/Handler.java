package application.minigame.tictactoe;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;

import java.util.List;
import java.util.function.Consumer;

import javafx.scene.control.Button;

public class Handler {

    private List<Button> listButton;

    private final Consumer<String> winCondition = winner -> {
        if(!winner.equals("")){
            EndgameThread my = new EndgameThread(winner);
            my.start();
        }
    };

    final EventHandler<Event> eh = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            for(int i = 0; i < 9 ; i++){
                if(event.getSource().equals(listButton.get(i)) && listButton.get(i).getText().equals("")){
                    listButton.get(i).setText("X");
                    winCondition.accept(TicTacToe.controller.checkWin());
                    TicTacToe.controller.drawO();
                }
                }
            }
    };

    final EventHandler<Event> click = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            for(int i = 0; i < 9 ; i++){
                if(event.getSource().equals(listButton.get(i)) && listButton.get(i).getText().equals("")){
                	final DropShadow shadow = new DropShadow();
                    listButton.get(i).setBackground(new Background(BackgroundLoader.gameButtonBackground));
                    listButton.get(i).setEffect(shadow);
                }
            }
        }
    };
    
    final EventHandler<Event> released = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            for(int i = 0; i < 9 ; i++){
                if(event.getSource().equals(listButton.get(i)) && listButton.get(i).getText().equals("")){
                	listButton.get(i).setBackground(new Background(BackgroundLoader.gameButtonBackground));
                }
            }
        }
    };

    public void setListButton(final List<Button> listButton){
        this.listButton = listButton;
    }

}
