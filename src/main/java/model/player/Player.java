package model.player;

public interface Player {

	String getName();

	void setName(final String name);

	int getBoardPosition();

	void addPosition(final int diceValue);

	void resetPosition();

	
	
}
