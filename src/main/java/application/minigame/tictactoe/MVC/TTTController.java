package application.minigame.tictactoe.MVC;


import application.minigame.tictactoe.JFXItem.BackgroundLoader;
import application.minigame.tictactoe.EndgameThread;
import application.minigame.tictactoe.TicTacToe;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.Background;
import java.util.List;
import java.util.function.Consumer;
import javafx.scene.control.Button;

public class TTTController {

    private List<Button> listButtonGrid;
    private List<Button> listBottomButton;
    public static boolean isDark = false;
    private final static int NUMBER_OF_BUTTON = 9;

    private final Consumer<String> winCondition = winner -> {
        if(!winner.equals("")){
            EndgameThread my = new EndgameThread(winner);
            my.start();
        }
    };

    public final EventHandler<Event> eh = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            for(int i = 0; i < NUMBER_OF_BUTTON ; i++){
                if(event.getSource().equals(listButtonGrid.get(i)) && listButtonGrid.get(i).getText().equals("")){
                    listButtonGrid.get(i).setText("X");
                    winCondition.accept(TicTacToe.controller.model.checkWin());
                    TicTacToe.controller.drawO();
                }
                }
            }
    };

    public final EventHandler<Event> released = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            for(int i = 0; i < NUMBER_OF_BUTTON ; i++){
                if(event.getSource().equals(listButtonGrid.get(i)) && listButtonGrid.get(i).getText().equals("")){
                	if(!isDark){
                    } else{
                        listButtonGrid.get(i).setBackground(new Background(BackgroundLoader.gameButtonBackgroundBlack));
                    }
                }
            }
        }
    };

    public final EventHandler<Event> changeDarkModeButton = new EventHandler<Event>() {
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

    public final EventHandler<Event> exit = new EventHandler<Event>() {
        @Override
        public void handle(final Event event) {
            System.exit(1);
        }
    };



    private void changeAllDark(){
        for(int i = 0; i < NUMBER_OF_BUTTON; i++){
            listButtonGrid.get(i).setBackground(new Background(BackgroundLoader.gameButtonBackgroundBlack));
        }
    }

    private void changeAllWhite(){
        for(int i = 0; i < NUMBER_OF_BUTTON; i++){
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
