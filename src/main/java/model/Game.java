package model;

import java.util.ArrayList;
import java.util.List;

import utility.FileUtility;
import utility.Rank;

public class Game {

	public static void main(final String[] args) {
		
		final List<Player> list = new ArrayList<>();
		final Player g1 = new Player("Luca");
		final Player g2 = new Player("Giovanni");
		final FileUtility fu = new FileUtility();
		
		list.add(g1);
		list.add(g2);
		final Rank r = new Rank(list);
		System.out.println(g1.toString());
		System.out.println(g2.toString());
		
		g1.addPosition(3);
		g2.addPosition(6);
		
		r.updateRanking();
		
		System.out.println(r.getRanking());
		System.out.println(g2.toString());
		
		g1.addPosition(1);
		g2.addPosition(5);
		
		r.updateRanking();
		
		//End Game
		fu.saveFileRanking(r.getRanking());
		
	}

}
