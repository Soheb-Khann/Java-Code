package main.list;

/**
 * Creates a Resizable List of Integer elements like the ArrayList Implementation in Java
 */

public class ResizableArray {
    private int size;
    private int indexOfLastElement;
    private int list[];

    /**
     * @param size
     * Takes in the size of the list.
     * If left blank default size of 50 will be used
     */
    public ResizableArray(int size){
        this.size = size;
        list = new int[this.size] ;
        indexOfLastElement = 0;
    }

    public ResizableArray(){
        size = 50;
        list = new int[50] ;
        indexOfLastElement = 0;
    }

    /**
     * @param num
     * Takes the number to add at the end of the list.
     */
    public void add(int num){
        if (indexOfLastElement == size-1){
            size = size + 50;
            int list2 [] = new int[size];
            for (int i = 0; i <= indexOfLastElement; i++) {
               list2[i] = list[i];
            }
            list = list2;
        }
        list[indexOfLastElement] = num;
        indexOfLastElement++;
    }

    /**
     *@param index
     * Gets the element at index
     * @return
     * Returns the element
     */
    public int getElementAtIndex(int index){
        if (index < 0 ){ return -1;};
        return list[index];
    }

    /**
     * Sets element at specified index
     *
     * @param index
     * @param num
     */
    public void set(int index, int num) {
        if (index < 0 ){ return;}
        list[index] = num;
    }

    /**
     * Removes last element and returns it
     */
    public int remove(){
        if (indexOfLastElement == 0 ){ return -1;}
        --indexOfLastElement;
        return list[indexOfLastElement];
    }

    /**
     * Removes element at given index, shifts the elements and returns the removed element
     * @param index
     */
    public int removeIndex(int index){
        if (index < 0 ){ return -1;}
        int removedElement = list[index];
        for (int j = index; j < indexOfLastElement -1; j++) {
            list[j] = list[j+1];
        }
        --indexOfLastElement;
        return removedElement;
    }

    /**
     * Finds the specified element in the list and returns its index
     * @param num
     */
    public int find(int num){
        for (int j = 0; j < indexOfLastElement; j++) {
            if(num == list[j]){
                return j;
            }
        }
        return -1;
    }

    /**
     * Returns last index of given element
     * @param num
     */
    public int lastIndexOf(int num){
        int lastIndex = -1;
        for (int j = 0; j< indexOfLastElement; j++){
            if (num == list[j]){
                lastIndex = j;
            }
        }
        return lastIndex ;
    }

}
