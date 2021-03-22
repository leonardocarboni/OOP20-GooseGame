package view;

public enum GamesViewType {
	
	STARTING_MENU("Goose Game","layouts" + System.getProperty("file.separator") + "menu.fxml",2,2),
	CHOOSE_PLAYER("Choose a Player","layouts" + System.getProperty("file.separator") + "playerselection.fxml",1,2),
	GAME("Play Game","layouts"+System.getProperty("file.separator") +"maingame.fxml",2,2),
	CABLE_CONNECT("Minigame Cable Connect","layouts" + System.getProperty("file.separator") + "cableconnect.fxml",1,2),
	EVEN_OR_ODD("Minigame Ever Or Odd", "layouts" + System.getProperty("file.separator") + "cableconnect.fxml",1,2),
	ROCK_PAPER_SCISSORS("Minigame ROCK PAPER SCISSORS","layouts" + System.getProperty("file.separator") + "cableconnect.fxml",1,2),
	TICTACTOE("Minigame Tic Tac Toe","",1,2);
	
	private String title;
	private String layoutLocation;
	private int proportionWidth;
	private int proportionHeight;
	
	GamesViewType(final String title, final String layoutLocation, final int proportionWidth, final int proportionHeight) {
		this.title = title;
		this.layoutLocation = layoutLocation;
		this.proportionHeight = proportionHeight;
		this.proportionWidth = proportionWidth;
	}

	public String getTitle() {
		return title;
	}

	public String getLayoutLocation() {
		return layoutLocation;
	}

	public int getProportionWidth() {
		return proportionWidth;
	}

	public int getProportionHeight() {
		return proportionHeight;
	}
	
	
}
