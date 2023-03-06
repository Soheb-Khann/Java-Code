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
     * @throws ArrayIndexOutOfBoundsException
     * @throws NegativeArraySizeException
     */
    public ResizableArray(int size){
        if (size < 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        list = new int[size] ;
    }

    /**
     * Constructs a resizable array with initial capacity 10.
     */
    public ResizableArray(){
        list = new int[10] ;
    }
    private void ensureCapacity(){
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
    public boolean add(int num){
            ensureCapacity();
            list[writeIndex] = num;
            writeIndex++;
            if (list[writeIndex - 1] == num){
                return true;
            }
            return false;
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
        if (index < 0 || index >= writeIndex ){
            throw new ArrayIndexOutOfBoundsException();
        }
        return list[index];
    }

    /**
     * Sets given element at the specified index.
     * @param index
     * @param num
     * @throws ArrayIndexOutOfBoundsException
     *  If the given index is less than 0
     *  or if the given index is greater than or equals to size.
     */
    public void set(int index, int num)  {
        if (index < 0 || index >= writeIndex || isEmpty()){
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
        if (index < 0 || index >= writeIndex || isEmpty()) {
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
        if (contains(num)) {
            int j = 0;
            for (int i = 0; i < size(); i++) {
                if (list[i] != num) {
                    swap(i, j);
                    j++;
                }
            }
            writeIndex = j;
            return true;
        }
        return false;
    }
    private void swap(int i, int j){
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    /**
     * Returns the index of the given element.
     * @param num
     * @return the index of the given element. if the element is not found then it returns -1.
     */
    public int indexOf(int num){
        if (!isEmpty()) {
            for (int j = 0; j < writeIndex; j++) {
                if (num == list[j]) {
                    return j;
                }
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
        for (int i = writeIndex - 1; i >= 0; i--){
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

    /**
     * add all the elements from given resizableArray
     * @param resizableArray
     */
    public void addAll(ResizableArray resizableArray){
        if (list.length - size() < resizableArray.size()){
            list = Arrays.copyOf(list,size()+resizableArray.size());
        }
        for (int i = 0; i < resizableArray.size(); i++){
            add(resizableArray.get(i));
        }
    }

    /**
     * Removes elements which marches with the elements of given resizable array
     * @param resizableArray
     */
    public void removeAll(ResizableArray resizableArray) {
        for (int i = 0; i < resizableArray.size(); i++) {
            remove(resizableArray.get(i));
        }
        list = Arrays.copyOf(list,writeIndex);
    }

    /**
     * retains elements which matches with the elements of given resizable array.
     * @param resizableArray
     */
    public boolean retainAll(ResizableArray resizableArray){
        if (isEmpty() || resizableArray.isEmpty()){
            return false;
        }
        for (int i = 0; i < size(); i++) {
            int flag = 0;
            for (int j = 0; j < resizableArray.size(); j++) {
                if (list[i] == resizableArray.get(j)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0){
                list[i] = -1;
            }
        }
        remove(-1);
        list = Arrays.copyOf(list,writeIndex);
        return true;
    }

    /**
     * Checks the elements of given resizable array exist in this resizable array
     * @param resizableArray
     * @return true when exist otherwise false
     */
    public boolean containsAll(ResizableArray resizableArray){
        for (int i = 0; i < resizableArray.size(); i++) {
            if (!contains(resizableArray.get(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * Gives array that have element of resizable array
     * @return array variable
     */
    public int[] toArray(){
        if (isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return Arrays.copyOf(list,list.length);
    }

    /**
     * Checks whether the array is identical to the current array.
     * @param resizableArray
     * @return true when identical and false otherwise.
     */
    public boolean equals(ResizableArray resizableArray){
        if (resizableArray.isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        if (size() != resizableArray.size()){
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (list[i] != resizableArray.get(i)){
                return false;
            }
        }
        return true;
    }

    /**
     * Removes the given range of element.
     * @param fromIndex
     * @param toIndex
     * @return
     * return true if the elements were removed, false otherwise
     * @throws ArrayIndexOutOfBoundsException
     */
    public boolean removeRange(int fromIndex,int toIndex){
        if (fromIndex < 0 || fromIndex >= writeIndex || toIndex <= 0 || toIndex >= writeIndex || fromIndex == toIndex){
            throw new ArrayIndexOutOfBoundsException();
        }
        if (!isEmpty()) {
            for (int i = fromIndex; i < toIndex; i++) {
                list[i] = -1;
            }
            remove(-1);
            list = Arrays.copyOf(list,writeIndex);
            return true;
        }
        return false;
    }

    /**
     * Adds the elements of the given range and places the sum at the end.
     * @param fromIndex
     * @param toIndex
     * @return Returns true if the elements were added successfully, false otherwise
     */
    public boolean addRange(int fromIndex, int toIndex){
        if (fromIndex < 0 || fromIndex >= writeIndex || toIndex <= 0 || toIndex >= writeIndex || fromIndex == toIndex){
            throw new ArrayIndexOutOfBoundsException();
        }
        if (!isEmpty()) {
            int sum = 0;
            for (int i = fromIndex; i <= toIndex; i++) {
                sum = sum + list[i];
            }
            add(sum);
            return true;
        }
        return false;
    }
}
