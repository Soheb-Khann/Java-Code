package main.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<Item> implements Iterable<Item> {
    private Node first = null;

    private class Node {
        Item data;
        Node next;

        public Node(Item n) {
            data = n;
            next = null;
        }
    }

    public void add(Item n) {
        if (isEmpty()) {
            first = new Node(n);
            return;
        }
        Node oldFirst = first;
        first = new Node(n);
        first.next = oldFirst;
    }

    public void addFirst(Item n) {
        add(n);
    }

    public void addLast(Item n) {
        if (isEmpty()) {
            add(n);
            return;
        }
        Node temp = first;
        while (temp.next != null)
            temp = temp.next;
        temp.next = new Node(n);
    }

    public void addAtIndex(int index, Item n) { // can add dummyHead technique
        if (index < 0) throw new IndexOutOfBoundsException();
        else if (index == 0) {
            add(n);
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
// [0] (0,1) (1,1) , [0,1] (0,1) (1,1) (2,1) , [0,1,2] (0,1) (1,1) (2,1) (3,1)
    public void addAtIndexV2(int index, Item n){
        if(index < 0) throw new IllegalArgumentException();
        Node dummyHead = new Node(null);
        dummyHead.next = first;
        Node prev = dummyHead;
        Node current = first;
        int i = 0;
        while (current != null && i < index ){
            prev = current;
            current = current.next;
            i++;
        }
        if(i < index ) throw new IndexOutOfBoundsException();
        prev.next = new Node(n);
        prev.next.next = current;
        first = dummyHead.next;
    }

    public Item getFirst() {
        return first.data;
    }

    public Item getLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        Node temp = first;
        while (temp.next != null)
            temp = temp.next;
        return temp.data;
    }

    public Item get(int index) {
        if (index < 0 || isEmpty())
            throw new NoSuchElementException();
        Node target = getTarget(index);
        return target.data;
    }

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

    public Item[] toArray() {
        if (isEmpty())
            throw new NoSuchElementException();
        Item[] a = (Item[]) new Object[10];
        int i = 0;
        for (Node target = first; target != null; target = target.next) {
            if (i + 1 == a.length)
                a = Arrays.copyOf(a, a.length * 2);
            a[i++] = target.data;
        }
        return a;
    }

    public String toString() {
        if (isEmpty())
            return "";
        String str = " ";
        for (Node temp = first; temp != null; temp = temp.next) {
            str = str + temp.data; // code is inefficient use string builder
        }
        return str;
    }

    public void addAll(SinglyLinkedList<Item> l) {
        for (Item item : l)
            addLast(item);
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
            sub.addLast(temp.data);
            temp = temp.next;
            i++;
        }
        return sub;
    }

    public void clear() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

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
