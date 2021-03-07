package model;

public class Box {

	private String name;
	private int penality;
	private int win;
	
	public Box(final String name, final int penality, final int win) {
		this.name = name;
		this.penality = penality;
		this.win = win;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
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
	
	
}
