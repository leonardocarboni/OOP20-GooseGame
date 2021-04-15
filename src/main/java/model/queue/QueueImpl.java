package model.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import model.player.PlayerImpl;

public class QueueImpl implements Iterator<PlayerImpl>, Queue {

    private List<PlayerImpl> startingQueue;
    private PlayerImpl current;
    private Iterator<PlayerImpl> playerIterator;

    public QueueImpl() {
        this.startingQueue = new ArrayList<>();
    }

    @Override
    public void orderPlayerQueue(final Map<PlayerImpl, Integer> diceThrowing) {
        startingQueue = new ArrayList<>();
        final List<Entry<PlayerImpl, Integer>> list = new LinkedList<>(diceThrowing.entrySet());

        // Sorting the list based on value
        Collections.sort(list, new Comparator<Entry<PlayerImpl, Integer>>() {

            @Override
            public int compare(final Entry<PlayerImpl, Integer> o1, final Entry<PlayerImpl, Integer> o2) {
                return -1 * o1.getValue().compareTo(o2.getValue());
            }

        });
        for (final Entry<PlayerImpl, Integer> entry : list) {
            startingQueue.add(entry.getKey());
        }
    }

    @Override
    public void setStartingQueue(final List<PlayerImpl> list) {
        this.startingQueue = getDeepCopy(list);
    }

    @Override
    public List<PlayerImpl> getStartingQueue() {
        return startingQueue;
    }

    @Override
    public PlayerImpl getCurrent() {
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
    public PlayerImpl next() {
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
    private List<PlayerImpl> getDeepCopy(final List<PlayerImpl> list) {
        final Iterator<PlayerImpl> iterator = list.iterator();
        final List<PlayerImpl> deepCopy = new ArrayList<>();
        while (iterator.hasNext()) {
            deepCopy.add(iterator.next());
        }
        return deepCopy;
    }
}
