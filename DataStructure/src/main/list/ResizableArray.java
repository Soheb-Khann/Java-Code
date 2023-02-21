package main.list;

public class ResizableArray {
    int n;
    public int i;
    int list[];
    public ResizableArray(int size){
        n = size;
        list = new int[n] ;
        i = 0;
    }

    public ResizableArray(){
        list = new int[50] ;
        i = 0;
    }

    public void Add(int e){
        list[i] = e;
        i++;
    }

    public int Get(int index){
        return list[index];
    }
    public void Set(int index, int e) {
     list[index] = e;
    }
    public int Remove(){
        --i;
        System.out.println("Removed : "+list[i]);
        return list[i];
    }

    public int Find(int f){
        for (int j = 0; j < i ; j++) {
            if(f == list[j]){
                System.out.println("Element : "+f+" \n Found at index : "+j);
                return j;
            }
        }
        System.out.println("Element Not Found");
        return -1;
    }

    public int lastIndexOf(int e){
        int lastIndex = -1;
        for (int j = 0; j< i ; j++){
            if (e == list[j]){
                lastIndex = j;
            }
        }
        return lastIndex ;
    }

    public int removeIndex(int n){
        int e = list[n];
        list[n] = 0;
        for (int j = n; j < i-1; j++) {
        list[j] = list[j+1];
        }
        --i;
        return e;
    }
}
