package application.minigame.tictactoe;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.Background;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.layout.BackgroundImage;

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
                        listButton.get(i).setBackground(new Background(b2));
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
