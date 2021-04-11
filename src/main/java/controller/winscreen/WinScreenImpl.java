package controller.winscreen;

import controller.playerchooser.PlayerChooserControllerImpl;

import model.player.PlayerImpl;
import view.WinScreenView;

import java.util.List;

public class WinScreenImpl implements WinScreen{

    public <T> WinScreenImpl(List<PlayerImpl> playersList){
        WinScreenView view = new WinScreenView();

        view.addButtonListener(e -> {
            PlayerChooserControllerImpl pc = new PlayerChooserControllerImpl();
            view.close();
        });

        view.setPlayers(playersList);
        view.show();

    }
}
