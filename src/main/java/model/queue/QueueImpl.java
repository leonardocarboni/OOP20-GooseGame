package model.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import model.player.Player;

public class QueueImpl implements Queue, Iterator<Player> {

    private List<Player> startingQueue;
    private Player current;
    private Iterator<Player> playerIterator;

    public QueueImpl() {
        this.startingQueue = new ArrayList<>();
    }

    @Override
    public void orderPlayerQueue(final Map<Player, Integer> diceThrowing) {
        startingQueue = new ArrayList<>();
        final List<Entry<Player, Integer>> list = new LinkedList<>(diceThrowing.entrySet());

        // Sorting the list based on value
        Collections.sort(list, new Comparator<Entry<Player, Integer>>() {

            @Override
            public int compare(final Entry<Player, Integer> o1, final Entry<Player, Integer> o2) {
                return -1 * o1.getValue().compareTo(o2.getValue());
            }

        });
        for (final Entry<Player, Integer> entry : list) {
            startingQueue.add(entry.getKey());
        }
    }

    @Override
    public void setStartingQueue(final List<Player> list) {
        this.startingQueue = getDeepCopy(list);
    }

    @Override
    public List<Player> getStartingQueue() {
        return startingQueue;
    }

    @Override
    public Player getCurrent() {
        return current;
    }

    @Override
    public boolean hasNext() {
        if (!playerIterator.hasNext()) {
            playerIterator = startingQueue.iterator();
        }
        return playerIterator.hasNext();
    }

    @Override
    public Player next() {
        if (!playerIterator.hasNext()) {
            playerIterator = startingQueue.iterator();
        }
        current = playerIterator.next();
        return current;
    }

    @Override
    public void resetIterator() {
        playerIterator = startingQueue.iterator();
        current = this.next();
    }

    /**
     * Create a deep copy of the list to avoid problem when list passed in params
     * will change.
     * @param list
     * @return list of players
     */
    private List<Player> getDeepCopy(final List<Player> list) {
        final Iterator<Player> iterator = list.iterator();
        final List<Player> deepCopy = new ArrayList<>();
        while (iterator.hasNext()) {
            deepCopy.add(iterator.next());
        }
        return deepCopy;
    }
}
