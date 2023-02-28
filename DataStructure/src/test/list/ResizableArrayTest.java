package test.list;
import main.list.ResizableArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResizableArrayTest {
    /**
     * Make an array of size 0.
     */
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
    public void testAdd() {
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
    @Test
    public void testAddAllOneBigger(){
        ResizableArray a1 = new ResizableArray(4);
        ResizableArray a2 = new ResizableArray(2);
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        a2.addAll(a1);
        assertEquals(1,a2.get(0));
        assertEquals(2,a2.get(1));
        assertEquals(3,a2.get(2));
        assertEquals(4,a2.get(3));
    }
    @Test
    public void testAddAllBothBiggerThanLength(){
        ResizableArray a1 = new ResizableArray(2);
        ResizableArray a2 = new ResizableArray(2);
        a1.add(1);
        a1.add(2);
        a2.add(3);
        a2.add(4);
        a2.addAll(a1);
        assertEquals(3,a2.get(0));
        assertEquals(4,a2.get(1));
        assertEquals(1,a2.get(2));
        assertEquals(2,a2.get(3));
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
    @Test
    public void testRetainAll(){
        ResizableArray a1 = new ResizableArray(5);
        ResizableArray a2 = new ResizableArray(5);
        a1.add(1);
        a1.add(2);
        a1.add(2);
        a1.add(4);
        a1.add(4);
        a1.add(4);
        a1.add(0);
        a1.add(7);
        a1.add(8);
        a1.add(9);
        /////////
        a2.add(1);
        a2.add(2);
        a2.add(3);
        a2.add(4);
        /////////
        a1.retainAll(a2);
        for (int i = 0; i < a1.size(); i++) {
            System.out.println(a1.get(i));
        }

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
        ResizableArray a1 = new ResizableArray(5);
        ResizableArray a2 = new ResizableArray(5);
        a1.add(1);
        a1.add(3);
        a1.add(4);
        a1.add(5);
        a1.add(2);
        /////////
        a2.add(1);
        a2.add(4);
        a2.add(5);
        a2.add(2);
        a2.add(3);
        a2.add(4);
        a2.add(5);
        /////////
        System.out.println(a1.equals(a2));
    }

    @Test
    public void TestRemoveRange() {
        ResizableArray a1 = new ResizableArray(5);
        a1.add(2);
        a1.add(4);
        a1.add(1);
        a1.add(5);
        a1.removeRange(1,8);

    }

}