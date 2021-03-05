package application.minigame.tictactoe;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import java.util.List;
import javafx.scene.control.Button;

public class Handler {

    //lista di bottoni
    private List<Button> listButton;
    BackgroundImage bi;
    BackgroundImage b2;

    public Handler(BackgroundImage bi,BackgroundImage b2) {
        this.bi = bi;
        this.b2 = b2;
    }

    EventHandler<Event> eh = new EventHandler<Event>() {
        @Override
        public void handle(Event event) {
            for(int i = 0; i < 9 ; i++){
                if(event.getSource().equals(listButton.get(i))){
                    if(listButton.get(i).getText() == ""){
                        listButton.get(i).setText("X");
                        TicTacToe.controller.drawO();
                    }
                }
            }
        }
    };

    EventHandler<Event> click = new EventHandler<Event>() {
        @Override
        public void handle(Event event) {
            for(int i = 0; i < 9 ; i++){
                if(event.getSource().equals(listButton.get(i))){
                    if(listButton.get(i).getText() == ""){
                        DropShadow shadow = new DropShadow();

                        listButton.get(i).setBackground(new Background(bi));
                        listButton.get(i).setEffect(shadow);
                    }
                }
            }
        }
    };
    EventHandler<Event> released = new EventHandler<Event>() {
        @Override
        public void handle(Event event) {
            for(int i = 0; i < 9 ; i++){
                if(event.getSource().equals(listButton.get(i))){
                    if(listButton.get(i).getText() == ""){
                        listButton.get(i).setBackground(new Background(bi));
                    }
                }
            }
        }
    };

    public void setListButton(List<Button> listButton){
        this.listButton = listButton;
    }


}
