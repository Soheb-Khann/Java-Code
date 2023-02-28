package test.list;
import main.list.ResizableArray;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        list.get(0);
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
        list.set(0,3);
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
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    @Test
    public void testFind() {
        ResizableArray list = new ResizableArray();
        list.add(5);
        list.add(15);
        list.add(14);
        list.add(17);
        list.add(10);
        assertEquals(3,list.indexOf(17));
    }
    @Test
    public void testContains(){
        ResizableArray list = new ResizableArray();
        list.add(4);
        list.add(3);
        list.add(2);
        if (list.contains(3)){
            assertEquals(0,0);
        }
        else
            assertEquals(0,1);

    }
    @Test
    public void testLastIndexOf(){
        ResizableArray list = new ResizableArray();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(8);
        list.add(9);
        list.add(5);
        list.add(1);
        assertEquals(7,list.lastIndexOf(5));
    }
    @Test
    public void testAddAll(){
        ResizableArray a1 = new ResizableArray(5);
        ResizableArray a2 = new ResizableArray(16);
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        a1.add(5);
        /////////
        a2.add(6);
        a2.add(6);
        a2.add(6);
        a2.add(6);
        a2.add(6);
        a2.add(7);
        a2.add(8);
        a2.add(9);
        a2.add(10);
        a1.addAll(a2);

    }
    @Test
    public void testRemoveAll(){
        ResizableArray a1 = new ResizableArray(5);
        ResizableArray a2 = new ResizableArray(5);
        a1.add(1);
        a1.add(2);
        a1.add(8);
        /////////
        a2.add(1);
        a2.add(2);
        /////////
        a1.removeAll(a2);
        a1.add(9);
        for (int i = 0; i < a1.size(); i++) {
            System.out.println(a1.get(i));
        }
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
}