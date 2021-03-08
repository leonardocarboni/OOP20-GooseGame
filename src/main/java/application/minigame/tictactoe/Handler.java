package application.minigame.tictactoe;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

import javafx.scene.control.Button;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Handler {

    private List<Button> listButtonGrid;
    private List<Button> listBottomButton;
    protected static boolean isDark = false;

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
                if(event.getSource().equals(listButtonGrid.get(i)) && listButtonGrid.get(i).getText().equals("")){
                    listButtonGrid.get(i).setText("X");
                    winCondition.accept(TicTacToe.controller.checkWin());
                    TicTacToe.controller.drawO();
                }
                }
            }
    };
    
    final EventHandler<Event> released = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            for(int i = 0; i < 9 ; i++){
                if(event.getSource().equals(listButtonGrid.get(i)) && listButtonGrid.get(i).getText().equals("")){
                	if(!isDark){
                    } else{
                        listButtonGrid.get(i).setBackground(new Background(BackgroundLoader.gameButtonBackgroundBlack));
                    }
                }
            }
        }
    };

    final EventHandler<Event> changeDarkModeButton = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
                if(!isDark) {
                    isDark = true;
                    changeAllDark();
                    listBottomButton.get(0).setBackground(new Background(BackgroundLoader.darkButtonIconDark));
                }
                else if(isDark) {
                    isDark = false;
                    changeAllWhite();
                    listBottomButton.get(0).setBackground(new Background(BackgroundLoader.darkButtonIcon));
                }
        }
    };

    final EventHandler<Event> exit = new EventHandler<Event>() {
        @Override
        public void handle(Event event) {
            System.exit(1);
        }
    };

    final EventHandler<Event> stopMusic = new EventHandler<Event>() {
        boolean musicRunning = false;
        @Override
        public void handle(Event event) {
            if(!musicRunning){
                musicRunning = true;
                TicTacToe.getMusic().stopMusic();
            } else{
                musicRunning = false;
                TicTacToe.getMusic().startMusic();
            }
        }
    };


    private void changeAllDark(){
        for(int i = 0; i < 9; i++){
            listButtonGrid.get(i).setBackground(new Background(BackgroundLoader.gameButtonBackgroundBlack));
        }
    }

    private void changeAllWhite(){
        for(int i = 0; i < 9; i++){
            listButtonGrid.get(i).setBackground(new Background(BackgroundLoader.gameButtonBackground));
        }
    }



    public void setListButton(final List<Button> listButton){
        this.listButtonGrid = listButton;
    }

    public void setListButtonBottom(final List<Button> listBottomButton){
        this.listBottomButton = listBottomButton;
    }

}
