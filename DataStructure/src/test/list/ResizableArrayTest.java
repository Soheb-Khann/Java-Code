package test.list;
import main.list.ResizableArray;
import org.junit.jupiter.api.Test;
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

    @Test
    public void testGet() {
        ResizableArray list = new ResizableArray(3);
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    /**
     * Check for exception when no elements are present in the array.
     */
    @Test
    public void testGetNoElements() {
        ResizableArray list = new ResizableArray(0);
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> list.get(0));
    }

    @Test
    public void testGetIndexlessthan0() {
        ResizableArray list = new ResizableArray(4);
        list.add(1);
        list.add(1);
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> list.get(-1));
    }

    @Test
    public void testGetIndexMoreThanWI() {
        ResizableArray list = new ResizableArray(4);
        list.add(1);
        list.add(1);
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> list.get(4));
    }
}