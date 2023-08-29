package test.list;

import main.list.LinkedList;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinkedListTest {
    @Test
    public void testAdd() {
        LinkedList l = new LinkedList();
        l.add(0);
        l.add(1);
        l.add(2);
        assertEquals(0, l.get(0));
        assertEquals(1, l.get(1));
        assertEquals(2, l.get(2));
    }

    @Test
    public void testAddAtIndex() {
        LinkedList l = new LinkedList();
        l.add(0); // 0
        l.add(1);// 1
        l.add(2);// 2
        l.addAtIndex(1, 2);
        assertEquals(2, l.get(1));
    }

    @Test
    public void testAddAtIndexInvalid() {
        LinkedList l = new LinkedList();
        l.add(0); // 0
        l.add(1);// 1
        l.add(2);// 2
        assertThrows(IndexOutOfBoundsException.class, () -> l.addAtIndex(4, 2));
    }

    @Test
    public void testAddFirst() {
        LinkedList l = new LinkedList();
        l.add(0); // 0
        l.add(1);// 1
        l.add(2);// 2
        assertEquals(0, l.getFirst());
        l.addFirst(-1);
        assertEquals(-1, l.getFirst());
        assertEquals(0, l.get(1));
    }

    @Test
    public void testAddLast() {
        LinkedList l = new LinkedList();
        l.addLast(0); // 0
        l.add(1);// 1
        l.add(2);// 2
        assertEquals(2, l.getLast());
        l.addLast(-1);
        assertEquals(-1, l.getLast());
        assertEquals(2, l.get(l.size() - 2));
        System.out.println(l.toString());
    }

    @Test
    public void testRemove() {
        LinkedList l = new LinkedList();
        assertThrows(NoSuchElementException.class, () -> l.remove(2));
    }

    @Test
    public void testRemoveOne() {
        LinkedList l = new LinkedList();
        l.add(1);
        System.out.println(l.toString());
        l.remove(1);
        assertThrows(NoSuchElementException.class, () -> l.get(0));
    }

    @Test
    public void testRemoveTwo() {
        LinkedList l = new LinkedList();
        l.add(1);
        l.add(2);
        System.out.println(l.toString());
        l.remove(1);
        System.out.println(l.toString());
        assertEquals(2, l.get(0));
        l.remove(2);
        assertThrows(NoSuchElementException.class, () -> l.get(0));
    }

    @Test
    public void testRemoveThree() {
        LinkedList l = new LinkedList();
        l.add(1);
        l.add(2);
        l.add(3);
        System.out.println(l.toString());
        l.remove(1);
        System.out.println(l.toString());
        assertEquals(2, l.get(0));
        l.remove(2);
        System.out.println(l.toString());
        assertEquals(3, l.get(0));
        l.remove(3);
        assertThrows(NoSuchElementException.class, () -> l.remove(3));
    }

    @Test
    public void testSet() {
        LinkedList l = new LinkedList();
        l.add(0); // 0
        l.add(1);// 1
        l.add(2);// 2
        assertEquals(1, l.get(1));
        l.set(1, 4);
        assertEquals(4, l.get(1));
    }


}
