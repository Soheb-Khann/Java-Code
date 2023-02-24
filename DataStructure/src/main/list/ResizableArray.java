package main.list;

/**
 * Represents a resizable array of integer elements.
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
        if (writeIndex == list.length){
            int list2 [] = new int[(list.length+1)*2];
            System.arraycopy(list,0,list2,0,list.length);
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
     * Get an element at the given index.
     * @param index
     * @return
     * @throws ArrayIndexOutOfBoundsException
     * If the given index is less than 0
     * or if the given index is greater than or equals to size.
     * returns the element.
     */
    public int get(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= writeIndex){ throw new ArrayIndexOutOfBoundsException(); }
        return list[index];
    }

    /**
     * Sets given element at the specified index.
     *
     * @param index
     * @param num
     */
    public void set(int index, int num)  {
        if (index < 0 || index >= writeIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        list[index] = num;
    }

    /**
     * Removes element at given index.
     * returns the removed element.
     * @param index
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
     * Determines whether element exists or not.
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
     * Removes all the elements but keeps the size of the list.
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
     * Returns the number of element in the list.
     * @return
     */
    public int size(){
        return writeIndex;
    }

}
