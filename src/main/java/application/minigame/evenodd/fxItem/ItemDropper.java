package application.minigame.evenodd.fxItem;

import application.minigame.evenodd.mvc.EOController;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ItemDropper extends Button {

    public Button evenButton(EOController handler) {

        final Button btn = new Button();

        btn.setTranslateX(-150);
        btn.setTranslateY(150);
        btn.setText("PARI");
        btn.addEventFilter(MouseEvent.MOUSE_CLICKED, handler.click);

        btn.setPrefSize(200, 50);

        btn.setBackground(new Background(BackgroundLoader.buttonPrincipal));

        return btn;
    }

    public Button oddButton(EOController handler) {

        final Button btn = new Button();

        btn.setText("DISPARI");
        btn.setTranslateX(150);
        btn.setTranslateY(150);
        btn.setPrefSize(200, 50);
        btn.addEventFilter(MouseEvent.MOUSE_CLICKED, handler.click);

        btn.setBackground(new Background(BackgroundLoader.buttonPrincipal));

        return btn;
    }

    public Text createText(String string, String resultValue, int positionY) {
        Text text = new Text();
        text.setText(string + resultValue.toString());
        text.setTranslateY(positionY);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        text.setFill(Color.BEIGE);
        return text;
    }

}
