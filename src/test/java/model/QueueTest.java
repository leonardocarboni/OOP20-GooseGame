package model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.player.PlayerColor;
import model.player.PlayerImpl;
import model.queue.QueueImpl;

class QueueTest {

	@Test
	void iterate() {
		final List<PlayerImpl> list = new ArrayList<>();
		list.add(new PlayerImpl("Ciao", PlayerColor.PINK));
		list.add(new PlayerImpl("Ciao2", PlayerColor.PINK));
		list.add(new PlayerImpl("Ciao4", PlayerColor.PINK));
		
		final QueueImpl ql = new QueueImpl();
		ql.setStartingQueue(list);
		ql.resetIterator();
		
		assertEquals(ql.getCurrent(), list.get(0));
		assertEquals(ql.next(), list.get(1));
		assertEquals(ql.next(), list.get(2));
		
		for(int i = 0; i < 9;i++) {
			ql.next();
		}
		
		assertEquals(ql.getCurrent(), list.get(2));
	}

}
