package main.list;

import java.util.NoSuchElementException;

/**
 * Represents a generic doubly linked list
 *
 * @author Soheb Khan
 */
public class DoublyLinkedList<Item> {
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
     */
    public void add(Item n) {
        if (isEmtpy()) {
            first = new Node(n);
            last = first;
            return;
        }
        last.next = new Node(n, last, null);
        last = last.next;
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
    public void addAtIndex(int index, Item n) {
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
     */
    public void set(int index, Item n) {
        if (index < 0 || isEmtpy())
            throw new NoSuchElementException();
        Node target = getTarget(index);
        target.val = n;
    }

    private Node getTarget(int index) {
        Node target = first;
        for (int i = 0; i != index; i++) {
            if (target == null)
                throw new IndexOutOfBoundsException();
            target = target.next;
        }
        return target;
    }

    public void remove(Item n) {
        if (isEmtpy())
            throw new NoSuchElementException();
        Node dummyHead = new Node(null, null, first);
        Node prev = dummyHead;
        Node curr = first;
        while (curr != null) {
            if (curr.val == n)
                prev.next = curr.next;
            prev = prev.next;
            curr = curr.next;
        }
        last = prev;
        first = dummyHead.next;
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

    /**
     * Clears the list
     */
    public void clear() {
        first = last = null;
    }
}
