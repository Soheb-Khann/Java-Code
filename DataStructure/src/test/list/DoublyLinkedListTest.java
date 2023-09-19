package test.list;

import main.list.DoublyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
        l.add(0, 0);
        assertEquals(0, l.getFirst());
        DoublyLinkedList<Integer> l2 = new DoublyLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> l2.add(1, 1));

    }

    @Test
    public void testAddAtIndexOneSize() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.add(0, 0);
        assertEquals(0, l.getFirst());
        l.add(0, 1);
        assertEquals(1, l.getFirst());
        assertEquals(0, l.getLast());
        DoublyLinkedList<Integer> l2 = new DoublyLinkedList<>();
        l2.add(0, 0);
        assertEquals(0, l2.getFirst());
        l2.add(1, 1);
        assertEquals(0, l2.getFirst());
        assertEquals(1, l2.getLast());
    }

    @Test
    public void testAddAtIndexTwoSize() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.add(0, 0);
        l.add(1, 1);
        assertEquals(0, l.getFirst());
        assertEquals(1, l.getLast());
        l.add(0, 2);
        assertEquals(2, l.getFirst());
        assertEquals(0, l.get(1));
        assertEquals(1, l.getLast());
        DoublyLinkedList<Integer> l2 = new DoublyLinkedList<>();
        l2.add(0, 0);
        l2.add(1, 1);
        assertEquals(0, l2.getFirst());
        assertEquals(1, l2.getLast());
        l2.add(1, 2);
        assertEquals(0, l2.getFirst());
        assertEquals(2, l2.get(1));
        assertEquals(1, l2.getLast());
        DoublyLinkedList<Integer> l3 = new DoublyLinkedList<>();
        l3.add(0, 0);
        l3.add(1, 1);
        assertEquals(0, l3.getFirst());
        assertEquals(1, l3.getLast());
        l3.add(2, 2);
        assertEquals(0, l3.getFirst());
        assertEquals(1, l3.get(1));
        assertEquals(2, l3.getLast());
    }

    @Test
    public void testAddAtIndexThreeSize() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.add(0, 0);
        l.add(1, 1);
        l.add(2, 2);
        assertEquals(0, l.getFirst());
        assertEquals(2, l.getLast());
        assertEquals(1, l.get(1));
        l.add(0, 3);
        assertEquals(3, l.getFirst());
        assertEquals(2, l.getLast());
        assertEquals(0, l.get(1));
        assertEquals(1, l.get(2));
        DoublyLinkedList<Integer> l2 = new DoublyLinkedList<>();
        l2.add(0, 0);
        l2.add(1, 1);
        l2.add(2, 2);
        assertEquals(0, l2.getFirst());
        assertEquals(2, l2.getLast());
        assertEquals(1, l2.get(1));
        l2.add(1, 3);
        assertEquals(0, l2.getFirst());
        assertEquals(2, l2.getLast());
        assertEquals(3, l2.get(1));
        assertEquals(1, l2.get(2));
        DoublyLinkedList<Integer> l3 = new DoublyLinkedList<>();
        l3.add(0, 0);
        l3.add(1, 1);
        l3.add(2, 2);
        assertEquals(0, l3.getFirst());
        assertEquals(2, l3.getLast());
        assertEquals(1, l3.get(1));
        l3.add(2, 3);
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

    // [0] (0), (1) (...)
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

    // [0,1] (0), (1) (...)
    // [1,1] (1)
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
        DoublyLinkedList<Integer> l3 = new DoublyLinkedList<>();
        l3.add(1);
        l3.add(1);
        assertEquals(1, l3.getFirst());
        assertEquals(1, l3.getLast());
        l3.remove(1);
        assertTrue(l3.isEmpty());
    }

    // [0,1,2] (0) (1) (2) (...)
    @Test
    public void testRemoveThreeSize() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        assertEquals(0, l.getFirst());
        assertEquals(1, l.get(1));
        assertEquals(2, l.getLast());
        l.remove(0);
        assertEquals(1, l.getFirst());
        assertEquals(2, l.getLast());
        assertEquals(2, l.size());
        DoublyLinkedList<Integer> l2 = new DoublyLinkedList<>();
        l2.add(0);
        l2.add(1);
        l2.add(2);
        assertEquals(0, l2.getFirst());
        assertEquals(1, l2.get(1));
        assertEquals(2, l2.getLast());
        l2.remove(1);
        assertEquals(0, l2.getFirst());
        assertEquals(2, l2.getLast());
        assertEquals(2, l2.size());
        DoublyLinkedList<Integer> l3 = new DoublyLinkedList<>();
        l3.add(0);
        l3.add(1);
        l3.add(2);
        assertEquals(0, l3.getFirst());
        assertEquals(1, l3.get(1));
        assertEquals(2, l3.getLast());
        l3.remove(2);
        assertEquals(0, l3.getFirst());
        assertEquals(1, l3.getLast());
        assertEquals(2, l3.size());

    }

    // [1,1,2] (1)
    // [2,1,1] (1)
    // [1,1,1] (1)
    @Test
    public void testRemoveThreeSizeDuplicates() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.add(1);
        l.add(1);
        l.add(2);
        assertEquals(1, l.getFirst());
        assertEquals(1, l.get(1));
        assertEquals(2, l.getLast());
        l.remove(1);
        assertEquals(2, l.getFirst());
        assertEquals(2, l.getLast());
        assertEquals(1, l.size());
        DoublyLinkedList<Integer> l2 = new DoublyLinkedList<>();
        l2.add(2);
        l2.add(1);
        l2.add(1);
        assertEquals(2, l2.getFirst());
        assertEquals(1, l2.get(1));
        assertEquals(1, l2.getLast());
        l2.remove(1);
        assertEquals(2, l2.getFirst());
        assertEquals(2, l2.getLast());
        assertEquals(1, l2.size());
        DoublyLinkedList<Integer> l3 = new DoublyLinkedList<>();
        l3.add(1);
        l3.add(1);
        l3.add(1);
        assertEquals(1, l3.getFirst());
        assertEquals(1, l3.get(1));
        assertEquals(1, l3.getLast());
        l3.remove(1);
        assertEquals(0, l3.size());
        assertTrue(l3.isEmpty());
    }

    // [] (...)
    @Test
    public void testRemoveAtIndexSizeZero() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> l.removeAtIndex(0));
    }

    //[0] (0) (...)
    @Test
    public void testRemoveAtIndexSizeOne() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        assertEquals(0, l.getFirst());
        assertEquals(0, l.getLast());
        l.removeAtIndex(0);
        assertTrue(l.isEmpty());
        assertEquals(0, l.size());
    }

    //[0,1] (0) (1) (...)
    @Test
    public void testRemoveAtIndexSizeTwo() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        l.add(1);
        assertEquals(0, l.getFirst());
        assertEquals(1, l.getLast());
        l.removeAtIndex(0);
        assertEquals(1, l.getFirst());
        assertEquals(1, l.getLast());
        DoublyLinkedList<Integer> l2 = new DoublyLinkedList<>();
        l2.add(0);
        l2.add(1);
        assertEquals(0, l2.getFirst());
        assertEquals(1, l2.getLast());
        l2.removeAtIndex(1);
        assertEquals(0, l2.getFirst());
        assertEquals(0, l2.getLast());
    }

    //[0,1,2] (0) (1) (2) (...)
    @Test
    public void testRemoveAtIndexSizeThree() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        assertEquals(0, l.getFirst());
        assertEquals(1, l.get(1));
        assertEquals(2, l.getLast());
        l.removeAtIndex(0);
        assertEquals(1, l.getFirst());
        assertEquals(2, l.getLast());
        DoublyLinkedList<Integer> l2 = new DoublyLinkedList<>();
        l2.add(0);
        l2.add(1);
        l2.add(2);
        assertEquals(0, l2.getFirst());
        assertEquals(1, l2.get(1));
        assertEquals(2, l2.getLast());
        l2.removeAtIndex(1);
        assertEquals(0, l2.getFirst());
        assertEquals(2, l2.getLast());
        DoublyLinkedList<Integer> l3 = new DoublyLinkedList<>();
        l3.add(0);
        l3.add(1);
        l3.add(2);
        assertEquals(0, l3.getFirst());
        assertEquals(1, l3.get(1));
        assertEquals(2, l3.getLast());
        l3.removeAtIndex(2);
        assertEquals(0, l3.getFirst());
        assertEquals(1, l3.getLast());
    }

    @Test
    public void testContainsZero() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        assertFalse(l.contains(1));
    }

    //[0] (0) (...)
    @Test
    public void testContainsSizeOne() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        assertEquals(0, l.getFirst());
        assertTrue(l.contains(0));
        assertFalse(l.contains(1));
    }
    // [0,1] (0) (1) (...)
    @Test
    public void testContainsSizeTwo() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        l.add(1);
        assertEquals(0, l.getFirst());
        assertEquals(1, l.getLast());
        assertTrue(l.contains(0));
        assertTrue(l.contains(1));
        assertFalse(l.contains(2));
    }
    // [0,1,2] (0) (1) (2) (...)
    @Test
    public void testContainsSizeThree() {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        assertEquals(0, l.getFirst());
        assertEquals(1, l.get(1));
        assertEquals(2, l.getLast());
        assertTrue(l.contains(0));
        assertTrue(l.contains(1));
        assertTrue(l.contains(2));
        assertFalse(l.contains(3));
    }

    @Test
    public void testToArray(){
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        System.out.println(Arrays.toString((l.toArray())));
    }
    @Test
    public void testToString(){
        DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        System.out.println(l.toString());
    }

}
