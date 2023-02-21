package test.list;
import main.list.ResizableArray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResizableArrayTest {
    @Test
    public void testResizableArray() {
        ResizableArray list = new ResizableArray();
        list.Add(5);
        assertEquals(5,list.Get(0));
        list.Add(10);
        assertEquals(10,list.Get(1));
        list.Add(15);
        list.Add(16);
        list.Find(15);
        list.Remove();
    }
}