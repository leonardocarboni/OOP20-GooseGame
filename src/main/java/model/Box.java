package model;

import java.util.ArrayList;
import java.util.List;

import utility.Boxes;
import utility.MinigamesBoxes;

public class Box {

	private Boxes name;
	private int penality;
	private int win;
	
	public Box(final Boxes name, final int penality, final int win) {
		this.name = name;
		this.penality = penality;
		this.win = win;
	}

	public Boxes getName() {
		return name;
	}

	public void setName(final Boxes name) {
		this.name = name;
	}

	public int getPenality() {
		return penality;
	}

	public void setPenality(final int penality) {
		this.penality = penality;
	}

	public int getWin() {
		return win;
	}

	public void setWin(final int win) {
		this.win = win;
	}
	
	/*
	 * @param size of game
	 * @param number of minigames in the board
	 * @return list composed of box 
	 */
	public List<Box> generateBoxes(final int size, final int nMinigames) throws Exception {
		checkSize(size);
		final List<Box> boxes = new ArrayList<>();
		boxes.add(new Box(Boxes.START, 0, 0));
		int con = 0;
		for(int i = 0; i < size - 1; i++) {
			if(con == size / nMinigames) {
				boxes.add(new Box(Boxes.values()[randomValue(0,MinigamesBoxes.values().length)],0,0));
				con = 0;
				break;
			}
			boxes.add(new Box(Boxes.values()[randomValue(1,Boxes.values().length -1)],0,0));
			con++;
		}
		boxes.add(new Box(Boxes.END, 0, 0));
		return boxes;
	}
	
	/*
	 * @param size of board
	 * @throw exception in case the number inserted is too small to create a board
	 */
	private void checkSize(final int size) throws Exception {
		if(size < 2) {
			throw new Exception();
		}
	}
	/*
	 * Probably this will remove adding an utility class used by Box and Dice
	 */
	private int randomValue(final int minValue, final int maxValue) {
		return (int)(Math.random() * ((maxValue - minValue) + 1)) + minValue;
	}
}
