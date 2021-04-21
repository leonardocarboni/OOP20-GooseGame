package controller.winscreen;

import controller.playerchooser.PlayerChooserControllerImpl;

import model.player.PlayerImpl;
import view.WinScreenView;

import java.util.List;

public class WinScreenImpl implements WinScreen {

    private final WinScreenView view;

    public <T> WinScreenImpl() {
        view = new WinScreenView();
    }

    public void start(final List<PlayerImpl> playersList) {
        view.addButtonListener(e -> {
            final PlayerChooserControllerImpl pc = new PlayerChooserControllerImpl();
            pc.start();
            view.close();
        });

        view.setPlayers(playersList);
        view.show();
    }
}
