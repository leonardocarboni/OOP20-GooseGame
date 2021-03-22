package model;

public class Player {
	
	private String name;
	private int boardPosition;
	
	public Player(final String name) {
		if("".equals(name)) {
			throw new IllegalStateException();
		}
		this.name = name;
		this.boardPosition = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
	
	public int getBoardPosition() {
		return boardPosition;
	}

	/*
	private void setBoardPosition(final int boardPosition) {
		this.boardPosition = boardPosition;
	}
	*/
	
	public void addPosition(final int diceValue) {
		this.boardPosition += diceValue;
	}
	
	public void resetPosition() {
		this.boardPosition = 0;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", boardPosition=" + boardPosition + "]";
	}
	
	
}
