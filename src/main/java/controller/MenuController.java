package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.MenuView;

public class MenuController {
	
	private final MenuView view;

	public MenuController() {
		view = new MenuView();
    	view.addButtonListener(new test());
	}
	
	public class test implements EventHandler<ActionEvent> {
        @Override
        public void handle(final ActionEvent event) {
        	final PlayerChooserControllerImpl pl = new PlayerChooserControllerImpl();
        	view.closeStage();
        }
    }

}
