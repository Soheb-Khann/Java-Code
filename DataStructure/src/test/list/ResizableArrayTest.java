package test.list;
import main.list.ResizableArray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResizableArrayTest {
    @Test
    public void testResizableArray(){
        ResizableArray a = new ResizableArray(Integer.MAX_VALUE+1);
    }
    @Test
    public void testAdd_WithZeroSizeResizableArray() {
        ResizableArray list = new ResizableArray(0);
        list.add(1);
        assertEquals(1,list.get(0));
        assertEquals(1,list.size());
    }
    @Test
    public void testAddDoubleSize() {
        ResizableArray list = new ResizableArray(1);
        list.add(1);
        list.add(2);
        assertEquals(2,list.size());
        assertEquals(1,list.get(0));
        assertEquals(2,list.get(1));
    }
    @Test
    public void testAddNegative() {
        ResizableArray list = new ResizableArray(2);
        list.add(-1);
        assertEquals(-1,list.get(0));
    }
    @Test
    public void testAddMaxIntSize() {
        ResizableArray list = new ResizableArray(2 );
        long t1 = System.currentTimeMillis();
        System.out.println(t1);
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            try{
                list.add(Math.toIntExact(i));
            }catch (OutOfMemoryError e){
                System.out.println("Error : "+i);
                System.out.println(i*2>Integer.MAX_VALUE);
                break;
            }

        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }
    @Test
    public void testGet(){
        ResizableArray list = new ResizableArray(3);
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1,list.get(0));
        assertEquals(2,list.get(1));
        assertEquals(3,list.get(2));
    }
    /**
     * Check for exception when no elements are present in the array.
     */
    @Test
    public void testGetNoElements(){
        ResizableArray list = new ResizableArray(0);
        assertThrows(ArrayIndexOutOfBoundsException.class,
                ()->list.get(0));
    }
    @Test
    public void testSet() {
        ResizableArray list = new ResizableArray(2);
        list.add(5);
        list.add(15);
        list.set(1,3);
        assertEquals(3,list.get(1));
    }
    /**
     * Check for exception when no elements are present in the array.
     */
    @Test
    public void testSetNoElements() {
        ResizableArray list = new ResizableArray(4);
        assertThrows(ArrayIndexOutOfBoundsException.class,
                ()->list.set(0,3));
    }
    @Test
    public void testRemoveAtIndex(){
        ResizableArray list = new ResizableArray(2);
        list.add(5);
        list.add(1);
        assertEquals(1,list.removeAtIndex(1));
    }
    @Test
    public void testRemoveAtIndexOneElement(){
        ResizableArray list = new ResizableArray(1);
        list.add(1);
        assertEquals(1,list.removeAtIndex(0));
    }
    @Test
    public void testRemoveElement() {
        ResizableArray list = new ResizableArray(2);
        list.add(5);
        list.add(15);
        assertTrue(list.remove(5));
    }
    /**
     * Test for removing duplicates
     */
    @Test
    public void testRemoveElementDuplicates() {
        ResizableArray list = new ResizableArray(2);
        list.add(2);
        list.add(2);
        list.remove(2);
        assertTrue(list.isEmpty());
    }
    @Test
    public void testIndexOf() {
        ResizableArray list = new ResizableArray(2);
        list.add(5);
        list.add(15);
        assertEquals(1,list.indexOf(15));
    }
    @Test
    public void testContains(){
        ResizableArray list = new ResizableArray(2);
        list.add(4);
        list.add(3);
        assertTrue(list.contains(3));
    }
    @Test
    public void testLastIndexOf(){
        ResizableArray list = new ResizableArray(4);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        assertEquals(3,list.lastIndexOf(1));
    }
    @Test
    public void testAddAllSameSize(){
        ResizableArray a1 = new ResizableArray(3);
        ResizableArray a2 = new ResizableArray(3);
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a2.addAll(a1);
        assertEquals(1,a2.get(0));
        assertEquals(2,a2.get(1));
        assertEquals(3,a2.get(2));
    }
    /**
     * Original array capacity bigger than or equal to
     * the size of given array.
     */
    @Test
    public void testAddAllBigger(){
        ResizableArray a1 = new ResizableArray(4);
        ResizableArray a2 = new ResizableArray(2);
        a1.add(1);
        a2.addAll(a1);
        assertEquals(1,a2.size());
    }
    /**
     * Original array capacity smaller than
     * the size of given array.
     */
    @Test
    public void testAddAllSmaller(){
        ResizableArray a1 = new ResizableArray(2);
        ResizableArray a2 = new ResizableArray(4);
        a1.add(1);
        a1.add(2);
        a2.add(3);
        a2.add(4);
        a2.add(5);
        a2.addAll(a1);
        assertEquals(5,a2.size());
    }
    @Test
    public void testRemoveAll(){
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
    public void testRemoveAllSize(){
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
        assertEquals(2,a1.size());
    }
    @Test
    public void testRetainAll(){
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
    public void testRetainAllSize(){
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
        assertEquals(2,a1.size());
    }
    @Test
    public void testContainsAll(){
        ResizableArray a1 = new ResizableArray(5);
        ResizableArray a2 = new ResizableArray(5);
        a1.add(3);
        a1.add(2);
        a1.add(1);
        a1.add(4);
        /////////
        a2.add(3);
        a2.add(4);
        /////////
        assertTrue(a1.containsAll(a2));
    }
    @Test
    public void testToArray(){
        ResizableArray a1 = new ResizableArray(5);
        a1.add(3);
        a1.add(5);
        a1.add(4);
        a1.add(3);
        a1.add(2);
        int a[] = a1.toArray();
        assertEquals(4,a[2]);
    }
    @Test
    public void testEquals(){
        ResizableArray a1 = new ResizableArray(15);
        ResizableArray a2 = new ResizableArray(5);
        a1.add(1);
        a1.add(3);
        a1.add(4);
        a1.add(5);
        a1.add(2);
        /////////
        a2.add(1);
        a2.add(3);
        a2.add(4);
        a2.add(5);
        a2.add(2);
        /////////
        System.out.println(a1.equals(a2));
    }
    @Test
    public void testRemoveRange() {
        ResizableArray a1 = new ResizableArray(5);
        a1.add(2);
        a1.add(4);
        a1.add(1);
        a1.add(5);
        a1.removeRange(1,2);
        assertEquals(1, a1.get(1));
    }
    @Test
    public void testRemoveRangeSize() {
        ResizableArray a1 = new ResizableArray(5);
        a1.add(2);
        a1.add(4);
        a1.add(1);
        a1.add(5);
        a1.removeRange(1,2);
        assertEquals(3, a1.size());
    }
    @Test
    public void testAddRange(){
        ResizableArray a1 = new ResizableArray(5);
        a1.add(0);
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.addRange(1,3);
        assertEquals(6,a1.get(4));
    }
}