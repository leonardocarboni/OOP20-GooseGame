package application.minigame.tictactoe.fxItem;

import application.minigame.tictactoe.interfaces.ItemFactory;
import application.minigame.tictactoe.mvc.GettersMVC;
import application.minigame.tictactoe.mvc.TTTControllerImpl;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * Item factory {@link ItemFactory}.
 */
public class ItemFactoryImpl extends Button implements ItemFactory {

    public Button gridButton(final TTTControllerImpl handler) {
        final GettersMVC getters = new GettersMVC();
        final int factor = getters.getSize();

        final Button btn = new Button();
        final DropShadow shadow = new DropShadow();
        btn.setEffect(shadow);
        btn.setBackground(new Background(BackgroundLoader.GAME_BUTTON_BACKGROUND));
        btn.setPrefSize(200, 200);
        btn.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 100 / (double) factor));
        btn.addEventFilter(MouseEvent.MOUSE_CLICKED, handler.getClick());

        return btn;
    }

    public Button endGameButton(final String winner) {
        Button btn = new Button();
        btn.setBackground(new Background(BackgroundLoader.END_GAME_BACKGROUND));
        btn.setText("The winner is: " + winner);
        btn.setTranslateY(-130);

        btn.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 40));
        return btn;
    }

    public Button gameDarkModeIcon(final TTTControllerImpl handler) {
        Button btn = new Button();
        btn.setMinSize(50, 40);
        btn.setBackground(new Background(BackgroundLoader.CHANGE_COLOR_BUTTON));
        btn.addEventFilter(MouseEvent.MOUSE_CLICKED, handler.getChangeDarkModeButton());
        return btn;
    }
}
