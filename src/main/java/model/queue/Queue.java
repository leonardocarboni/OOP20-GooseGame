package model.queue;

import java.util.List;
import java.util.Map;

import model.player.PlayerImpl;

public interface Queue {

	void orderPlayerQueue(final Map<PlayerImpl,Integer> diceThrowing);

	void setStartingQueue(final List<PlayerImpl> l);

	PlayerImpl getCurrent();

	List<PlayerImpl> getStartingQueue();

	void resetIterator();

	
}
