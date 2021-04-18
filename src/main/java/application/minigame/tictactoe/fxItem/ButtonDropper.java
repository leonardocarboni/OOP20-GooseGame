package application.minigame.tictactoe.fxItem;

import application.minigame.tictactoe.mvc.GettersMVC;
import application.minigame.tictactoe.mvc.TTTController;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class ButtonDropper extends Button {

    // metodo che consente di creare il bottone presente nella griglia
    // prende come valore un handler per un bottone
    public Button gridButton(final TTTController handler) {
        final GettersMVC getters = new GettersMVC();
        final int factor = getters.getSize();

        final Button btn = new Button();
        final DropShadow shadow = new DropShadow();
        btn.setEffect(shadow);
        btn.setBackground(new Background(BackgroundLoader.gameButtonBackground));
        btn.setPrefSize(200, 200);
        btn.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 100 / (double) factor));
        btn.addEventFilter(MouseEvent.MOUSE_CLICKED, handler.eh);
        btn.addEventFilter(MouseEvent.MOUSE_RELEASED, handler.released);

        return btn;
    }

    /* metodo che restituisce il bottone presente alla fine del gioco */
    public Button endGameButton(final String winner) {
        Button btn = new Button();
        btn.setBackground(new Background(BackgroundLoader.endGameButton));
        btn.setText("The winner is: " + winner);
        btn.setTranslateY(-130);

        btn.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 40));
        return btn;
    }

    public Button gameDarkModeIcon(final TTTController handler) {
        Button btn = new Button();
        btn.setMinSize(50, 40);
        btn.setBackground(new Background(BackgroundLoader.darkButtonIcon));
        btn.addEventFilter(MouseEvent.MOUSE_CLICKED, handler.changeDarkModeButton);
        return btn;
    }
}
