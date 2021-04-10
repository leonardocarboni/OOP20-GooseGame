package controller.winscreen;

import controller.playerchooser.PlayerChooserControllerImpl;
import model.player.Player;

import view.WinScreenView;

import java.util.List;

public class WinScreenImpl implements WinScreen{

    public WinScreenImpl(List<Player> playersList){
        WinScreenView view = new WinScreenView();

        view.addButtonListener(e -> {
            PlayerChooserControllerImpl pc = new PlayerChooserControllerImpl();
            view.close();
        });

        view.setPlayers(playersList);
        view.show();

    }
}
