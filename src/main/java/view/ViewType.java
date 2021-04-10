package view;

public enum ViewType {
	
	STARTING_MENU("Goose Game","layouts/menu.fxml"),
	CHOOSE_PLAYER("Choose a Player","layouts/playerselection.fxml"),
	GAME("Play Game","layouts/maingame.fxml"),
	CABLE_CONNECT("Minigame Cable Connect","layouts/cableconnect.fxml"),
	EVEN_OR_ODD("Minigame Ever Or Odd", "layouts/cableconnect.fxml"),
	ROCK_PAPER_SCISSORS("Minigame ROCK PAPER SCISSORS","layouts/cableconnect.fxml"),
	TICTACTOE("Minigame Tic Tac Toe","");
	
	private String title;
	private String layoutLocation;

	ViewType(final String title, final String layoutLocation) {
		this.title = title;
		this.layoutLocation = layoutLocation;
	}

	public String getTitle() {
		return title;
	}

	public String getLayoutLocation() {
		return layoutLocation;
	}
}
