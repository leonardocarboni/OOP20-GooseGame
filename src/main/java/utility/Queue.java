package utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import model.Player;

public class Queue implements Iterator<Player>{

	private List<Player> startingQueue;
	private Player current;
	private Iterator<Player> playerIterator;
	
	public Queue() {
		this.startingQueue =  new ArrayList<>();
	}
	
	public void orderPlayerQueue(final Map<Player,Integer> diceThrowing) {
		 final List<Entry<Player, Integer>> list = new LinkedList<>(diceThrowing.entrySet());

	     // Sorting the list based on value
		 Collections.sort(list, new Comparator<Entry<Player,Integer>>() {

			 @Override
			 public int compare(final Entry<Player, Integer> o1, final Entry<Player, Integer> o2) {
				return -1 * o1.getValue().compareTo(o2.getValue());
			 }
	        	
		});

		//Collections.sort(list,Collections.reverseOrder());
	    for (final Entry<Player, Integer> entry : list){
	    	startingQueue.add(entry.getKey());
	    }
	}

	public List<Player> getStartingQueue() {
		return startingQueue;
	}

	@Override
	public boolean hasNext() {
		if(!playerIterator.hasNext()) {
			playerIterator = startingQueue.iterator();
		}
		return playerIterator.hasNext();
	}

	@Override
	public Player next() {
		if(!playerIterator.hasNext()) {
			playerIterator = startingQueue.iterator();
		}
		current = playerIterator.next();
		return current;
	}
	
	public void resetIterator() {
		playerIterator = startingQueue.iterator();
		current = this.next();
	}

	public Player getCurrent() {
		return current;
	}
	
	public void setQueue(List<Player> l) {
		this.startingQueue = l;
	}
}
