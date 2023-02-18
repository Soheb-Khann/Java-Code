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
    }
}