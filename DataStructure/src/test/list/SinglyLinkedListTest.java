package test.list;

import main.list.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {
    @Test
    public void testAdd() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        assertEquals(l.get(0), 0);
        assertEquals(l.get(1), 1);
        assertEquals(l.get(2), 2);
    }

    @Test
    public void testAddEmpty() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(1);
        assertEquals(l.get(0), 1);
    }

    @Test
    public void testAddFirst() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.addFirst(1);
        l.addFirst(2);
        assertEquals(2, l.getFirst());
    }

    @Test
    public void testAddLast() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.addFirst(1);
        l.add(2);
        assertEquals(2, l.getLast());

    }

    @Test
    public void testAddAtIndex() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.addAtIndex(0, 0);
        assertEquals(0, l.get(0));
    }

    @Test
    public void testAddAtIndexSizeOne() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(1);
        l.addAtIndex(1, 0);
        assertEquals(0, l.get(1));
    }

    @Test
    public void testAddAtIndexV2SizeOne() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(0);
        assertEquals(l.get(0), 0);
        l.addAtIndexV2(0, 1);
        assertEquals(l.get(0), 1);
        assertEquals(l.get(1), 0);
        SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
        l2.add(0);
        assertEquals(l2.get(0), 0);
        l2.addAtIndexV2(1, 1);
        assertEquals(l2.get(1), 1);
        assertEquals(l2.get(0), 0);
    }

    @Test
    public void testAddAtIndexV2SizeTwo() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(0);
        l.add(1);
        assertEquals(l.get(0), 0);
        assertEquals(l.get(1), 1);
        l.addAtIndexV2(0, 2);
        assertEquals(l.get(0), 2);
        assertEquals(l.get(1), 0);
        assertEquals(l.get(2), 1);
        SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
        l2.add(0);
        l2.add(1);
        assertEquals(l2.get(0), 0);
        assertEquals(l2.get(1), 1);
        l2.addAtIndexV2(1, 2);
        assertEquals(l2.get(0), 0);
        assertEquals(l2.get(1), 2);
        assertEquals(l2.get(2), 1);
        SinglyLinkedList<Integer> l3 = new SinglyLinkedList<>();
        l3.add(0);
        l3.add(1);
        assertEquals(l3.get(0), 0);
        assertEquals(l3.get(1), 1);
        l3.addAtIndexV2(2, 2);
        assertEquals(l3.get(0), 0);
        assertEquals(l3.get(1), 1);
        assertEquals(l3.get(2), 2);
    }

    @Test
    public void testAddAtIndexV2SizeThree() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        assertEquals(l.get(0), 0);
        assertEquals(l.get(1), 1);
        assertEquals(l.get(2), 2);
        l.addAtIndexV2(0, 3);
        assertEquals(l.get(0), 3);
        assertEquals(l.get(1), 0);
        assertEquals(l.get(2), 1);
        assertEquals(l.get(3), 2);
        SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
        l2.add(0);
        l2.add(1);
        l2.add(2);
        assertEquals(l2.get(0), 0);
        assertEquals(l2.get(1), 1);
        assertEquals(l2.get(2), 2);
        l2.addAtIndexV2(1, 3);
        assertEquals(l2.get(0), 0);
        assertEquals(l2.get(1), 3);
        assertEquals(l2.get(2), 1);
        assertEquals(l2.get(3), 2);
        SinglyLinkedList<Integer> l3 = new SinglyLinkedList<>();
        l3.add(0);
        l3.add(1);
        l3.add(2);
        assertEquals(l3.get(0), 0);
        assertEquals(l3.get(1), 1);
        assertEquals(l3.get(2), 2);
        l3.addAtIndexV2(2, 3);
        assertEquals(l3.get(0), 0);
        assertEquals(l3.get(1), 1);
        assertEquals(l3.get(2), 3);
        assertEquals(l3.get(3), 2);
        SinglyLinkedList<Integer> l4 = new SinglyLinkedList<>();
        l4.add(0);
        l4.add(1);
        l4.add(2);
        assertEquals(l4.get(0), 0);
        assertEquals(l4.get(1), 1);
        assertEquals(l4.get(2), 2);
        l4.addAtIndexV2(3, 3);
        assertEquals(l4.get(0), 0);
        assertEquals(l4.get(1), 1);
        assertEquals(l4.get(2), 2);
        assertEquals(l4.get(3), 3);
    }

    @Test
    public void testGet() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        assertEquals(l.get(0), 0);
        assertEquals(l.get(1), 1);
        assertEquals(l.get(2), 2);
    }

    @Test
    public void testGetFirst() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.addFirst(1);
        l.addFirst(2);
        l.addFirst(3);
        assertEquals(l.getFirst(), 3);
    }

    @Test
    public void testGetLast() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.addFirst(1);
        l.addFirst(2);
        l.addFirst(3);
        assertEquals(l.getLast(), 1);
    }

    @Test
    public void testSet() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        assertEquals(l.get(0), 0);
        assertEquals(l.get(1), 1);
        assertEquals(l.get(2), 2);
        l.set(0, 3);
        assertEquals(l.get(0), 3);
        l.set(1, 4);
        assertEquals(l.get(1), 4);
        l.set(2, 5);
        assertEquals(l.get(2), 5);
    }

    @Test
    public void testRemoveOne() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(0);
        assertEquals(l.get(0), 0);
        l.remove(0);
        assertTrue(l.isEmpty());
    }

    @Test
    public void testRemoveTwo() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(0);
        l.add(1);
        assertEquals(l.get(0), 0);
        assertEquals(l.get(1), 1);
        l.remove(0);
        assertEquals(l.get(0), 1);
        SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
        l2.add(0);
        l2.add(1);
        assertEquals(l2.get(0), 0);
        assertEquals(l2.get(1), 1);
        l2.remove(1);
        assertEquals(l2.get(0), 0);
        SinglyLinkedList<Integer> l3 = new SinglyLinkedList<>();
        l3.add(1);
        l3.add(1);
        assertEquals(l3.get(0), 1);
        assertEquals(l3.get(1), 1);
        l3.remove(1);
        assertTrue(l3.isEmpty());
    }

    @Test
    public void testRemoveThree() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        assertEquals(l.get(0), 0);
        assertEquals(l.get(1), 1);
        assertEquals(l.get(2), 2);
        l.remove(0);
        assertEquals(l.get(0), 1);
        assertEquals(l.get(1), 2);
        SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
        l2.add(0);
        l2.add(1);
        l2.add(2);
        assertEquals(l2.get(0), 0);
        assertEquals(l2.get(1), 1);
        assertEquals(l2.get(2), 2);
        l2.remove(1);
        assertEquals(l2.get(0), 0);
        assertEquals(l2.get(1), 2);
        SinglyLinkedList<Integer> l3 = new SinglyLinkedList<>();
        l3.add(0);
        l3.add(1);
        l3.add(2);
        assertEquals(l3.get(0), 0);
        assertEquals(l3.get(1), 1);
        assertEquals(l3.get(2), 2);
        l3.remove(2);
        assertEquals(l3.get(0), 0);
        assertEquals(l3.get(1), 1);
        SinglyLinkedList<Integer> l4 = new SinglyLinkedList<>();
        l4.add(1);
        l4.add(1);
        l4.add(2);
        assertEquals(l4.get(0), 1);
        assertEquals(l4.get(1), 1);
        assertEquals(l4.get(2), 2);
        l4.remove(1);
        assertEquals(l4.get(0), 2);
        SinglyLinkedList<Integer> l5 = new SinglyLinkedList<>();
        l5.add(1);
        l5.add(1);
        l5.add(1);
        assertEquals(l5.get(0), 1);
        assertEquals(l5.get(1), 1);
        assertEquals(l5.get(2), 1);
        l5.remove(1);
        assertTrue(l5.isEmpty());
    }

    @Test
    public void testRemoveAtIndexEmpty() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> l.removeAtIndex(0));
    }

    @Test
    public void testRemoveAtIndexSizeOne() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(0);
        assertEquals(0, l.get(0));
        l.removeAtIndex(0);
        assertTrue(l.isEmpty());
    }

    @Test
    public void testRemoveAtIndexSizeTwo() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(0);
        l.add(1);
        assertEquals(0, l.get(0));
        assertEquals(1, l.get(1));
        l.removeAtIndex(0);
        assertEquals(1, l.get(0));
        SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
        l2.add(0);
        l2.add(1);
        assertEquals(0, l2.get(0));
        l2.removeAtIndex(1);
        assertEquals(0, l2.get(0));
    }

    @Test
    public void testRemoveAtIndexSizeThree() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        assertEquals(0, l.get(0));
        assertEquals(1, l.get(1));
        assertEquals(2, l.get(2));
        l.removeAtIndex(0);
        assertEquals(1, l.get(0));
        assertEquals(2, l.get(1));
        SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
        l2.add(0);
        l2.add(1);
        l2.add(2);
        assertEquals(0, l2.get(0));
        assertEquals(1, l2.get(1));
        assertEquals(2, l2.get(2));
        l2.removeAtIndex(1);
        assertEquals(0, l2.get(0));
        assertEquals(2, l2.get(1));
        SinglyLinkedList<Integer> l3 = new SinglyLinkedList<>();
        l3.add(0);
        l3.add(1);
        l3.add(2);
        assertEquals(0, l3.get(0));
        assertEquals(1, l3.get(1));
        assertEquals(2, l3.get(2));
        l3.removeAtIndex(2);
        assertEquals(0, l3.get(0));
        assertEquals(1, l3.get(1));
    }

    @Test
    public void testContains() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        assertTrue(l.contains(3));
    }

    @Test
    public void testSize() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        assertEquals(3, l.size());

    }

    @Test
    public void testToArray() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        Object[] a = l.toArray();
        Iterator<Integer> il = l.iterator();
        int i = 0;
        while (il.hasNext()) {
            assertSame(a[i], il.next());
            i++;
        }
    }

    @Test
    public void testToString() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.addFirst(1);
        l.addFirst(2);
        l.addFirst(3);
        l.printList();
        String s = l.toString();
        System.out.println(s);
    }

    @Test
    public void testAddall() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(1);
        l.add(2);
        l.printList();
        SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
        l2.add(3);
        l2.add(4);
        l2.printList();
        l.addAll(l2);
        l.printList();
    }

    @Test
    public void testAddAllIndexZero() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(1);
        SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
        l2.add(2);
        l2.add(3);
        l.addAll(l2, 0);
        assertEquals(2, l.get(0));
        assertEquals(3, l.get(1));
    }

    @Test
    public void testAddAllIndexOne() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(1);
        SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
        l2.add(2);
        l2.add(3);
        l.addAll(l2, 1);
        assertEquals(1, l.get(0));
        assertEquals(2, l.get(1));
        assertEquals(3, l.get(2));
    }

    @Test
    public void testAddAllIndexLast() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(1);
        SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
        l2.add(2);
        l2.add(3);
        l.addAll(l2, 2);
        assertEquals(1, l.get(0));
        assertEquals(2, l.get(1));
        assertEquals(3, l.get(2));
    }

    @Test
    public void testRemoveRangeOneElement() {
        SinglyLinkedList<Integer> l = new SinglyLinkedList<>();
        l.add(1);
        SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
        l2.addAll(l);
        SinglyLinkedList<Integer> l3 = new SinglyLinkedList<>();
        l3.addAll(l);
        l.removeRange(0, 1);
        l2.removeRange(0, 2);
        l3.removeRange(1, 2);
        assertTrue(l.isEmpty());
        assertTrue(l2.isEmpty());
        assertFalse(l3.isEmpty());
    }

    @Test
    public void testRemoveRangeTwoElement() {
        SinglyLinkedList<Integer> l1 = new SinglyLinkedList<>();
        l1.add(1);
        l1.add(2);   // [ 1, 2 ]
        SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
        l2.add(1);
        l2.add(2);   // [ 1, 2 ]
        SinglyLinkedList<Integer> l3 = new SinglyLinkedList<>();
        l3.add(1);
        l3.add(2);   // [ 1, 2 ]
        SinglyLinkedList<Integer> l4 = new SinglyLinkedList<>();
        l4.add(1);
        l4.add(2);   // [ 1, 2 ]
        l1.removeRange(0, 1);
        l2.removeRange(0, 2);
        l3.removeRange(1, 2);
        l4.removeRange(1, 3);
        assertFalse(l1.isEmpty());
        assertEquals(2, l1.get(0));
        assertTrue(l2.isEmpty());
        assertFalse(l3.isEmpty());
        assertEquals(1, l3.get(0));
        assertFalse(l4.isEmpty());
        assertEquals(1, l4.get(0));
    }

    @Test
    public void testRemoveRangeThreeElement() {
        SinglyLinkedList<Integer> l1 = new SinglyLinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3); // [1, 2, 3]
        SinglyLinkedList<Integer> l2 = new SinglyLinkedList<>();
        l2.add(1);
        l2.add(2);
        l2.add(3); // [1, 2, 3]
        SinglyLinkedList<Integer> l3 = new SinglyLinkedList<>();
        l3.add(1);
        l3.add(2);
        l3.add(3); // [1, 2, 3]
        SinglyLinkedList<Integer> l4 = new SinglyLinkedList<>();
        l4.add(1);
        l4.add(2);
        l4.add(3); // [1, 2, 3]
        SinglyLinkedList<Integer> l5 = new SinglyLinkedList<>();
        l5.add(1);
        l5.add(2);
        l5.add(3); // [1, 2, 3]
        SinglyLinkedList<Integer> l6 = new SinglyLinkedList<>();
        l6.add(1);
        l6.add(2);
        l6.add(3); // [1, 2, 3]
        l1.removeRange(0, 1);
        l2.removeRange(0, 2);
        l3.removeRange(0, 3);
        l4.removeRange(1, 2);
        l5.removeRange(1, 3);
        l6.removeRange(2, 3);
        assertEquals(2, l1.get(0));
        assertEquals(3, l1.get(1));
        assertEquals(3, l2.get(0));
        assertTrue(l3.isEmpty());
        assertEquals(1, l4.get(0));
        assertEquals(3, l4.get(1));
        assertEquals(1, l5.get(0));
        assertEquals(1, l5.size());
        assertEquals(1, l6.get(0));
        assertEquals(2, l6.get(1));
    }

    @Test
    public void testSublistOneElement() {
        SinglyLinkedList<Integer> l1 = new SinglyLinkedList<>();
        l1.add(1);
        SinglyLinkedList<Integer> l2 = l1.subList(0, 1);
        assertEquals(1, l2.get(0));
        assertEquals(1, l2.size());
    }

    @Test
    public void testSublistTwoElement() {
        SinglyLinkedList<Integer> l1 = new SinglyLinkedList<>();
        l1.add(1);
        l1.add(2);
        SinglyLinkedList<Integer> l2 = l1.subList(0, 3);
        assertEquals(1, l2.get(0));
        assertEquals(2, l2.get(1));
        assertEquals(2, l2.size());
        SinglyLinkedList<Integer> l3 = l1.subList(1, 3);
        assertEquals(2, l3.get(0));
        assertEquals(1, l3.size());
    }

    @Test
    public void testSublistThreeElement() {
        SinglyLinkedList<Integer> l1 = new SinglyLinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        SinglyLinkedList<Integer> l2 = l1.subList(0, 2);
        assertEquals(1, l2.get(0));
        assertEquals(2, l2.get(1));
        assertEquals(2, l2.size());
        SinglyLinkedList<Integer> l3 = l1.subList(1, 3);
        assertEquals(2, l3.get(0));
        assertEquals(3, l3.get(1));
        assertEquals(2, l3.size());
        SinglyLinkedList<Integer> l4 = l1.subList(2, 3);
        assertEquals(3, l4.get(0));
        assertEquals(1, l4.size());
    }

}
