package application;


import application.minigame.memory.MemoryController;
import application.minigame.memory.MemoryView;
import controller.menu.MenuController;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{
	
    @Override
	public void start(final Stage primaryStage) throws Exception {
		final MenuController mc = new MenuController();
	}
	
	public static void main(final String[] args) {
        launch(args);
    }
}
