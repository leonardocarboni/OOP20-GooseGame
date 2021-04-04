package model.box;

public enum Box {

	START(BoxType.NORMAL,"Start",0,0),
	NORMAL(BoxType.NORMAL,"Nothing",0,0),
	BONUS(BoxType.LUCK,"Bonus",0,2),
	MALUS(BoxType.LUCK,"Malus",-2,0),
	END(BoxType.NORMAL,"End",0,0),
	TICTACTOE(BoxType.MINIGAMES,"Tris",-2,0),
	EVEN_OR_ODD(BoxType.MINIGAMES,"Pari o Dispari",-2,0),
	ROCK_PAPER_SCISSORS(BoxType.MINIGAMES,"Sasso Carta Forbici",3,3),
	CABLE_CONNECT(BoxType.MINIGAMES,"Collega i cavi",2,2),
	PHRASE_CATCH(BoxType.MINIGAMES,"",0,0);
	
	private BoxType type;
	private String description;
	private int penality;
	private int win;

	Box(final BoxType type, final String description,final int penality, final int win) {
		this.type = type;
		this.description = description;
		this.penality = penality;
		this.win = win;
	}

	public BoxType getType() {
		return type;
	}

	public int getPenality() {
		return penality;
	}

	public int getWin() {
		return win;
	}

	public String getDescription() {
		return description;
	}

}
