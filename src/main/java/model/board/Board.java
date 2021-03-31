package model.board;

import java.util.List;

import model.StateGame;
import model.box.Box;
import model.player.PlayerImpl;

public interface Board {

	List<Box> generateBoard();

	StateGame endGame(PlayerImpl p);

}
