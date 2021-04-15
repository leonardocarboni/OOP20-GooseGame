package controller.winscreen;

import controller.playerchooser.PlayerChooserControllerImpl;

import model.player.PlayerImpl;
import view.WinScreenView;

import java.util.List;

public class WinScreenImpl implements WinScreen {

    public <T> WinScreenImpl(final List<PlayerImpl> playersList) {
        final WinScreenView view = new WinScreenView();

        view.addButtonListener(e -> {
            final PlayerChooserControllerImpl pc = new PlayerChooserControllerImpl();
            //spostare tutto in start e togliere il costruttore.
            view.close();
        });

        view.setPlayers(playersList);
        view.show();

    }
}
