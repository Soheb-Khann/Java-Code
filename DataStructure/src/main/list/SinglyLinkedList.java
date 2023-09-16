package main.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents a generic linked list.
 *
 * @author Soheb Khan
 */
public class SinglyLinkedList<Item> implements Iterable<Item> {
    private Node first = null;

    /**
     * Represents a node in the list.
     */
    private class Node {
        Item data;
        Node next;

        public Node(Item n) {
            data = n;
            next = null;
        }
    }

    /**
     * Adds an element at the end of the list.
     *
     * @param n
     */
    public void addFirst(Item n) {
        if (isEmpty()) {
            first = new Node(n);
            return;
        }
        Node oldFirst = first;
        first = new Node(n);
        first.next = oldFirst;
    }

    /**
     * Adds the element at first position.
     *
     * @param n
     */
    public void addLast(Item n) {
        add(n);
    }

    /**
     * Adds the element at the last position.
     *
     * @param n
     */
    public void add(Item n) {
        if (isEmpty()) {
            first = new Node(n);
            return;
        }
        Node temp = first;
        while (temp.next != null)
            temp = temp.next;
        temp.next = new Node(n);
    }

    /**
     * Adda an element at the specified index.
     *
     * @param index
     * @param n
     * @throws IndexOutOfBoundsException If index is invalid.
     */
    public void addAtIndex(int index, Item n) {
        if (index < 0) throw new IndexOutOfBoundsException();
        else if (index == 0) {
            addFirst(n);
            return;
        } else if (isEmpty() && index > 0) {
            System.out.println("List is empty");
            return;
        }
        Node newNode = new Node(n);
        Node prevTarget = first;
        int currentIndex = 0;
        while (prevTarget.next != null && currentIndex < index - 1) {
            prevTarget = prevTarget.next;
            currentIndex++;
        }
        if (currentIndex < index - 1)
            throw new IndexOutOfBoundsException();
        newNode.next = prevTarget.next;
        prevTarget.next = newNode;
    }

    public void addAtIndexV2(int index, Item n) {
        if (index < 0) throw new IllegalArgumentException();
        Node dummyHead = new Node(null);
        dummyHead.next = first;
        Node prev = dummyHead;
        Node current = first;
        int i = 0;
        while (current != null && i < index) {
            prev = current;
            current = current.next;
            i++;
        }
        if (i < index) throw new IndexOutOfBoundsException();
        prev.next = new Node(n);
        prev.next.next = current;
        first = dummyHead.next;
    }

    /**
     * Returns the first element.
     *
     * @return
     */
    public Item getFirst() {
        return first.data;
    }

    /**
     * Returns the last element.
     *
     * @return
     */
    public Item getLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        Node temp = first;
        while (temp.next != null)
            temp = temp.next;
        return temp.data;
    }

    /**
     * Returns the element at the given index.
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException If index is invalid
     */
    public Item get(int index) {
        if (index < 0 || isEmpty())
            throw new NoSuchElementException();
        Node target = getTarget(index);
        return target.data;
    }

    /**
     * Sets the given element at the given index.
     *
     * @param index
     * @param n
     * @throws IndexOutOfBoundsException If index is invalid.
     */
    public void set(int index, Item n) {
        if (index < 0 || isEmpty())
            throw new IndexOutOfBoundsException();
        Node target = getTarget(index);
        target.data = n;
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

    /**
     * Removes the given element from the list
     *
     * @param n
     */
    public void remove(Item n) {
        if (isEmpty())
            throw new IllegalStateException();
        Node i = first, j = first, prNode = null;
        while (i != null) {
            if (i.data != n) {
                swap(i, j);
                prNode = j;
                j = j.next;
            }
            i = i.next;
        }
        if (prNode == null) {
            first = null;
            return;
        }
        prNode.next = null;
    }

    public void removeV2(Item n) {
        Node current = first;
        Node prev = null;
        while (current != null) {
            if (current.data != n) {
                if (prev == null) {
                    first = prev = current;
                } else {
                    prev.next = current;
                    prev = prev.next;
                }
            }
            current = current.next;
        }
        if (prev == null) first = null;
    }

    public void removeV3(Item n) {
        Node dummyHead = new Node(null);
        dummyHead.next = first;
        Node prev = dummyHead;
        Node current = first;
        while (current != null) {
            if (current.data != n) {
                prev.next = current;
                prev = prev.next;
            }
            current = current.next;
        }
        first = dummyHead.next;
    }

    private void swap(Node i, Node j) {
        if (i.data == j.data)
            return;
        Item temp = i.data;
        i.data = j.data;
        j.data = temp;

    }

    /**
     * Removes element at the given index.
     *
     * @param index
     * @throws NoSuchElementException    if the list is empty
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public void removeAtIndex(int index) {
        if (isEmpty() || index < 0)
            throw new IndexOutOfBoundsException();
        if (index == 0) {
            first = first.next;
            return;
        }
        Node prevTarget = first;       // getTarget() can also be used with index - 1 as argument
        int i = 0;
        while (prevTarget.next != null && i < index - 1) {
            prevTarget = prevTarget.next;
            i++;
        }
        if (i < index - 1 || prevTarget.next == null)
            throw new IndexOutOfBoundsException();
        prevTarget.next = prevTarget.next.next;
    }

    /**
     * Returns true if the given element is present in the list otherwise false
     *
     * @param n
     * @return
     * @throws NoSuchElementException If the list is empty.
     */
    public boolean contains(Item n) {
        if (isEmpty())
            return false;
        Node target = first;
        while (target != null) {
            if (target.data == n)
                return true;
            target = target.next;
        }
        return false;
    }

    /**
     * Returns the size of the list
     *
     * @return
     */

    public int size() {
        if (isEmpty())
            return 0;
        int i = 0;
        Node target = first;
        while (target != null) {
            i++;
            target = target.next;
        }
        return i;
    }

    /**
     * Returns an array containing linked list elements.
     *
     * @return
     */
    public Item[] toArray() {
        if (isEmpty()) throw new NoSuchElementException();
        Item[] a = (Item[]) new Object[10];
        int i = 0;
        for (Node target = first; target != null; target = target.next) {
            if (i + 1 == a.length) a = Arrays.copyOf(a, a.length * 2);
            a[i++] = target.data;
        }
        return a;
    }

    /**
     * Returns the linked list in string form.
     *
     * @return
     */
    public String toString() {
        if (isEmpty())
            return "";
        String str = " ";
        for (Node temp = first; temp != null; temp = temp.next) {
            str = str + temp.data; // code is inefficient use string builder
        }
        return str;
    }

    /**
     * Adds all the element of the given list at the end of the current list
     */
    public void addAll(SinglyLinkedList<Item> l) {
        for (Item item : l)
            add(item);
    }

    public void addAll(SinglyLinkedList<Item> l, int index) {
        if (index < 0) throw new IllegalArgumentException();
        Node current = first;
        int i = 0;
        while (current != null && i != index) {
            current = current.next;
            i++;
        }
        for (Item item : l)
            addAtIndex(i++, item);
    }

    public void removeRange(int fromIndex, int toIndex) {
        if (isEmpty()) throw new NoSuchElementException();
        if ((fromIndex < 0 || toIndex < 0) || (fromIndex > toIndex)) throw new IllegalArgumentException();
        if (fromIndex == toIndex) return;
        Node dummyHead = new Node(null);
        dummyHead.next = first;
        Node current = first;
        Node prevNode = dummyHead;
        int i = 0;
        while (current != null && i < fromIndex) {
            prevNode = current;
            current = current.next;
            i++;
        }
        if (current == null) return;
        while (current != null && i < toIndex) {
            current = current.next;
            i++;
        }
        prevNode.next = current;
        first = dummyHead.next;
    }

    public SinglyLinkedList<Item> subList(int fromIndex, int toIndex) {
        if (fromIndex >= toIndex)
            throw new IllegalArgumentException();
        SinglyLinkedList<Item> sub = new SinglyLinkedList<>();
        Node temp = getTarget(fromIndex);
        int i = fromIndex;
        while (i != toIndex) {
            if (temp == null) break;              // IndexOutOfBoundException
            sub.add(temp.data);
            temp = temp.next;
            i++;
        }
        return sub;
    }

    /**
     * Clears the linked list
     */
    public void clear() {
        first = null;
    }

    /**
     * Return true if the list is empty otherwise false
     *
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Prints the list
     */
    public void printList() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.data + " - ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item> {
        Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item data = current.data;
            current = current.next;
            return data;
        }
    }
}
