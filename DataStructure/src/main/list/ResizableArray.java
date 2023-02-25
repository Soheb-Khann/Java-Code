package main.list;

import java.util.Arrays;

/**
 * Represents a resizable array of integer elements.
 * @author Soheb Khan
 */
public class ResizableArray {
    private int writeIndex;
    private int list[];

    /**
     * Constructs a resizable array.
     * @param size
     * size of the list.
     */
    public ResizableArray(int size){
        list = new int[size] ;
    }

    /**
     * Constructs a resizable array with initial capacity 10.
     */
    public ResizableArray(){
        list = new int[10] ;
    }
    public void ensureCapacity(){
        if(list.length == 0){
            list = new int[10];
            return;
        }
        if (writeIndex == list.length){
            int list2 [] = Arrays.copyOf(list,list.length*2);
            list = list2;
        }
    }
    /**
     * Adds an element to the array.
     * @param num
     */
    public void add(int num){
        ensureCapacity();
        list[writeIndex] = num;
        writeIndex++;
    }

    /**
     * Gets an element at the given index.
     * @param index
     * @return the element.
     * @throws ArrayIndexOutOfBoundsException
     *  If the given index is less than 0
     *  or if the given index is greater than or equals to size.
     */
    public int get(int index) {
        if (index < 0 || index >= writeIndex){ throw new ArrayIndexOutOfBoundsException(); }
        return list[index];
    }

    /**
     * Sets given element at the specified index.
     *
     * @param index
     * @param num
     * @throws ArrayIndexOutOfBoundsException
     *  If the given index is less than 0
     *  or if the given index is greater than or equals to size.
     */
    public void set(int index, int num)  {
        if (index < 0 || index >= writeIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        list[index] = num;
    }

    /**
     * Removes element at given index.
     * @param index
     * @return  the removed element.
     * @throws ArrayIndexOutOfBoundsException
     *  If the given index is less than 0
     *  or if the given index is greater than or equals to size.
     */
    public int removeAtIndex(int index) {
        if (index < 0 || index >= writeIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int removedElement = list[index];
        for (int j = index; j < writeIndex - 1; j++) {
            list[j] = list[j+1];
        }
        --writeIndex;
        return removedElement;
    }

    /**
     * Removes given element.
     * @param num
     * @return true when given element is removed, false otherwise.
     */
    public boolean remove(int num){
        int index = indexOf(num);
        if (index == -1) {return false;}
        removeAtIndex(index);
        return true;
    }

    /**
     * Returns the index of the given element.
     * @param num
     * @return the index of the given element. if the element is not found then it returns -1.
     */
    public int indexOf(int num){
        for (int j = 0; j < writeIndex; j++) {
            if(num == list[j]){
                return j;
            }
        }
        return -1;
    }

    /**
     * Determines whether given element exists or not.
     * @param num
     * @return true if the element is found, false otherwise.
     */
    public boolean contains(int num){
        return indexOf(num) != -1;
    }

    /**
     * Returns the index of the last occurrence of the given element.
     * @param num
     * @return the index of the last occurrence of the given element, -1 otherwise.
     */
    public int lastIndexOf(int num){
        for (int i = writeIndex; i >= 0; i--){
            if (num == list[i]){
                return i ;
            }
        }
        return -1 ;
    }

    /**
     * Removes all the elements but keeps the size.
     */
    public void clear(){
        list = new int[list.length];
        writeIndex = 0;
    }

    /**
     * Return true if the list is empty otherwise false.
     */
    public boolean isEmpty(){
        return writeIndex == 0;
    }

    /**
     * Returns the size of resizable array.
     * @return
     */
    public int size(){
        return writeIndex;
    }
}
