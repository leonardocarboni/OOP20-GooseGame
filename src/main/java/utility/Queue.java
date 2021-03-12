package utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import model.Player;

public class Queue {

	private final List<Player> startingQueue;

	public Queue() {
		this.startingQueue =  new ArrayList<>();
	}
	
	public void orderPlayerQueue(final Map<Player,Integer> diceThrowing) {
		 final List<Entry<Player, Integer>> list = new LinkedList<>(diceThrowing.entrySet());

	     // Sorting the list based on value
		 Collections.sort(list, new Comparator<Entry<Player,Integer>>() {

			 @Override
			 public int compare(final Entry<Player, Integer> o1, final Entry<Player, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			 }
	        	
		});

	    for (final Entry<Player, Integer> entry : list){
	    	startingQueue.add(entry.getKey());
	    }
	}
}
