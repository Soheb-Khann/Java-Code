package test.list;

import main.list.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LinkedListTest {
    @Test
    public void testAdd() {
        LinkedList l = new LinkedList();
        l.add(0);
        l.add(1);
        l.add(2);
        assertEquals(0, l.get(0));
        assertEquals(1, l.get(1));
        assertEquals(2, l.get(2));
    }

    @Test
    public void testAddAtIndex() {
        LinkedList l = new LinkedList();
        l.add(0); // 0
        l.add(1);// 1
        l.add(2);// 2
        l.add(1, 2);
        assertEquals(2, l.get(1));
    }

    @Test
    public void testAddAtIndexInvalid(){
        LinkedList l = new LinkedList();
        l.add(0); // 0
        l.add(1);// 1
        l.add(2);// 2
        assertThrows(IndexOutOfBoundsException.class, () ->  l.add(3, 2));
    }

}
