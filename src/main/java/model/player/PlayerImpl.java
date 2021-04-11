package model.player;

public class PlayerImpl implements Player{

	private String name;
	private final PlayerColor color;
	private int boardPosition;

	public PlayerImpl(final String name,final PlayerColor color) {
		if("".equals(name)) {
			throw new IllegalStateException();
		}
		this.name = name;
		this.color = color;
		this.boardPosition = 0;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public int getBoardPosition() {
		return boardPosition;
	}

	@Override
	public void addPosition(final int diceValue) {
		this.boardPosition += diceValue;
	}

	@Override
	public void resetPosition() {
		this.boardPosition = 0;
	}

	@Override
	public PlayerColor getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "PlayerImpl [name=" + name + ", color=" + color + ", boardPosition=" + boardPosition + "]";
	}

}
