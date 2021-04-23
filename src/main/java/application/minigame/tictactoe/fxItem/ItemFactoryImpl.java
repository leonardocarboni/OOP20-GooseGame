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
    /**
     * Width of the button in the grid.
     */
    private static final int WIDHT_OF_GRIDBUTTON = 200;
    /**
     * Height of the button in the grid.
     */
    private static final int HEIGHT_OF_GRIDBUTTON = 200;
    /**
     * Width of the button that changes color of the grid.
     */
    private static final int WIDTH_OF_GAMEDARKMODEICON = 50;
    /**
     * Height of the button that changes color of the grid.
     */
    private static final int HEIGHT_OF_GAMEDARKMODEICON = 40;
    /**
     * Y position of the final button that say the winner.
     */
    private static final int TRANSLATE_Y_OF_ENDGAMEBUTTON = 13;
    /**
     * Font of the text in the final button.
     */
    private static final int SIZE_FONT_ENDGAMEBUTTON = 40;
    public Button gridButton(final TTTControllerImpl handler) {
        final GettersMVC getters = new GettersMVC();
        final int factor = getters.getSize();

        final Button btn = new Button();
        final DropShadow shadow = new DropShadow();
        btn.setEffect(shadow);
        btn.setBackground(new Background(BackgroundLoader.GAME_BUTTON_BACKGROUND));
        btn.setPrefSize(WIDHT_OF_GRIDBUTTON, HEIGHT_OF_GRIDBUTTON);
        btn.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 100 / (double) factor));
        btn.addEventFilter(MouseEvent.MOUSE_CLICKED, handler.getClick());

        return btn;
    }

    public Button endGameButton(final String winner) {
        final Button btn = new Button();
        btn.setBackground(new Background(BackgroundLoader.END_GAME_BACKGROUND));
        btn.setText("The winner is: " + winner);
        btn.setTranslateY(TRANSLATE_Y_OF_ENDGAMEBUTTON);

        btn.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, SIZE_FONT_ENDGAMEBUTTON));
        return btn;
    }

    public Button gameDarkModeIcon(final TTTControllerImpl handler) {
        final Button btn = new Button();
        btn.setMinSize(WIDTH_OF_GAMEDARKMODEICON, HEIGHT_OF_GAMEDARKMODEICON);
        btn.setBackground(new Background(BackgroundLoader.CHANGE_COLOR_BUTTON));
        btn.addEventFilter(MouseEvent.MOUSE_CLICKED, handler.getChangeDarkModeButton());
        return btn;
    }
}
