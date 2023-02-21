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
}