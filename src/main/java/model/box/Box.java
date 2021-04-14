package model.box;

public enum Box {

	/**
	 * 
	 */
	START(BoxType.NORMAL, "Start"),
	/**
	 * 
	 */
	NORMAL(BoxType.NORMAL, "Nothing"),
	/**
	 * 
	 */
	BONUS(BoxType.LUCK, "Bonus"),
	/**
	 * 
	 */
	END(BoxType.NORMAL, "End"),
	/**
	 * 
	 */
	TICTACTOE(BoxType.MINIGAMES, "Tris"),
	/**
	 * 
	 */
	EVEN_OR_ODD(BoxType.MINIGAMES, "Pari o Dispari"),
	/**
	 * 
	 */
	ROCK_PAPER_SCISSORS(BoxType.MINIGAMES, "Sasso Carta Forbici"),
	/**
	 * 
	 */
	CABLE_CONNECT(BoxType.MINIGAMES, "Collega i cavi"),
	/**
	 * 
	 */
	PHRASE_CATCH(BoxType.MINIGAMES, ""),
	/**
	 * 
	 */
	SPACESHOOTER(BoxType.MINIGAMES, ""),
	/**
	 * 
	 */
	MEMORY(BoxType.MINIGAMES, "");

	private BoxType type;
	private String description;

	Box(final BoxType type, final String description) {
		this.type = type;
		this.description = description;
	}

	public BoxType getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

}
