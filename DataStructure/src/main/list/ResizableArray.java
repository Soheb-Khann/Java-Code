package main.list;

/**
 * Represents a resizable array of integer elements.
 */

public class ResizableArray {
    private int size;
    private int firstBlankIndex;
    private int list[];

    /**
     * Constructs a resizable array
     * @param size
     * size of the list
     */
    public ResizableArray(int size){
        this.size = size;
        list = new int[this.size] ;
        firstBlankIndex = 0;
    }

    /**
     * Constructs a resizable array with default size 50
     */
    public ResizableArray(){
        size = 50;
        list = new int[50] ;
        firstBlankIndex = 0;
    }

    /**
     * Adds an element to the list
     * @param num
     */
    public void add(int num){
        if (size == 0){
            list[size] = num;
            return;
        }
        else if (firstBlankIndex == size){
            size = size*2 ;
            int list2 [] = new int[size];
            for (int i = 0; i < firstBlankIndex; i++) {
               list2[i] = list[i];
            }
            list = list2;
        }
        list[firstBlankIndex] = num;
        firstBlankIndex++;
    }

    /**
     * Get element at the given index.
     *@param index
     * @return
     * Returns the element
     */
    public int get(int index){
        if (index < 0 || index >= firstBlankIndex ){ return -1;}
        return list[index];
    }

    /**
     * Sets element at specified index
     *
     * @param index
     * @param num
     */
    public void set(int index, int num) {
        if (index < 0 || index >= firstBlankIndex ){ return;}
        list[index] = num;
    }

    /**
     * Removes last element and returns it
     */
    public int remove(){
        if (firstBlankIndex == 0 || size == 0 ){ return -1;}
        --firstBlankIndex;
        return list[firstBlankIndex];
    }

    /**
     * Removes element at given index, shifts the elements and returns the removed element
     * @param index
     */
    public int removeIndex(int index){
        if (index < 0 || index >= firstBlankIndex ){ return -1;}
        int removedElement = list[index];
        for (int j = index; j < firstBlankIndex -1; j++) {
            list[j] = list[j+1];
        }
        --firstBlankIndex;
        return removedElement;
    }

    /**
     * Removes given element and shifts the array.
     * @param num
     */
    public int removeElement(int num){
        int index = indexOf(num);
        if (index == -1) {return index;}
        removeIndex(index);
        return 0;
    }

    /**
     * Finds the specified element in the list and returns its index
     * @param num
     */
    public int indexOf(int num){
        for (int j = 0; j < firstBlankIndex; j++) {
            if(num == list[j]){
                return j;
            }
        }
        return -1;
    }

    /**
     * Returns true if the element is found and false otherwise
     * @param num
     */
    public boolean contains(int num){
        return indexOf(num) != -1;
    }

    /**
     * Returns last index of given element
     * @param num
     */
    public int lastIndexOf(int num){
        int lastIndex = -1;
        for (int i = firstBlankIndex; i >= 0; i--){
            if (num == list[i]){
                lastIndex = i;
                break;
            }
        }
        return lastIndex ;
    }

    /**
     * Removes all the elements but keeps the size of the list
     */
    public void clear(){
        list = new int[size];
    }

    /**
     * Return true if the list is Empty otherwise false
     */
    public boolean isEmpty(){
        return firstBlankIndex == 0;
    }

    /**
     * Returns the number of element in the list
     * @return
     */
    public int size(){
        return firstBlankIndex;
    }

}
