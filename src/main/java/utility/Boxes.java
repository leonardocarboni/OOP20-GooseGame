package utility;

public enum Boxes {

	START(BoxesType.NORMAL,"Start",0,0),
	NORMAL(BoxesType.NORMAL,"Nothing",0,0),
	BONUS(BoxesType.LUCK,"Bonus",0,2),
	MALUS(BoxesType.LUCK,"Malus",-2,0),
	END(BoxesType.NORMAL,"End",0,0),
	TICTACTOE(BoxesType.MINIGAMES,"Tris",-2,0),
	EVEN_OR_ODD(BoxesType.MINIGAMES,"Pari o Dispari",-2,0),
	ROCK_PAPER_SCISSORS(BoxesType.MINIGAMES,"Sasso Carta Forbici",3,3),
	CABLE_CONNECT(BoxesType.MINIGAMES,"Collega i cavi",2,2);
	
	private BoxesType type;
	private String description;
	private int penality;
	private int win;
	
	Boxes(final BoxesType type, final String description,final int penality, final int win) {
		this.type = type;
		this.description = description;
		this.penality = penality;
		this.win = win;
	}
	
	public BoxesType getType() {
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
