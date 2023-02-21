package test.list;
import main.list.ResizableArray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResizableArrayTest {
    @Test
    public void testAdd() {
        ResizableArray list = new ResizableArray();
        list.Add(5);
        assertEquals(5,list.Get(0));
    }
    @Test
    public void testSet() {
        ResizableArray list = new ResizableArray();
        list.Add(5);
        list.Add(15);
        list.Set(0,3);
        assertEquals(3,list.Get(0));
    }
    @Test
    public void testRemove() {
        ResizableArray list = new ResizableArray();
        list.Add(5);
        list.Add(15);
        assertEquals(15,list.Remove());
    }
    @Test
    public void testFind() {
        ResizableArray list = new ResizableArray();
        list.Add(5);
        list.Add(15);
        list.Add(14);
        list.Add(17);
        list.Add(10);
        assertEquals(3,list.Find(17));
    }
    @Test
    public void testLastIndexOf(){
        ResizableArray list = new ResizableArray();
        list.Add(5);
        list.Add(4);
        list.Add(3);
        list.Add(2);
        list.Add(5);
        list.Add(8);
        list.Add(9);
        list.Add(5);
        list.Add(1);
        assertEquals(7,list.lastIndexOf(5));
    }
    @Test
    public void testRemoveIndex(){
        ResizableArray list = new ResizableArray();
        list.Add(5);
        list.Add(4);
        list.Add(3);
        list.Add(2);
        list.Add(5);
        list.Add(8);
        list.Add(9);
        list.Add(5);
        list.Add(1);
       assertEquals(8,list.removeIndex(5));
       assertEquals(9,list.Get(5));
       assertEquals(8,list.i);

    }
}