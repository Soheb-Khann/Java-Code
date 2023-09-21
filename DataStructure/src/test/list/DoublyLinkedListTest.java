package test.list;

import main.list.DoublyLinkedList;
import main.list.List;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {

    @Test
    public void testAddZeroSize() {
        List<Integer> l = new DoublyLinkedList<>();
        assertTrue(l.isEmpty());
        l.add(0);
        assertEquals(0, l.get(0));
        assertTrue(l.getFirst() == l.getLast());
        l.printList();
    }

    @Test
    public void testAddOneSize() {
        List<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        assertEquals(0, l.get(0));
        l.add(1);
        assertEquals(0, l.get(0));
        assertEquals(1, l.get(1));
        l.printList();
    }

    @Test
    public void testAddTwoSize() {
        List<Integer> l = new DoublyLinkedList<>();
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
        List<Integer> l = new DoublyLinkedList<>();
        assertTrue(l.isEmpty());
        l.addFirst(0);
        assertEquals(0, l.get(0));
        assertEquals(0, l.getFirst());
        assertEquals(0, l.getLast());
        l.printList();
    }

    @Test
    public void testAddFirstOneSize() {
        List<Integer> l = new DoublyLinkedList<>();
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
        List<Integer> l = new DoublyLinkedList<>();
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
        List<Integer> l = new DoublyLinkedList<>();
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
        List<Integer> l = new DoublyLinkedList<>();
        l.add(0, 0);
        assertEquals(0, l.getFirst());
        List<Integer> l2 = new DoublyLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> l2.add(1, 1));

    }

    @Test
    public void testAddAtIndexOneSize() {
        List<Integer> l = new DoublyLinkedList<>();
        l.add(0, 0);
        assertEquals(0, l.getFirst());
        l.add(0, 1);
        assertEquals(1, l.getFirst());
        assertEquals(0, l.getLast());
        List<Integer> l2 = new DoublyLinkedList<>();
        l2.add(0, 0);
        assertEquals(0, l2.getFirst());
        l2.add(1, 1);
        assertEquals(0, l2.getFirst());
        assertEquals(1, l2.getLast());
    }

    @Test
    public void testAddAtIndexTwoSize() {
        List<Integer> l = new DoublyLinkedList<>();
        l.add(0, 0);
        l.add(1, 1);
        assertEquals(0, l.getFirst());
        assertEquals(1, l.getLast());
        l.add(0, 2);
        assertEquals(2, l.getFirst());
        assertEquals(0, l.get(1));
        assertEquals(1, l.getLast());
        List<Integer> l2 = new DoublyLinkedList<>();
        l2.add(0, 0);
        l2.add(1, 1);
        assertEquals(0, l2.getFirst());
        assertEquals(1, l2.getLast());
        l2.add(1, 2);
        assertEquals(0, l2.getFirst());
        assertEquals(2, l2.get(1));
        assertEquals(1, l2.getLast());
        List<Integer> l3 = new DoublyLinkedList<>();
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
        List<Integer> l = new DoublyLinkedList<>();
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
        List<Integer> l2 = new DoublyLinkedList<>();
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
        List<Integer> l3 = new DoublyLinkedList<>();
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

    //[] []
    @Test
    public void testAddAllZeroSize() {
        List<Integer> l = new DoublyLinkedList<>();
        List<Integer> l2 = new DoublyLinkedList<>();
        assertTrue(l.addAll(l2));

    }

    //[0] [], [] [0], [0] [0]
    @Test
    public void testAddAllOneSize() {
        List<Integer> l = new DoublyLinkedList<>();
        List<Integer> l2 = new DoublyLinkedList<>();
        l.add(0);
        l.addAll(l2);
        assertEquals(0, l.getFirst());
        assertEquals(1, l.size());
        List<Integer> l3 = new DoublyLinkedList<>();
        List<Integer> l4 = new DoublyLinkedList<>();
        l4.add(0);
        l3.addAll(l4);
        assertEquals(0, l3.getFirst());
        assertEquals(1, l4.size());
    }

    // [0,1] [2,3], [0] [1,2], [0,1] [2]
    @Test
    public void testAddAllTwoSize() {
        List<Integer> l1 = new DoublyLinkedList<>();
        List<Integer> l2 = new DoublyLinkedList<>();
        l1.add(0);
        l1.add(1);
        l2.add(2);
        l2.add(3);
        assertEquals(0, l1.getFirst());
        assertEquals(1, l1.getLast());
        assertEquals(2, l2.getFirst());
        assertEquals(3, l2.getLast());
        assertTrue(l1.addAll(l2));
        assertEquals(0, l1.getFirst());
        assertEquals(1, l1.get(1));
        assertEquals(2, l1.get(2));
        assertEquals(3, l1.getLast());
        List<Integer> l3 = new DoublyLinkedList<>();
        List<Integer> l4 = new DoublyLinkedList<>();
        l3.add(0);
        l4.add(2);
        l4.add(3);
        assertEquals(0, l3.getFirst());
        assertEquals(0, l3.getLast());
        assertEquals(2, l4.getFirst());
        assertEquals(3, l4.getLast());
        assertTrue(l3.addAll(l4));
        assertEquals(0, l3.getFirst());
        assertEquals(2, l3.get(1));
        assertEquals(3, l3.getLast());
        List<Integer> l5 = new DoublyLinkedList<>();
        List<Integer> l6 = new DoublyLinkedList<>();
        l5.add(0);
        l5.add(1);
        l6.add(2);
        assertEquals(0, l5.getFirst());
        assertEquals(1, l5.getLast());
        assertEquals(2, l6.getFirst());
        assertEquals(2, l6.getLast());
        assertTrue(l5.addAll(l6));
        assertEquals(0, l5.getFirst());
        assertEquals(1, l5.get(1));
        assertEquals(2, l5.getLast());
    }

    // [] [] (...), [0] [] (0), [] [0] (...), [0] [0] (0)
    @Test
    public void testAddAllAtIndexSizeOne() {
        List<Integer> l1 = new DoublyLinkedList<>();
        List<Integer> l2 = new DoublyLinkedList<>();
        assertTrue(l1.addAll(0, l2));
        List<Integer> l3 = new DoublyLinkedList<>();
        List<Integer> l4 = new DoublyLinkedList<>();
        l3.add(0);
        assertTrue(l3.addAll(0, l4));
        List<Integer> l5 = new DoublyLinkedList<>();
        List<Integer> l6 = new DoublyLinkedList<>();
        l6.add(1);
        assertTrue(l5.addAll(0, l6));
        List<Integer> l7 = new DoublyLinkedList<>();
        List<Integer> l8 = new DoublyLinkedList<>();
        l7.add(0);
        l8.add(1);
        assertTrue(l7.addAll(0, l8));
        assertEquals(1, l7.getFirst());
        assertEquals(0, l7.getLast());
    }

    // [0,1] [2] (0), [0,1] [2] (1), [0] [1,2] (0), [0] [1,2] (1), [0,1] [2,3] (0), [0,1] [2,3] (1)
    @Test
    public void testAddAllAtIndexSizeTwo() {
        List<Integer> l1 = new DoublyLinkedList<>();
        List<Integer> l2 = new DoublyLinkedList<>();
        l1.add(0);
        l1.add(1);
        l2.add(2);
        assertEquals(0, l1.getFirst());
        assertEquals(1, l1.getLast());
        assertEquals(2, l2.getFirst(), l1.getLast());
        assertTrue(l1.addAll(0, l2));
        assertEquals(2, l1.getFirst());
        assertEquals(0, l1.get(1));
        assertEquals(1, l1.getLast());
        List<Integer> l3 = new DoublyLinkedList<>();
        List<Integer> l4 = new DoublyLinkedList<>();
        l3.add(0);
        l3.add(1);
        l4.add(2);
        assertEquals(0, l3.getFirst());
        assertEquals(1, l3.getLast());
        assertEquals(2, l4.getFirst(), l3.getLast());
        assertTrue(l3.addAll(1, l4));
        assertEquals(0, l3.getFirst());
        assertEquals(2, l3.get(1));
        assertEquals(1, l3.getLast());
        List<Integer> l5 = new DoublyLinkedList<>();
        List<Integer> l6 = new DoublyLinkedList<>();
        l5.add(0);
        l6.add(1);
        l6.add(2);
        assertEquals(0, l5.getFirst(), l5.getLast());
        assertEquals(1, l6.getFirst());
        assertEquals(2, l6.getLast());
        assertTrue(l5.addAll(0, l6));
        assertEquals(1, l5.getFirst());
        assertEquals(2, l5.get(1));
        assertEquals(0, l5.getLast());
        List<Integer> l7 = new DoublyLinkedList<>();
        List<Integer> l8 = new DoublyLinkedList<>();
        l7.add(0);
        l8.add(1);
        l8.add(2);
        assertEquals(0, l7.getFirst(), l7.getLast());
        assertEquals(1, l8.getFirst());
        assertEquals(2, l8.getLast());
        assertTrue(l7.addAll(1, l8));
        assertEquals(0, l7.getFirst());
        assertEquals(1, l7.get(1));
        assertEquals(2, l7.getLast());
        List<Integer> l9 = new DoublyLinkedList<>();
        List<Integer> l10 = new DoublyLinkedList<>();
        l9.add(0);
        l9.add(1);
        l10.add(2);
        l10.add(3);
        assertEquals(0, l9.getFirst());
        assertEquals(1, l9.getLast());
        assertEquals(2, l10.getFirst());
        assertEquals(3, l10.getLast());
        assertTrue(l9.addAll(0, l10));
        assertEquals(2, l9.getFirst());
        assertEquals(3, l9.get(1));
        assertEquals(0, l9.get(2));
        assertEquals(1, l9.getLast());
        List<Integer> l11 = new DoublyLinkedList<>();
        List<Integer> l12 = new DoublyLinkedList<>();
        l11.add(0);
        l11.add(1);
        l12.add(2);
        l12.add(3);
        assertEquals(0, l11.getFirst());
        assertEquals(1, l11.getLast());
        assertEquals(2, l12.getFirst());
        assertEquals(3, l12.getLast());
        assertTrue(l11.addAll(1, l12));
        assertEquals(0, l11.getFirst());
        assertEquals(2, l11.get(1));
        assertEquals(3, l11.get(2));
        assertEquals(1, l11.getLast());
        List<Integer> l13 = new DoublyLinkedList<>();
        List<Integer> l14 = new DoublyLinkedList<>();
        l13.add(0);
        l13.add(1);
        l14.add(2);
        l14.add(3);
        assertEquals(0, l13.getFirst());
        assertEquals(1, l13.getLast());
        assertEquals(2, l14.getFirst());
        assertEquals(3, l14.getLast());
        assertTrue(l13.addAll(2, l14));
        assertEquals(0, l13.getFirst());
        assertEquals(1, l13.get(1));
        assertEquals(2, l13.get(2));
        assertEquals(3, l13.getLast());
    }

    @Test
    public void testRemoveZeroSize() {
        List<Integer> l = new DoublyLinkedList<>();
        assertThrows(NoSuchElementException.class, () -> l.remove(0));
    }

    // [0] (0), (1) (...)
    @Test
    public void testRemoveOneSize() {
        List<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        assertEquals(0, l.getFirst());
        l.remove(0);
        assertTrue(l.isEmpty());
        List<Integer> l2 = new DoublyLinkedList<>();
        l2.add(0);
        assertEquals(0, l2.getFirst());
        l2.remove(1);
        assertEquals(0, l2.getFirst());
    }

    // [0,1] (0), (1) (...)
    // [1,1] (1)
    @Test
    public void testRemoveTwoSize() {
        List<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        l.add(1);
        assertEquals(0, l.getFirst());
        assertEquals(1, l.getLast());
        l.remove(0);
        assertEquals(1, l.getFirst());
        assertEquals(1, l.getLast());
        List<Integer> l2 = new DoublyLinkedList<>();
        l2.add(0);
        l2.add(1);
        assertEquals(0, l2.getFirst());
        assertEquals(1, l2.getLast());
        l2.remove(1);
        assertEquals(0, l2.getFirst());
        assertEquals(0, l2.getLast());
        List<Integer> l3 = new DoublyLinkedList<>();
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
        List<Integer> l = new DoublyLinkedList<>();
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
        List<Integer> l2 = new DoublyLinkedList<>();
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
        List<Integer> l3 = new DoublyLinkedList<>();
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
        List<Integer> l = new DoublyLinkedList<>();
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
        List<Integer> l2 = new DoublyLinkedList<>();
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
        List<Integer> l3 = new DoublyLinkedList<>();
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
        List<Integer> l = new DoublyLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> l.removeAtIndex(0));
    }

    //[0] (0) (...)
    @Test
    public void testRemoveAtIndexSizeOne() {
        List<Integer> l = new DoublyLinkedList<>();
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
        List<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        l.add(1);
        assertEquals(0, l.getFirst());
        assertEquals(1, l.getLast());
        l.removeAtIndex(0);
        assertEquals(1, l.getFirst());
        assertEquals(1, l.getLast());
        List<Integer> l2 = new DoublyLinkedList<>();
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
        List<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        assertEquals(0, l.getFirst());
        assertEquals(1, l.get(1));
        assertEquals(2, l.getLast());
        l.removeAtIndex(0);
        assertEquals(1, l.getFirst());
        assertEquals(2, l.getLast());
        List<Integer> l2 = new DoublyLinkedList<>();
        l2.add(0);
        l2.add(1);
        l2.add(2);
        assertEquals(0, l2.getFirst());
        assertEquals(1, l2.get(1));
        assertEquals(2, l2.getLast());
        l2.removeAtIndex(1);
        assertEquals(0, l2.getFirst());
        assertEquals(2, l2.getLast());
        List<Integer> l3 = new DoublyLinkedList<>();
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

    // [0] [1], [1] [1], [] [0]
    @Test
    public void testRemoveAllSizeOne() {
        List<Integer> l1 = new DoublyLinkedList<>();
        List<Integer> l2 = new DoublyLinkedList<>();
        l1.add(0);
        l2.add(1);
        assertTrue(l1.removeAll(l2));
        assertEquals(0, l1.getFirst(), l1.getLast());
        assertEquals(1, l2.getFirst(), l2.getLast());
        List<Integer> l3 = new DoublyLinkedList<>();
        List<Integer> l4 = new DoublyLinkedList<>();
        l3.add(1);
        l4.add(1);
        assertTrue(l3.removeAll(l4));
        assertTrue(l3.isEmpty());
        List<Integer> l5 = new DoublyLinkedList<>();
        List<Integer> l6 = new DoublyLinkedList<>();
        l6.add(0);
        assertTrue(l5.removeAll(l6));
        assertTrue(l5.isEmpty());
    }

    // [0] [1,1], [0] [0,1], [0,1] [0], [0,1] [1], [0,1] [0,1]
    @Test
    public void testRemoveAllSizeTwo() {
        List<Integer> l1 = new DoublyLinkedList<>();
        List<Integer> l2 = new DoublyLinkedList<>();
        l1.add(0);
        l2.add(1);
        l2.add(1);
        l1.removeAll(l2);
        assertEquals(0, l1.getFirst(), l1.getLast());
        List<Integer> l3 = new DoublyLinkedList<>();
        List<Integer> l4 = new DoublyLinkedList<>();
        l3.add(0);
        l4.add(0);
        l4.add(1);
        l3.removeAll(l4);
        assertTrue(l3.isEmpty());
        List<Integer> l5 = new DoublyLinkedList<>();
        List<Integer> l6 = new DoublyLinkedList<>();
        l5.add(0);
        l5.add(1);
        l6.add(0);
        l5.removeAll(l6);
        assertEquals(1, l5.getFirst(), l5.getLast());
        List<Integer> l7 = new DoublyLinkedList<>();
        List<Integer> l8 = new DoublyLinkedList<>();
        l7.add(0);
        l7.add(1);
        l8.add(1);
        l7.removeAll(l8);
        assertEquals(0, l7.getFirst(), l7.getLast());
        List<Integer> l9 = new DoublyLinkedList<>();
        List<Integer> l10 = new DoublyLinkedList<>();
        l9.add(0);
        l9.add(1);
        l10.add(0);
        l10.add(1);
        l9.removeAll(l10);
        assertTrue(l9.isEmpty());
    }

    // [] [0], [0] [], [0] [0], [0] [1]
    @Test
    public void testRetainAllSizeOne() {
        List<Integer> l1 = new DoublyLinkedList<>();
        List<Integer> l2 = new DoublyLinkedList<>();
        l2.add(0);
        assertTrue(l1.retainAll(l2));
        List<Integer> l3 = new DoublyLinkedList<>();
        List<Integer> l4 = new DoublyLinkedList<>();
        l3.add(0);
        assertTrue(l3.retainAll(l4));
        List<Integer> l5 = new DoublyLinkedList<>();
        List<Integer> l6 = new DoublyLinkedList<>();
        l5.add(0);
        l6.add(0);
        assertTrue(l5.retainAll(l6));
        assertEquals(0, l5.getFirst(), l5.getLast());
        List<Integer> l7 = new DoublyLinkedList<>();
        List<Integer> l8 = new DoublyLinkedList<>();
        l7.add(0);
        l8.add(1);
        assertTrue(l7.retainAll(l8));
        assertEquals(0, l7.getFirst(), l7.getLast());
    }

    @Test
    public void testContainsSizeZero() {
        List<Integer> l = new DoublyLinkedList<>();
        assertFalse(l.contains(1));
    }

    //[0] (0) (...)
    @Test
    public void testContainsSizeOne() {
        List<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        assertEquals(0, l.getFirst());
        assertTrue(l.contains(0));
        assertFalse(l.contains(1));
    }

    // [0,1] (0) (1) (...)
    @Test
    public void testContainsSizeTwo() {
        List<Integer> l = new DoublyLinkedList<>();
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
        List<Integer> l = new DoublyLinkedList<>();
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

    // [0] [], [] [0] , [0] [0]
    @Test
    public void testContainsAllSizeOne() {
        List<Integer> l = new DoublyLinkedList<>();
        List<Integer> l2 = new DoublyLinkedList<>();
        l.add(0);
        assertTrue(l.containsAll(l2));
        List<Integer> l3 = new DoublyLinkedList<>();
        List<Integer> l4 = new DoublyLinkedList<>();
        l4.add(0);
        assertFalse(l3.containsAll(l4));
        List<Integer> l5 = new DoublyLinkedList<>();
        List<Integer> l6 = new DoublyLinkedList<>();
        l5.add(0);
        l6.add(0);
        assertTrue(l5.containsAll(l6));
    }

    // [0] [1,2], [0] [0,0], [0] [0,1], [1,2] [0], [1,2] [1], [1,2] [2]
    @Test
    public void testContainsAllTwoOne() {
        List<Integer> l1 = new DoublyLinkedList<>();
        List<Integer> l2 = new DoublyLinkedList<>();
        l1.add(0);
        l2.add(1);
        l2.add(2);
        assertFalse(l1.containsAll(l2));
        List<Integer> l3 = new DoublyLinkedList<>();
        List<Integer> l4 = new DoublyLinkedList<>();
        l3.add(0);
        l4.add(0);
        l4.add(0);
        assertTrue(l3.containsAll(l4));
        List<Integer> l5 = new DoublyLinkedList<>();
        List<Integer> l6 = new DoublyLinkedList<>();
        l5.add(0);
        l6.add(0);
        l6.add(1);
        assertFalse(l5.containsAll(l6));
        List<Integer> l7 = new DoublyLinkedList<>();
        List<Integer> l8 = new DoublyLinkedList<>();
        l7.add(1);
        l7.add(2);
        l8.add(0);
        assertFalse(l7.containsAll(l8));
        List<Integer> l9 = new DoublyLinkedList<>();
        List<Integer> l10 = new DoublyLinkedList<>();
        l9.add(1);
        l9.add(2);
        l10.add(1);
        assertTrue(l9.containsAll(l10));
        List<Integer> l11 = new DoublyLinkedList<>();
        List<Integer> l12 = new DoublyLinkedList<>();
        l11.add(1);
        l11.add(2);
        l12.add(2);
        assertTrue(l11.containsAll(l12));
    }

    // [0], [0,1], [0,1,2]
    @Test
    public void testSubList() {
        List<Integer> l1 = new DoublyLinkedList<>();
        l1.add(0);
        List<Integer> l2 = l1.sublist(0, 1);
        assertEquals(0, l2.getFirst(), l2.getLast());
        List<Integer> l3 = new DoublyLinkedList<>();
        l3.add(0);
        l3.add(1);
        List<Integer> l4 = l3.sublist(0, 1);
        assertEquals(0, l4.getFirst(), l4.getLast());
        List<Integer> l5 = new DoublyLinkedList<>();
        l5.add(0);
        l5.add(1);
        List<Integer> l6 = l5.sublist(0, 2);
        assertEquals(0, l6.getFirst());
        assertEquals(1, l6.getLast());
        List<Integer> l7 = new DoublyLinkedList<>();
        l7.add(0);
        l7.add(1);
        List<Integer> l8 = l7.sublist(1, 2);
        assertEquals(1, l8.getFirst());
        assertEquals(1, l8.getLast());
        List<Integer> l9 = new DoublyLinkedList<>();
        l9.add(0);
        l9.add(1);
        l9.add(2);
        List<Integer> l10 = l9.sublist(0, 3);
        assertEquals(0, l10.getFirst());
        assertEquals(1, l10.get(1));
        assertEquals(2, l10.getLast());
        List<Integer> l11 = new DoublyLinkedList<>();
        l11.add(0);
        l11.add(1);
        l11.add(2);
        List<Integer> l12 = l11.sublist(1, 3);
        assertEquals(1, l12.getFirst());
        assertEquals(2, l12.getLast());
        List<Integer> l13 = new DoublyLinkedList<>();
        l13.add(0);
        l13.add(1);
        l13.add(2);
        List<Integer> l14 = l13.sublist(2, 3);
        assertEquals(2, l14.getFirst());
        assertEquals(2, l14.getLast());
    }

    // [] (...), [1] (1) (...), [0,1] (0) (1) (...), [0,0] (0), (1)
    @Test
    public void testLastIndexOfSizeOne() {
        List<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        l.add(0);
        assertEquals(1, l.lastIndexOf(0));
    }

    @Test
    public void testToArray() {
        List<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        System.out.println(Arrays.toString((l.toArray())));
    }

    @Test
    public void testToString() {
        List<Integer> l = new DoublyLinkedList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        System.out.println(l.toString());
    }


}
