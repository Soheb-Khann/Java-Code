package test.list;
import main.list.ResizableArray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResizableArrayTest {
    @Test
    public void testAdd() {
        ResizableArray list = new ResizableArray();
        list.add(5);
        assertEquals(5,list.getElementAtIndex(0));
    }
    @Test
    public void testSet() {
        ResizableArray list = new ResizableArray();
        list.add(5);
        list.add(15);
        list.set(0,3);
        assertEquals(3,list.getElementAtIndex(0));
    }
    @Test
    public void testRemove() {
        ResizableArray list = new ResizableArray();
        list.add(5);
        list.add(15);
        assertEquals(15,list.remove());
    }
    @Test
    public void testFind() {
        ResizableArray list = new ResizableArray();
        list.add(5);
        list.add(15);
        list.add(14);
        list.add(17);
        list.add(10);
        assertEquals(3,list.find(17));
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
       assertEquals(8,list.removeIndex(5));
       assertEquals(9,list.getElementAtIndex(5));

    }
}