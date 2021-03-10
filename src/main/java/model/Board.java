package model;

import java.util.ArrayList;
import java.util.List;

import utility.Boxes;

public class Board {

	private final int size;
	private final List<Boxes> boxes;
	
	public Board(final int size) {
		this.size = size;
		this.boxes = new ArrayList<>(size);
	}
	
	/*
	 * @param size of game
	 * @param number of minigames in the board
	 * @return list composed of box 
	 */
	public List<Boxes> generateBoxes(final int nMinigames){
		checkSize(size);
		boxes.add(Boxes.START);
		int con = 0;
		for(int i = 0; i < size - 1; i++) {
			if(con == size / nMinigames) {
				//Add random minigames
				con = 0;
				break;
			}
			boxes.add(Boxes.NORMAL);
			con++;
		}
		boxes.add(Boxes.END);
		return boxes;
	}
	
	/*
	 * @param player
	 * @return 1 if 
	 */
	public int victory(final Player p) {
		if (p.getBoardPosition() == size) {
			return 1; //win (Enum?)
		}else {
			if(p.getBoardPosition() > size) {
				goBeyoundLimit(p);
			}
			return 0; //no win
		}
	}
	
	private void goBeyoundLimit(final Player p) {
		//Set new position player -> playerPosition - (size - 1) = difference
		//Set difference as new Position
	}
	
	/*
	 * @param size of board
	 * @throw exception in case the number inserted is too small to create a board
	 */
	private void checkSize(final int size){
		if(size < 2) {
			throw new IllegalArgumentException();
		}
	}
	
	/*
	 * @param min Value
	 * @param max Value
	 * @return number between min and max (inclusive) 
	 * Probably this will remove adding an utility class used by Box and Dice
	 */
	private int randomValue(final int minValue, final int maxValue) {
		return (int)(Math.random() * ((maxValue - minValue) + 1)) + minValue;
	}
}
