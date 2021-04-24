package controller.menu;

import controller.howtoplay.HowToPlay;
import controller.howtoplay.HowToPlayImpl;
import controller.playerchooser.PlayerChooserController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.ViewType;
import view.menu.MenuView;

public class MenuController {

    private final MenuView view;

    public MenuController() {
        view = new MenuView();
        view.createStage(ViewType.STARTING_MENU);
        view.addPlayButtonListener(new PlayClicked());
        view.addHowToPlayButtonListener(new HowToPlayClicked());
    }

    public void start() {
        view.show();
    }

    public class PlayClicked implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
            final PlayerChooserController playerChooser = new PlayerChooserController();
            playerChooser.start();
            view.close();
        }
    }

    public class HowToPlayClicked implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
            final HowToPlay howToPlay = new HowToPlayImpl();
            howToPlay.start();
        }
    }
}
