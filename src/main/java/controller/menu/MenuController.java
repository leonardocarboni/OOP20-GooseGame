package controller.menu;

import controller.howtoplay.HowToPlay;
import controller.howtoplay.HowToPlayImpl;
import controller.playerchooser.PlayerChooserControllerImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.HowToPlayView;
import view.MenuView;

public class MenuController {
	
	private final MenuView view;

	public MenuController() {
		view = new MenuView();
    	view.addPlayButtonListener(new PlayClicked());
    	view.addHowToPlayButtonListener(new HowToPlayClicked());
	}
	
	public class PlayClicked implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
        	final PlayerChooserControllerImpl playerChooser = new PlayerChooserControllerImpl();
        	view.closeStage();
        }
    }

	public class HowToPlayClicked implements EventHandler<ActionEvent> {
		@Override
		public void handle(final ActionEvent event) {
			final HowToPlay howToPlay = new HowToPlayImpl();
		}
	}
}
