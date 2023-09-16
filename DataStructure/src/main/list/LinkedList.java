package main.list;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Represents a linked list of integer elements.
 *
 * @author Soheb Khan
 */
public class LinkedList {
    private Node head;
    private Node lastNode = null;

    private int size;

    /**
     * Represents a node in list.
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
     * Constructs a linked list of size 1.
     */
    public LinkedList() {
        head = new Node(0);  // correct it
        lastNode = null;
        size = 0;
    }

    /**
     * Adds an element at the end of the list.
     *
     * @param n
     */
    public void add(int n) {
        if (isEmpty()) {
            head.data = n;
            lastNode = head;
            size++;
            return;
        }
        lastNode.next = new Node(n);
        lastNode = lastNode.next;
        size++;
    }

    /**
     * Adda an element at the specified index.
     *
     * @param index
     * @param n
     * @throws IndexOutOfBoundsException If index is invalid.
     */
    public void addAtIndex(int index, int n) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(n);
            return;
        }
        if (index == size) {
            addLast(n);
            return;
        }
        Node temp = head.next;
        int i = 1;
        while (i != index) {
            temp = temp.next;
            i++;
        }
        Node a = new Node(n);
        a.next = temp.next;
        temp.next = a;
        size++;
    }

    /**
     * Adds the element at first position.
     *
     * @param n
     */
    public void addFirst(int n) {
        if (isEmpty()) {
            add(n);
            return;
        }
        Node temp = new Node(n);
        temp.next = head;
        head = temp;
        size++;
    }


    /**
     * Adds the element at the last position.
     *
     * @param n
     */
    public void addLast(int n) {
        if (isEmpty()) {
            add(n);
            return;
        }
        Node temp = new Node(n);
        lastNode.next = temp;
        lastNode = temp;
        size++;
    }

    /**
     * Removes the given element from the list
     *
     * @param n
     */
    public void remove(int n) {
        if (isEmpty()) throw new NoSuchElementException();
        if (size == 1) {
            if (head.data == n) {
                head = new Node(0);
                lastNode = null;
                size = 0;
                return;
            }
        } else if (size == 2) {
            if (head.data == n) {
                head = head.next;
                size--;
            } else if (lastNode.data == n) {
                lastNode = head;
                size--;
            }
            return;
        } else if (head.data == n) {
            head = head.next;
            size--;
        } else if (lastNode.data == n) {
            Node temp = head.next;
            while (temp.next != lastNode) {
                temp = temp.next;
            }
            lastNode = temp;
            lastNode.next = null;
            size--;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == n) {
                temp.next = temp.next.next;
                size--;
                return;
            }
            temp = temp.next;
        }
    }

    /**
     * Removes element at the given index.
     *
     * @param index
     * @throws NoSuchElementException    if the list is empty
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public void removeAtIndex(int index) {
        if (isEmpty()) throw new NoSuchElementException();
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            if (size == 1) {
                head = new Node(0);
                lastNode = null;
                size = 0;
                return;
            } else {
                head = head.next;
                size--;
                return;
            }
        }
        if (index == size - 1) {
            if (size == 2) {
                lastNode = head;
                lastNode.next = null;
                size = 1;
            } else {
                Node temp = head;
                while (temp.next != lastNode) temp = temp.next;
                lastNode = temp;
                lastNode.next = null;
                size--;
            }
            return;
        }
        int n = 0;
        Node temp = head;
        for (; n != index - 1; temp = temp.next) {
            n++;
        }
        temp.next = temp.next.next;
        size--;
    }

    /**
     * Returns the element at the given index.
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException If index is invalid
     */
    public int get(int index) {
        if (isEmpty()) throw new NoSuchElementException();
        else if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        else if (index == 0) return head.data;
        else if (index == size - 1) return lastNode.data;
        int i = 1;
        Node temp = head.next;
        while (i != index) {
            temp = temp.next;
            i++;
        }
        return temp.data;
    }

    /**
     * Returns the first element.
     *
     * @return
     */

    public int getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return head.data;
    }

    /**
     * Returns the last element.
     *
     * @return
     */
    public int getLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return lastNode.data;
    }

    /**
     * Sets the given element at the given index.
     *
     * @param index
     * @param n
     * @throws IndexOutOfBoundsException If index is invalid.
     */
    public void set(int index, int n) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        else if (index == 0) head.data = n;
        else if (index == size - 1) lastNode.data = n;
        Node temp = head;
        int i = 0;
        while (i != index) {
            temp = temp.next;
            i++;
        }
        temp.data = n;
    }

    /**
     * Clears the linked list
     */
    public void clear() { // Inefficient method
        if (size == 0) return;
        else if (size == 1) {
            head = new Node(0); // correct
            lastNode = null;
            size = 0;
            return;
        }
        size = 0;
        lastNode = head;
        Node temp = head.next;
        Node target = temp;
        while (temp.next != null) {
            temp = temp.next;
            target.next = null;
            target = temp;
        }
    }

    /**
     * Adds all the element of the given list at the end of the current list
     */
    public void addAll(LinkedList l) {
        if (l.isEmpty()) {
            System.out.println("Given list is empty");
            return;
        }
        int[] a = l.toArray();  // traverse the list
        if (isEmpty()) {
            for (int e : a) add(e);
            return;
        }
        for (int e : a) addLast(e);
    }

    /**
     * Return true if the list is empty otherwise false
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if the given element is present in the list otherwise false
     *
     * @param n
     * @return
     * @throws NoSuchElementException If the list is empty.
     */
    public boolean contains(int n) {
        if (isEmpty()) throw new NoSuchElementException();
        if (head.data == n) return true;
        else if (lastNode.data == n) return true;
        for (Node temp = head; temp != lastNode; temp = temp.next) {
            if (temp.data == n) return true;
        }
        return false;
    }

    /**
     * Returns the size of the list
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Returns an array containing linked list elements.
     *
     * @return
     */
    public int[] toArray() {
        Node temp = head;
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = temp.data;
            temp = temp.next;
        }
        return a;
    }

    /**
     * Returns the linked list in string form.
     *
     * @return
     */
    public String toString() {
        return Arrays.toString(toArray());
    }

    /**
     * Prints the list
     */
    public void printList() {  // 1 - 2 - null
        System.out.println(toString());
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
