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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardPosition;
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Player other = (Player) obj;

		return boardPosition == other.boardPosition; /* did this to remove warning*/
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", boardPosition=" + boardPosition + "]";
	}
	
	
}
