package controller.winscreen;

import controller.playerchooser.PlayerChooserController;

import model.duration.GameDuration;
import model.player.Player;
import view.winscreen.WinScreenView;

import java.util.List;

public class WinScreenImpl implements WinScreen {

    private final WinScreenView view;

    public <T> WinScreenImpl() {
        view = new WinScreenView();
    }

    @Override
    public void start(final List<Player> playersList, final GameDuration duration) {
        view.addButtonListener(e -> {
            final PlayerChooserController pc = new PlayerChooserController();
            pc.start();
            view.close();
        });
        view.setDuration(duration);

        view.setPlayers(playersList);
        view.show();
    }
}
