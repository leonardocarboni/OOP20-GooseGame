package model;

import java.util.ArrayList;
import java.util.List;

import utility.Boxes;
import utility.BoxesType;

public class Board {

	private final int size;
	private final List<Boxes> boxes;
	
	public Board(final int size) {
		this.size = size;
		this.boxes = new ArrayList<>(size);
	}

	/*
	 * Function to create the board of game
	 * @param size of game
	 * @param number of minigames in the board
	 * @return game board
	 */
	public List<Boxes> generateBoard(){
		checkSize(size);
		final List<Boxes> minigames = getAllBoxesByType(BoxesType.MINIGAMES);
		boxes.add(Boxes.START);
		int addSpecial = 0;
		boolean addMinigames = false;
		for(int i = 0; i < size - 1; i++) {
			if(addSpecial == 2) {
				if(addMinigames) {
					boxes.add(minigames.get(randomValue(0, minigames.size() - 1)));
				}else {
					boxes.add(Boxes.BONUS);
				}
				addMinigames = addMinigames ? false : true;
				addSpecial = 0;
			}else {
				boxes.add(Boxes.NORMAL);
				addSpecial++;
			}
		}
		boxes.add(Boxes.END);
		return boxes;
	}

	/*
	 * Function to get type of box
	 * @param a player
	 * @return type of box where the player is above now 
	 */
	public BoxesType getBox(final Player p) {
		return boxes.get(p.getBoardPosition()).getType();
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
	
	/*
	 * Function to get all boxes that matches the filter
	 * @param type of Boxes to filter
	 * @return list of boxes 
	 */
	private List<Boxes> getAllBoxesByType(final BoxesType type){
		final List<Boxes> list = new ArrayList<>();
		for (final Boxes b : Boxes.values()) {
			if(b.getType().equals(type)) {
				list.add(b);
			}
		}
		return list;
	}
}
