package application.minigame.tictactoe;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;

import java.util.List;
import javafx.scene.control.Button;

public class Handler {

    private List<Button> listButton;
    private final BackgroundImage bi;
    private final BackgroundImage b2;
    
    public Handler(final BackgroundImage bi,final BackgroundImage b2) {
        this.bi = bi;
        this.b2 = b2;
    }

    EventHandler<Event> eh = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            for(int i = 0; i < 9 ; i++){
                if(event.getSource().equals(listButton.get(i)) && listButton.get(i).getText() == ""){
                        listButton.get(i).setText("X");
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
                    listButton.get(i).setBackground(new Background(bi));
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
                	listButton.get(i).setBackground(new Background(bi));
                }
            }
        }
    };

    public void setListButton(final List<Button> listButton){
        this.listButton = listButton;
    }


}
