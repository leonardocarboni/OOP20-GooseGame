package controller.game;

import model.box.Box;

public interface GameController {

	/**
	 * Return result of minigame. 
	 * @param box
	 * @return int 
	 */
	int checkMinigames(Box box);

}
