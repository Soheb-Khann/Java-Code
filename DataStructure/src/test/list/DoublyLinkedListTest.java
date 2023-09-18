package test.list;

import main.list.DoublyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {

    @Test
    public void testAddZeroSize() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        assertTrue(l.isEmtpy());
        l.add(0);
        assertEquals(0, l.get(0));
        assertTrue(l.getFirst() == l.getLast());
        l.printList();
    }

    @Test
    public void testAddOneSize() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        assertEquals(0, l.get(0));
        l.add(1);
        assertEquals(0, l.get(0));
        assertEquals(1, l.get(1));
        l.printList();
    }

    @Test
    public void testAddTwoSize() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        l.add(1);
        assertEquals(0, l.get(0));
        assertEquals(1, l.get(1));
        l.add(2);
        assertEquals(2, l.get(2));
        l.printList();
    }

    @Test
    public void testAddFirstZeroSize() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        assertTrue(l.isEmtpy());
        l.addFirst(0);
        assertEquals(0, l.get(0));
        assertEquals(0, l.getFirst());
        assertEquals(0, l.getLast());
        l.printList();
    }

    @Test
    public void testAddFirstOneSize() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.addFirst(0);
        assertEquals(0, l.get(0));
        assertEquals(0, l.getFirst());
        l.addFirst(1);
        assertEquals(0, l.get(1));
        assertEquals(0, l.getLast());
        l.printList();
    }

    @Test
    public void testAddFirstTwoSize() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.addFirst(0);
        l.addFirst(1);
        assertEquals(1, l.get(0));
        assertEquals(0, l.get(1));
        assertEquals(0, l.getLast());
        assertEquals(1, l.getFirst());
        l.addFirst(2);
        assertEquals(2, l.get(0));
        assertEquals(2, l.getFirst());
        assertEquals(0, l.getLast());
        assertEquals(1, l.get(1));
        l.printList();
    }

    @Test
    public void testAddFirstThreeSize() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.addFirst(0);
        l.addFirst(1);
        l.addFirst(2);
        assertEquals(2, l.get(0));
        assertEquals(1, l.get(1));
        assertEquals(0, l.get(2));
        assertEquals(2, l.getFirst());
        assertEquals(0, l.getLast());
        l.addFirst(3);
        assertEquals(3, l.get(0));
        assertEquals(2, l.get(1));
        assertEquals(1, l.get(2));
        assertEquals(3, l.getFirst());
        assertEquals(0, l.getLast());
        l.printList();
    }

    @Test
    public void testAddAtIndexZeroSize() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.addAtIndex(0, 0);
        assertEquals(0, l.getFirst());
        DoublyLinkedList<Integer> l2 = new DoublyLinkedList<>();
        l2.addAtIndex(1, 1);
        assertEquals(1, l2.getFirst());
        assertEquals(1, l2.getLast());
    }

    @Test
    public void testAddAtIndexOneSize() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.addAtIndex(0, 0);
        assertEquals(0, l.getFirst());
        l.addAtIndex(0, 1);
        assertEquals(1, l.getFirst());
        assertEquals(0, l.getLast());
        DoublyLinkedList<Integer> l2 = new DoublyLinkedList<>();
        l2.addAtIndex(0, 0);
        assertEquals(0, l2.getFirst());
        l2.addAtIndex(1, 1);
        assertEquals(0, l2.getFirst());
        assertEquals(1, l2.getLast());
    }

    @Test
    public void testAddAtIndexTwoSize() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.addAtIndex(0, 0);
        l.addAtIndex(1, 1);
        assertEquals(0, l.getFirst());
        assertEquals(1, l.getLast());
        l.addAtIndex(0, 2);
        assertEquals(2, l.getFirst());
        assertEquals(0, l.get(1));
        assertEquals(1, l.getLast());
        DoublyLinkedList<Integer> l2 = new DoublyLinkedList<>();
        l2.addAtIndex(0, 0);
        l2.addAtIndex(1, 1);
        assertEquals(0, l2.getFirst());
        assertEquals(1, l2.getLast());
        l2.addAtIndex(1, 2);
        assertEquals(0, l2.getFirst());
        assertEquals(2, l2.get(1));
        assertEquals(1, l2.getLast());
        DoublyLinkedList<Integer> l3 = new DoublyLinkedList<>();
        l3.addAtIndex(0, 0);
        l3.addAtIndex(1, 1);
        assertEquals(0, l3.getFirst());
        assertEquals(1, l3.getLast());
        l3.addAtIndex(2, 2);
        assertEquals(0, l3.getFirst());
        assertEquals(1, l3.get(1));
        assertEquals(2, l3.getLast());
    }

    @Test
    public void testAddAtIndexThreeSize() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.addAtIndex(0, 0);
        l.addAtIndex(1, 1);
        l.addAtIndex(2, 2);
        assertEquals(0, l.getFirst());
        assertEquals(2, l.getLast());
        assertEquals(1, l.get(1));
        l.addAtIndex(0, 3);
        assertEquals(3, l.getFirst());
        assertEquals(2, l.getLast());
        assertEquals(0, l.get(1));
        assertEquals(1, l.get(2));
        DoublyLinkedList<Integer> l2 = new DoublyLinkedList<>();
        l2.addAtIndex(0, 0);
        l2.addAtIndex(1, 1);
        l2.addAtIndex(2, 2);
        assertEquals(0, l2.getFirst());
        assertEquals(2, l2.getLast());
        assertEquals(1, l2.get(1));
        l2.addAtIndex(1, 3);
        assertEquals(0, l2.getFirst());
        assertEquals(2, l2.getLast());
        assertEquals(3, l2.get(1));
        assertEquals(1, l2.get(2));
        DoublyLinkedList<Integer> l3 = new DoublyLinkedList<>();
        l3.addAtIndex(0, 0);
        l3.addAtIndex(1, 1);
        l3.addAtIndex(2, 2);
        assertEquals(0, l3.getFirst());
        assertEquals(2, l3.getLast());
        assertEquals(1, l3.get(1));
        l3.addAtIndex(2, 3);
        assertEquals(0, l3.getFirst());
        assertEquals(2, l3.getLast());
        assertEquals(1, l3.get(1));
        assertEquals(3, l3.get(2));
    }

    @Test
    public void testRemoveZeroSize() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        assertThrows(NoSuchElementException.class, () -> l.remove(0));
    }

    @Test
    public void testRemoveOneSize() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        assertEquals(0, l.getFirst());
        l.remove(0);
        assertTrue(l.isEmtpy());
        DoublyLinkedList<Integer> l2 = new DoublyLinkedList<>();
        l2.add(0);
        assertEquals(0, l2.getFirst());
        l2.remove(1);
        assertEquals(0, l2.getFirst());
    }

    // [0,1] (0) (1) (...)
// [1,1] (1)
// [0,1,2] (0) (1) (2) (...)
// [1,1,2] (1)
// [2,1,1] (1)
// [1,1,1] (1)
    @Test
    public void testRemoveTwoSize() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        l.add(1);
        assertEquals(0, l.getFirst());
        assertEquals(1, l.getLast());
        l.remove(0);
        assertEquals(1, l.getFirst());
        assertEquals(1, l.getLast());
        DoublyLinkedList<Integer> l2 = new DoublyLinkedList<>();
        l2.add(0);
        l2.add(1);
        assertEquals(0, l2.getFirst());
        assertEquals(1, l2.getLast());
        l2.remove(1);
        assertEquals(0, l2.getFirst());
        assertEquals(0, l2.getLast());
    }

}
