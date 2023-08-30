package test.list;

import main.list.LinkedList;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(1, l.get(1));
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
        l.printList();
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
        l.printList();
        l.remove(1);
        assertThrows(NoSuchElementException.class, () -> l.get(0));
    }

    @Test
    public void testRemoveTwo() {
        LinkedList l = new LinkedList();
        l.add(1);
        l.add(2);
        l.printList();
        l.remove(1);
        l.printList();
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
        l.printList();
        l.remove(1);
        l.printList();
        assertEquals(2, l.get(0));
        l.remove(2);
        l.printList();
        assertEquals(3, l.get(0));
        l.remove(3);
        assertThrows(NoSuchElementException.class, () -> l.remove(3));
    }

    @Test
    public void testRemoveAtIndexOne() {
        LinkedList l = new LinkedList();
        l.add(1);
        l.printList();
        l.removeAtIndex(0);
        l.printList();
    }

    @Test
    public void testRemoveAtIndexTwo() {
        LinkedList l = new LinkedList();
        l.add(1);
        l.add(2);
        l.printList();
        l.removeAtIndex(1);
        l.printList();
        l.removeAtIndex(0);
        l.printList();
    }

    @Test
    public void testRemoveAtIndexThree() {
        LinkedList l = new LinkedList();
        l.add(1);
        l.add(2);
        l.add(3);
        l.printList();
        l.removeAtIndex(1);
        l.printList();
        l.removeAtIndex(0);
        l.printList();
        l.removeAtIndex(0);
        l.printList();
    }

    @Test
    public void testRemoveAtIndexFour() {
        LinkedList l = new LinkedList();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.printList();
        l.removeAtIndex(3);
        l.printList();
        l.removeAtIndex(0);
        l.printList();
        l.removeAtIndex(1);
        l.printList();
        l.removeAtIndex(0);
        l.printList();
    }

    @Test
    public void testSet() {
        LinkedList l = new LinkedList();
        l.add(1);// 1
        l.add(2);// 2
        assertEquals(2, l.get(1));
        l.set(1, 4);
        assertEquals(4, l.get(1));
        l.add(0); // 0
    }

    @Test
    public void testContainsOne() {
        LinkedList l = new LinkedList();
        l.add(1);// 1
        assertTrue(l.contains(1));
    }

    @Test
    public void testContainsTwo() {
        LinkedList l = new LinkedList();
        l.add(1);// 1
        l.add(2);// 2
        assertTrue(l.contains(1));
        assertTrue(l.contains(2));
    }

    @Test
    public void testContainsThree() {
        LinkedList l = new LinkedList();
        l.add(1);// 1
        l.add(2);// 2
        l.add(3);// 3
        assertTrue(l.contains(1));
        assertTrue(l.contains(2));
        assertTrue(l.contains(3));
        l.remove(2);
        assertFalse(l.contains(2));
    }

    @Test
    public void testContainsNot() {
        LinkedList l = new LinkedList();
        l.add(1);// 1
        l.add(2);// 2
        l.add(3);// 3
        assertFalse(l.contains(4));
    }

    @Test
    public void testAddAllEmptyList() {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l2.add(1);// 1
        l2.add(2);// 2
        l2.add(3);// 3
        l1.printList();
        l2.printList();
        l1.addAll(l2);
        l1.printList();
    }

    @Test
    public void testAddAllOneElement() {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l2.add(1);// 1
        l2.add(2);// 2
        l2.add(3);// 3
        //////////////
        l1.add(1);//
        l1.printList();
        l2.printList();
        l1.addAll(l2);
        l1.printList();
    }

    @Test
    public void testAddAllTwoElements() {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l2.add(1);// 1
        l2.add(2);// 2
        l2.add(3);// 3
        //////////////
        l1.add(1);//
        l1.add(2);//
        l1.printList();
        l2.printList();
        l1.addAll(l2);
        l1.printList();
    }

    @Test
    public void testAddAllThreeElements() {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l2.add(1);// 1
        l2.add(2);// 2
        l2.add(3);// 3
        //////////////
        l1.add(1);//
        l1.add(2);//
        l1.add(3);//
        l1.printList();
        l2.printList();
        l1.addAll(l2);
        l1.printList();
    }
}
