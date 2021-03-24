package application.minigame.evenodd.fxItem;

import application.minigame.evenodd.mvc.GettersMVC;
import application.minigame.evenodd.mvc.EOController;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.Optional;

public class ButtonDropper extends Button {


    //metodo che consente di creare il bottone presente nella griglia
    //prende come valore un handler per un bottone
    public Button evenButton(EOController handler){
        final GettersMVC getters = new GettersMVC();

        final Button btn = new Button();
        final DropShadow shadow = new DropShadow();

        btn.setTranslateX(-150);
        btn.setTranslateY(100);
        btn.setText("PARI");
        btn.addEventFilter(MouseEvent.MOUSE_CLICKED, handler.click);

        btn.setPrefSize(200,50);

        btn.setBackground(new Background(BackgroundLoader.endGameButton));

        return btn;
    }

    public Button oddButton(EOController handler){
        final GettersMVC getters = new GettersMVC();

        final Button btn = new Button();
        final DropShadow shadow = new DropShadow();

        btn.setText("DISPARI");
        btn.setTranslateX(150);
        btn.setTranslateY(100);
        btn.setPrefSize(200,50);
        btn.addEventFilter(MouseEvent.MOUSE_CLICKED, handler.click);

        btn.setBackground(new Background(BackgroundLoader.endGameButton));

        return btn;
    }

    public Button exitButton(Optional<EOController> handler, String winner){
        Button btn = new Button();
        btn.addEventFilter(MouseEvent.MOUSE_CLICKED, handler.get().exit);
        btn.setBackground(new Background(BackgroundLoader.endGameButton));
        btn.setText("Exit");
        btn.setTranslateY(30);

        btn.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC,40));
        return btn;
    }




}
