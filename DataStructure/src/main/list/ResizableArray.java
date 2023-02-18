package main.list;

public class ResizableArray {
    int n;
    int i;
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

    void Remove(){
        System.out.println("Removed : "+list[i]);
        i--;
    }
    void Find(int f){
        for (int j = 0; j < list.length; j++) {
            if(f == list[j]){
                System.out.println("Element : "+f+"\n Found at index : "+j);
                break;
            }
        }
    }
}
