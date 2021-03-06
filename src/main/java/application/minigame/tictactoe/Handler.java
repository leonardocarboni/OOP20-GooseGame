package application.minigame.tictactoe;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;

import java.util.List;
import java.util.function.Consumer;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Handler {

    private List<Button> listButton;
    ;

    Consumer<String> winCondition = x -> {
        if(x != ""){
            MyThread my = new MyThread();
            my.start();
        }
    };



    EventHandler<Event> eh = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            for(int i = 0; i < 9 ; i++){
                if(event.getSource().equals(listButton.get(i)) && listButton.get(i).getText() == ""){
                    listButton.get(i).setText("X");
                    winCondition.accept(TicTacToe.controller.checkWin());
                    TicTacToe.controller.drawO();
                }
                }
            }
    };

    EventHandler<Event> click = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            for(int i = 0; i < 9 ; i++){
                if(event.getSource().equals(listButton.get(i)) && listButton.get(i).getText() == ""){
                	final DropShadow shadow = new DropShadow();
                    listButton.get(i).setBackground(new Background(BackgroundLoader.gameButtonBackground));
                    listButton.get(i).setEffect(shadow);
                }
            }
        }
    };
    
    EventHandler<Event> released = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            for(int i = 0; i < 9 ; i++){
                if(event.getSource().equals(listButton.get(i)) && listButton.get(i).getText() == ""){
                	listButton.get(i).setBackground(new Background(BackgroundLoader.gameButtonBackground));
                }
            }
        }
    };

    public void setListButton(final List<Button> listButton){
        this.listButton = listButton;
    }

}
