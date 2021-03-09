package application.minigame.tictactoe.JFXItem;

import application.minigame.tictactoe.MVC.TTTController;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.Optional;

public class ButtonDropper extends Button {


    //metodo che consente di creare il bottone presente nella griglia
    //prende come valore un handler per un bottone
    public Button gridButton(TTTController handler){

        final Button btn = new Button();
        final DropShadow shadow = new DropShadow();
        btn.setEffect(shadow);
        btn.setBackground(new Background(BackgroundLoader.gameButtonBackground));
        btn.setPrefSize(200,200);
        btn.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC,80));
        btn.addEventFilter(MouseEvent.MOUSE_CLICKED, handler.eh);
        //btn.addEventFilter(MouseEvent.MOUSE_PRESSED, handler.click);
        btn.addEventFilter(MouseEvent.MOUSE_RELEASED, handler.released);

        return btn;
    }

    /* metodo che restituisce il bottone presente alla fine del gioco */
    public Button endGameButton(Optional<TTTController> handler, String winner){
        Button btn = new Button();
        btn.setBackground(new Background(BackgroundLoader.endGameButton));
        btn.setText("The winner is: " + winner);
        btn.setTranslateY(-130);

        btn.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC,40));
        return btn;
    }

    public Button exitButton(Optional<TTTController> handler, String winner){
        Button btn = new Button();
        btn.addEventFilter(MouseEvent.MOUSE_CLICKED, handler.get().exit);
        btn.setBackground(new Background(BackgroundLoader.endGameButton));
        btn.setText("Exit");
        btn.setTranslateY(30);

        btn.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC,40));
        return btn;
    }

    public Button gameDarkModeIcon(Optional<TTTController> handler, String winner){
        Button btn = new Button();
        btn.setMinSize(50,40);
        btn.setBackground(new Background(BackgroundLoader.darkButtonIcon));
        btn.addEventFilter(MouseEvent.MOUSE_CLICKED, handler.get().changeDarkModeButton);
        return btn;
    }

    public Button gameDarkModeIconText(Optional<TTTController> handler, String winner){
        Button btn = new Button();
        btn.setMinSize(50,40);
        btn.setText("<- Change mode");
        btn.setStyle(" -fx-background-color: transparent; ");
        btn.setTranslateX(50);
        return btn;
    }


    public Button pauseButtonIcon(Optional<TTTController> handler, String winner){
        Button btn = new Button();
        btn.setMinSize(50,40);
        btn.setBackground(new Background(BackgroundLoader.pauseMusic));
        return btn;
    }

    public Button pauseButtonIconText(Optional<TTTController> handler, String winner){
        Button btn = new Button();
        btn.setMinSize(50,40);
        btn.setText("<- Pause music");
        btn.setStyle(" -fx-background-color: transparent; ");
        btn.setTranslateX(50);
        return btn;
    }


}
