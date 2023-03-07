package test.list;
import main.list.ResizableArray;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.*;

public class ResizableArrayTest {
    @Test
    public void testResizableArray() {
        ResizableArray a = new ResizableArray();
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
                System.out.println(i * 2 > Integer.MAX_VALUE);
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
    public void testGetFirst() {
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
    public void testSetNegative() {
        ResizableArray list = new ResizableArray(0);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.set(-1,1));
    }
    @Test
    public void testSetNoElementsOrSetEqualToWI() {
        ResizableArray list = new ResizableArray(0);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.set(0,4));
    }
    @Test
    public void testSetMoreThanWI() {
        ResizableArray list = new ResizableArray();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.set(4,1));
    }
    @Test
    public void testSetFirstIndex() {
        ResizableArray list = new ResizableArray(2);
        list.add(1);
        list.set(0,2);
        assertEquals(2,list.get(0));
    }
    @Test
    public void testSetLastIndex() {
        ResizableArray list = new ResizableArray(2);
        list.add(1);
        list.add(2);
        list.set(1,3);
        assertEquals(3,list.get(1));
    }
    @Test
    public void testSetMiddleIndex() {
        ResizableArray list = new ResizableArray(2);
        list.add(1);
        list.add(5);
        list.add(2);
        list.set(1,3);
        assertEquals(3,list.get(1));
    }
}