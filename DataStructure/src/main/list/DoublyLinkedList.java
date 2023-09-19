package main.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents a generic doubly linked list
 *
 * @author Soheb Khan
 */
public class DoublyLinkedList<Item> implements List<Item> {
    Node first = null;
    Node last = null;

    /**
     * Represents a node in the list
     */
    private class Node {
        Item val;
        Node next;
        Node prev;

        public Node(Item val) {
            this.val = val;
            this.next = this.prev = null; // ask bhai is this required
        }

        public Node(Item val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Adds the element at the end of the list
     *
     * @return
     */
    public boolean add(Item n) {
        if (isEmtpy()) {
            first = new Node(n);
            last = first;
            return false;
        }
        last.next = new Node(n, last, null);
        last = last.next;
        return true;
    }

    /**
     * Adds the element at the first of the list
     */
    public void addFirst(Item n) {
        if (isEmtpy()) {
            first = new Node(n);
            last = first;
            return;
        }
        first.prev = new Node(n, null, first);
        first = first.prev;
    }

    /**
     * Adds the element at the end of the list
     */
    public void addLast(Item n) {
        add(n);
    }

    /**
     * Inserts the element at the given index
     *
     * @param index
     * @param n
     * @throws IndexOutOfBoundsException if the given index is greater than or
     *                                   equals to size.
     * @throws IllegalArgumentException  if the given index is less than 0.
     */
    public void add(int index, Item n) {
        if (index < 0)
            throw new IllegalArgumentException();
        Node dummyHead = new Node(null, null, first);
        Node prev = dummyHead;
        Node curr = first;
        int i = 0;
        while (curr != null && i < index) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        if (curr == null && i < index)
            throw new IndexOutOfBoundsException(); // will allow 1 index out of bound if i < index - 1, also we can
        // remove the curr == null condition
        prev.next = new Node(n, prev, curr);
        if (prev.next.next == null)
            last = prev.next;
        first = dummyHead.next;
    }

    @Override
    public boolean addAll(List<Item> i) {
        return false;
    }

    @Override
    public boolean addAll(int index, List<Item> i) {
        return false;
    }

    /**
     * Returns true if the list is empty and false otherwise
     */
    public boolean isEmtpy() {
        return first == null;
    }

    /**
     * Returns the element present at the given index
     *
     * @param index
     */
    public Item get(int index) {
        if (isEmtpy() || index < 0)
            throw new NoSuchElementException();
        Node target = getTarget(index);
        return target.val;
    }

    /**
     * Returns the first element in the list
     */
    public Item getFirst() {
        return first.val;
    }

    /**
     * Returns the first element in the list
     */
    public Item getLast() {
        return last.val;
    }

    /**
     * Sets the given element at the given index
     *
     * @param index
     * @param n
     * @return
     */
    public Item set(int index, Item n) {
        if (index < 0 || isEmtpy())
            throw new NoSuchElementException();
        Node target = getTarget(index);
        Item e = target.val;
        target.val = n;
        return e;
    }

    private Node getTarget(int index) {
        Node target = first;
        for (int i = 0; i < index; i++) {
            if (target == null)
                throw new IndexOutOfBoundsException();
            target = target.next;
        }
        return target;
    }

    public boolean remove(Item n) {
        if (isEmtpy())
            throw new NoSuchElementException();
        Node dummyHead = new Node(null, null, first);
        Node prev = dummyHead;
        Node curr = first;
        while (curr != null) {
            if (curr.val != n) {
                prev.next = curr;
                curr.prev = prev;
                prev = curr;
            }
            curr = curr.next;
        }
        last = prev;
        last.next = null;
        first = dummyHead.next;
        if (prev == dummyHead) first = last = null;
        return true;
    }

    @Override
    public Item removeAtIndex(int index) {
        if (isEmtpy() || index < 0) throw new IndexOutOfBoundsException();
        Node target = getTarget(index);
        if (target.prev == null) {
            first = first.next;
        } else if (target.next == null) {
            last = last.prev;
            last.next = null;
        } else {
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }
        return null;
    }

    public Item removeAtIndexV2(int index) {

        if (isEmtpy() || index < 0) throw new IndexOutOfBoundsException();
        else if (index == 0) {
            first = first.next;
            first.prev = null;
            return null;
        }
        Node prev = first;
        int i = 0;
        while (prev.next != null && i < index - 1) {
            prev = prev.next;
            i++;
        }
        if (i < index - 1 || prev.next == null) throw new IndexOutOfBoundsException();
        prev.next = prev.next.next;
        prev.next.prev = prev;
        return null;
    }

    @Override
    public boolean removeAll(List<Item> i) {
        return false;
    }

    @Override
    public boolean retainAll(List<Item> i) {
        return false;
    }

    @Override
    public boolean contains(Item item) {
        if(first.val == item || last.val == item) return true;
        Node curr = first;
        Node lcurr = last;
        while (curr != lcurr) {
            if (curr.val == item) return true;
            else if (lcurr.val == item) return true;
            curr = curr.next;
            lcurr = lcurr.prev;
        }
        if (curr != null && curr.val == item) return true;
        return false;
    }


    @Override
    public boolean containsAll(List<Item> i) {
        return false;
    }


    @Override
    public int indexOf(Item item) {
        return 0;
    }

    @Override
    public int lastIndexOf(Item item) {
        return 0;
    }


    @Override
    public List<Item> sublist(int fromIndex, int toIndex) {
        return null;
    }


    /**
     * Returns the size of the list
     *
     * @return int
     */
    public int size() {
        Node curr = first;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    /**
     * Prints the list
     */
    public void printList() {
        Node curr = first;
        while (curr.next != null) {
            System.out.print(curr.val + ", ");
            curr = curr.next;
        }
        System.out.print(curr.val);
    }

    @Override
    public Object[] toArray() {
        Item [] arr = (Item[]) new Object[10];
        Node curr = first;
        int i = 0;
        while (curr!= null){
            if (i + 1 == arr.length)arr = Arrays.copyOf(arr,i*2);
            arr[i++] = curr.val;
            curr = curr.next;
        }

        return arr;
    }

    public String  toString(){
        if (isEmpty())
            return "";
        StringBuilder str = new StringBuilder(" ");
        for (Node temp = first; temp != null; temp = temp.next) {
            str.append(temp.val);
        }
        return str.toString();
    }

    /**
     * Clears the list
     */
    public void clear() {
        first = last = null;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
