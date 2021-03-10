package application.minigame.tictactoe.mvc;


import application.minigame.tictactoe.fxItem.BackgroundLoader;
import application.minigame.tictactoe.mainGame.EndgameThread;
import application.minigame.tictactoe.mainGame.TicTacToe;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.Background;
import java.util.List;
import java.util.function.Consumer;
import javafx.scene.control.Button;

public class TTTController {

    private List<Button> listButtonGrid;
    private List<Button> listBottomButton;


    public static final Consumer<String> winCondition = winner -> {
        if(!winner.equals("")){
            EndgameThread my = new EndgameThread(winner);
            my.start();
        }
    };

    public final EventHandler<Event> eh = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            TicTacToe.view.drawX(event, winCondition);
            }
    };

    public final EventHandler<Event> released = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            TicTacToe.view.releaseButton(event);
        }
    };

    public final EventHandler<Event> changeDarkModeButton = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            TicTacToe.view.changeColor();
        }
    };

    public final EventHandler<Event> exit = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            System.exit(1);
        }
    };


    public void setListButton(final List<Button> listButton){
        this.listButtonGrid = listButton;
    }

    public void setListButtonBottom(final List<Button> listBottomButton){
        this.listBottomButton = listBottomButton;
    }

}
