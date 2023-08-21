package main.list;

/**
 * Represents a linked list of integer elements.
 *
 * @author Soheb Khan
 */
public class LinkedList {
    private Node head;
    private Node lastNode = null;

    private int count;

    /**
     * Represents a node in list
     */
    static class Node {
        private int data;
        private Node next;

        private Node(int n) {
            data = n;
            next = null;
        }
    }

    /**
     * Constructs a linked list of size 1
     */
    public LinkedList() {
        head = null;
        lastNode = null;
        count = 0;
    }

    /**
     * Adds an element at the end of the list
     *
     * @param n
     */
    public boolean add(int n) {
        if (count == 0) {
            head = new Node(n);
            lastNode = head;
            count++;
            return true;
        }
        lastNode.next = new Node(n);
        lastNode = lastNode.next;
        count++;
        return true;
    }

    /**
     * Adda an element at the specified index
     *
     * @param index
     * @param n
     * @throws IndexOutOfBoundsException If index is invalid.
     */
    public void add(int index, int n) {
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException();
        Node a = new Node(n);
        if (index == 0) {
            addFirst(n);
            return;
        }
        Node temp = head;
        int i = 0;
        while (i != index - 1) {
            temp = temp.next;
            i++;
        }
        a.next = temp.next;
        temp.next = a;
        count++;
    }

    public void set(int index, int n) {

    }

    /**
     * Adds the element at first position
     *
     * @param n
     */
    public void addFirst(int n) {
        Node temp = new Node(n);
        temp.next = head;
        head = temp;
        count++;
    }

    public void addLast(int n) {
        Node temp = new Node(n);
        lastNode.next = temp;
        lastNode = temp;
        count++;
    }

    public void clear() {

    }

    public void contains(int n) {

    }

    /**
     * Returns the element at the given index
     * @param index
     * @return
     * @throws IndexOutOfBoundsException If index is invalid
     */
    public int get(int index) {
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException();
        else if (index == 0) return head.data;
        else if (index == count - 1) return lastNode.data;
        int i = 1;
        Node temp = head.next;
        while (i != index) {
            temp = temp.next;
            i++;
        }
        return temp.data;
    }

    public void getFirst() {

    }

    public void getLast() {

    }

    public void indexOf(int n) {

    }

    public void lastIndexOf(int n) {

    }

    public void peak() {

    }

    public void peakLast() {

    }

    public void remove(int n) {

    }

    public void removeFirstOccurrence(int n) {

    }

    public void size() {

    }

    public void toArray() {

    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(2);

        l.head.next = second;
        second.next = third;
    }

}
