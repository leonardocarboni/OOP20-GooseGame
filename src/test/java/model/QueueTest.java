package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import model.player.PlayerColor;
import model.player.PlayerImpl;
import model.queue.QueueImpl;

class QueueTest {

    private QueueImpl ql;

    @Test
    void iterate() {
        ql = new QueueImpl();
        final List<PlayerImpl> list = new ArrayList<>();
        list.add(new PlayerImpl("Ciao", PlayerColor.PINK));
        list.add(new PlayerImpl("Ciao2", PlayerColor.PINK));
        list.add(new PlayerImpl("Ciao4", PlayerColor.PINK));
        ql.setStartingQueue(list);
        ql.resetIterator();

        assertEquals(ql.getCurrent(), list.get(0));
        assertEquals(ql.next(), list.get(1));
        assertEquals(ql.next(), list.get(2));

        for (int i = 0; i < 3; i++) {
            ql.next();
        }

        assertEquals(ql.getCurrent(), list.get(2));
    }

    @Test
    void checkOrdering() {
        ql = new QueueImpl();
        final Map<PlayerImpl, Integer> mapResult = new HashMap<>();
        final List<PlayerImpl> listExpected = new ArrayList<>();
        final PlayerImpl p = new PlayerImpl("Ciao", PlayerColor.PINK);
        final PlayerImpl p1 = new PlayerImpl("Ciao2", PlayerColor.PINK);
        final PlayerImpl p2 = new PlayerImpl("Ciao4", PlayerColor.PINK);

        mapResult.put(p, 4);
        mapResult.put(p1, 0);
        mapResult.put(p2, 3);
        ql.orderPlayerQueue(mapResult);

        listExpected.add(p);
        listExpected.add(p2);
        listExpected.add(p1);
        System.out.println(listExpected);
        System.out.println(ql.getStartingQueue());
        assertEquals(listExpected, ql.getStartingQueue());

    }
}
