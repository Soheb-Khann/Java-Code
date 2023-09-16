package test.list;

import main.list.ResizableArray;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ResizableArrayTest {
    @Test
    public void testResizableArray() {
    }

    @Test
    public void testAdd_WithZeroSizeResizableArray() {
        ResizableArray list = new ResizableArray(0);
        list.add(1);
        assertEquals(1, list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    public void testAddDoubleSize() {
        ResizableArray list = new ResizableArray(1);
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    public void testAddNegative() {
        ResizableArray list = new ResizableArray(2);
        list.add(-1);
        assertEquals(-1, list.get(0));
    }

    @Test
    public void testAddMaxIntSize() {
        ResizableArray list = new ResizableArray(2);
        long t1 = System.currentTimeMillis();
        System.out.println(t1);
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            try {
                list.add(Math.toIntExact(i));
            } catch (OutOfMemoryError e) {
                System.out.println("Error : " + i);
                System.out.println(i * 2 >= Integer.MAX_VALUE);
                break;
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

    /**
     * Check for exception when no elements are present in the array.
     */
    @Test
    public void testGetNoElements() {
        ResizableArray list = new ResizableArray(0);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void testGetOne() {
        ResizableArray list = new ResizableArray(1);
        list.add(1);
        assertEquals(1, list.get(0));
    }

    @Test
    public void testGetLast() {
        ResizableArray list = new ResizableArray(1);
        list.add(1);
        list.add(2);
        assertEquals(2, list.get(1));
    }

    @Test
    public void testGetIndexLessThanZero() {
        ResizableArray list = new ResizableArray(4);
        list.add(1);
        list.add(1);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    public void testGetIndexEqualToWI() {
        ResizableArray list = new ResizableArray(4);
        list.add(1);
        list.add(1);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(2));
    }

    @Test
    public void testGetIndexMoreThanWI() {
        ResizableArray list = new ResizableArray(4);
        list.add(1);
        list.add(1);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(4));
    }

    @Test
    public void testSet() {

    }

    @Test
    public void testRemoveAtIndex() {
        ResizableArray a = new ResizableArray(3);
        a.add(1);
        a.add(2);
        a.add(3);
        assertEquals(a.removeAtIndex(0), 1);
    }

    @Test
    public void testRemoveAtIndexMoreThanWI() {
        ResizableArray a = new ResizableArray(3);
        a.add(1);
        a.add(2);
        a.add(3);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> a.removeAtIndex(3));
    }

    @Test
    public void testRemoveAtIndexLessThanZero() {
        ResizableArray a = new ResizableArray(3);
        a.add(1);
        a.add(2);
        a.add(3);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> a.removeAtIndex(-1));
    }

    @Test
    public void testRemove() {
        ResizableArray a = new ResizableArray(3);
        a.add(1);
        a.add(2);
        a.add(3);
        assertTrue(a.remove(1));
    }

    @Test
    public void testRemoveDuplicate() {
        ResizableArray a = new ResizableArray(3);
        a.add(1);
        a.add(2);
        a.add(1);
        assertTrue(a.remove(1));
        assertEquals(a.size(), 1);
    }

    @Test
    public void testRemoveNotPresent() {
        ResizableArray a = new ResizableArray(3);
        a.add(1);
        a.add(2);
        a.add(3);
        assertFalse(a.remove(4));
    }

    @Test
    public void testRemoveNegatives() {
        ResizableArray a = new ResizableArray(3);
        a.add(-1);
        a.add(2);
        a.add(-1);
        assertTrue(a.remove(-1));
    }

    @Test
    public void testLastIndexOf() {
        ResizableArray a = new ResizableArray(3);
        a.add(-1);
        a.add(2);
        a.add(-1);
        a.add(2);
        assertEquals(a.lastIndexOf(-1), 2);
    }

    @Test
    public void testAddAll() {
        ResizableArray d = new ResizableArray(2);
        ResizableArray s = new ResizableArray(2);
        d.add(1);
        d.add(2);
        s.add(3);
        s.add(4);
        d.addAll(s);
        assertEquals(3, d.get(2));
        assertEquals(4, d.get(3));
        assertEquals(4, d.size());
    }

    @Test
    public void testAddAllSameSize() {
        ResizableArray a1 = new ResizableArray(3);
        ResizableArray a2 = new ResizableArray(3);
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a2.addAll(a1);
        assertEquals(1, a2.get(0));
        assertEquals(2, a2.get(1));
        assertEquals(3, a2.get(2));
    }

    /**
     * Original array capacity bigger than or equal to
     * the size of given array.
     */
    @Test
    public void testAddAllBigger() {
        ResizableArray a1 = new ResizableArray(4);
        ResizableArray a2 = new ResizableArray(2);
        a1.add(1);
        a2.addAll(a1);
        assertEquals(1, a2.size());
    }

    /**
     * Original array capacity smaller than
     * the size of given array.
     */
    @Test
    public void testAddAllSmaller() {
        ResizableArray a1 = new ResizableArray(2);
        ResizableArray a2 = new ResizableArray(4);
        a1.add(1);
        a1.add(2);
        a2.add(3);
        a2.add(4);
        a2.add(5);
        a2.addAll(a1);
        assertEquals(5, a2.size());
    }

    @Test
    public void testRemoveAll() {
        ResizableArray a1 = new ResizableArray(4);
        ResizableArray a2 = new ResizableArray(2);
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        /////////
        a2.add(1);
        a2.add(3);
        /////////
        a1.removeAll(a2);
        assertFalse(a1.contains(1));
        assertFalse(a1.contains(3));
    }

    /**
     * Check for size shrink after removing
     */
    @Test
    public void testRemoveAllSize() {
        ResizableArray a1 = new ResizableArray(4);
        ResizableArray a2 = new ResizableArray(2);
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        /////////
        a2.add(1);
        a2.add(3);
        /////////
        a1.removeAll(a2);
        assertEquals(2, a1.size());
    }

    @Test
    public void testRetainAll() {
        ResizableArray a1 = new ResizableArray(5);
        ResizableArray a2 = new ResizableArray(5);
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        /////////
        a2.add(2);
        a2.add(4);
        /////////
        a1.retainAll(a2);
        for (int i = 0; i < a1.size(); i++) {
            System.out.println(a1.get(i));
        }
    }

    /**
     * Check for size shrink after removing elements
     */
    @Test
    public void testRetainAllSize() {
        ResizableArray a1 = new ResizableArray(5);
        ResizableArray a2 = new ResizableArray(5);
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        /////////
        a2.add(2);
        a2.add(4);
        /////////
        a1.retainAll(a2);
        assertEquals(2, a1.size());
    }

    @Test
    public void testContainsAll() {
        ResizableArray a1 = new ResizableArray(3);
        ResizableArray a2 = new ResizableArray(3);
        a1.add(1);
        a1.add(2);
        a1.add(3);
        /////////
        a2.add(3);
        a2.add(1);
        /////////
        assertTrue(a1.containsAll(a2));
    }

    @Test
    public void testContainsAllDuplicates() {
        ResizableArray a1 = new ResizableArray(3);
        ResizableArray a2 = new ResizableArray(3);
        a1.add(1);
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(3);
        /////////
        a2.add(3);
        a2.add(1);
        /////////
        assertTrue(a1.containsAll(a2));
    }

    @Test
    public void testContainsAllNegatives() {
        ResizableArray a1 = new ResizableArray(3);
        ResizableArray a2 = new ResizableArray(3);
        a1.add(-1);
        a1.add(-1);
        a1.add(2);
        a1.add(-3);
        a1.add(3);
        /////////
        a2.add(-3);
        a2.add(-1);
        /////////
        assertTrue(a1.containsAll(a2));
    }

    @Test
    public void testContainsAllEmptyList() {
        ResizableArray a1 = new ResizableArray(3);
        ResizableArray a2 = new ResizableArray(3);
        /////////
        /////////
        assertFalse(a1.containsAll(a2));
    }

    @Test
    public void testEquals(){
        ResizableArray a1 = new ResizableArray(3);
        ResizableArray a2 = new ResizableArray(3);
        a1.add(1);
        a1.add(2);
        a1.add(3);
        /////////
        a2.add(1);
        a2.add(2);
        a2.add(3);
        /////////
        assertTrue(a1.equals(a2));
    }

    @Test
    public void testRemoveRange(){
        ResizableArray a1 = new ResizableArray(3);
        a1.add(1);
        a1.add(2);
        a1.add(3);
        assertTrue(a1.removeRange(0,2));
        System.out.println(Arrays.toString(a1.toArray()));
    }

    @Test
    public void testRemoveRangeNegative(){
        ResizableArray a1 = new ResizableArray(3);
        a1.add(1);
        a1.add(2);
        a1.add(-3);
        assertTrue(a1.removeRange(0,2));
        System.out.println(Arrays.toString(a1.toArray()));
    }

    @Test
    public void testAddRange(){
        ResizableArray a1 = new ResizableArray(3);
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.addRange(0,2);
        assertEquals(6,a1.get(3));
    }

    @Test
    public void testAddRangeNegative(){
        ResizableArray a1 = new ResizableArray(3);
        a1.add(1);
        a1.add(-2);
        a1.add(3);
        a1.addRange(0,2);
        assertEquals(2,a1.get(3));
    }
    @Test
    public void testSubList() {
        ResizableArray a1 = new ResizableArray(5);
        a1.add(1);       // 0
        a1.add(2);      // 1
        a1.add(3);     // 2
        a1.add(4);    // 3
        a1.add(5);   // 4
        ResizableArray a2 = a1.subList(1, 3);
        assertEquals(3, a2.get(1));
    }

    @Test
    public void testSubListEqualIndices() {
        ResizableArray a1 = new ResizableArray(5);
        a1.add(1);       // 0
        a1.add(2);      // 1
        a1.add(3);     // 2
        ResizableArray a2 = a1.subList(1, 1);
        assertEquals("[]", Arrays.toString(a2.toArray()));
    }

    @Test
    public void testSubListInvalidIndices() {
        ResizableArray a1 = new ResizableArray(10);
        a1.add(1);       // 0
        a1.add(2);      // 1
        a1.add(3);     // 2
        a1.add(4);   // 4
        a1.add(5);  // 5
        assertThrows(IllegalArgumentException.class, () -> a1.subList(3, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> a1.subList(6, 8));
    }

    @Test
    public void testSubListBeginning() {
        ResizableArray a1 = new ResizableArray(5);
        a1.add(1);       // 0
        a1.add(2);      // 1
        a1.add(3);     // 2
        a1.add(4);    // 3
        a1.add(5);   // 4
        ResizableArray a2 = a1.subList(0, 2);
        System.out.printf(Arrays.toString(a2.toArray()));
    }

    @Test
    public void testSubListFullList() {
        ResizableArray a1 = new ResizableArray(5);
        a1.add(1);       // 0
        a1.add(2);      // 1
        a1.add(3);     // 2
        a1.add(4);    // 3
        a1.add(5);   // 4
        ResizableArray a2 = a1.subList(0, 5);
        System.out.printf(Arrays.toString(a2.toArray()));
    }

    @Test
    public void testSubListNegativeIndex() {
        ResizableArray a1 = new ResizableArray(5);
        a1.add(1);       // 0
        a1.add(2);      // 1
        a1.add(3);     // 2
        a1.add(4);    // 3
        a1.add(5);   // 4
        assertThrows(IndexOutOfBoundsException.class, () -> a1.subList(-1, 5));
    }
}
