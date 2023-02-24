package test.list;
import main.list.ResizableArray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResizableArrayTest {
    @Test
    public void testAdd() {
        ResizableArray list = new ResizableArray(0);
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3,list.size());
    }
    @Test
    public void testSet() {
        ResizableArray list = new ResizableArray();
        list.add(5);
        list.add(15);
        list.set(0,3);
        assertEquals(3,list.get(0));
    }
    @Test
    public void testRemoveIndex(){
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
        assertEquals(8,list.removeAtIndex(5));
        list.add(9);
        assertEquals(9,list.get(8));

    }
    @Test
    public void testRemoveElement() {
        ResizableArray list = new ResizableArray();
        list.add(5);
        list.add(15);
        list.add(10);
        list.add(13);
        list.add(12);
        assertEquals(0,list.remove(10));

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
}