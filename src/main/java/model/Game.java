package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.board.BoardImpl;
import model.player.PlayerImpl;
import model.rank.RankImpl;
import utility.FileUtilityImpl;

public class Game {

	public static void main(final String[] args) {
		
		final List<PlayerImpl> list = new ArrayList<>();
		final PlayerImpl g1 = new PlayerImpl("Luca");
		final PlayerImpl g2 = new PlayerImpl("Giovanni");
		final FileUtilityImpl fu = new FileUtilityImpl();
		try {
			fu.loadFileRanking();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final BoardImpl b = new BoardImpl(42);
		System.out.println(b.generateBoard());
		list.add(g1);
		list.add(g2);
		final RankImpl r = new RankImpl(list);
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
