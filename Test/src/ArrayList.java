public class ArrayList {
    int n;
    int i;
    int list[];
    ArrayList(int size){
        n = size;
        list = new int[n] ;
        i = 0;
    }

    ArrayList(){
        list = new int[50] ;
        i = 0;
    }

    void Add(int e){
        list[i] = e;
        i++;
    }

    int Get(int index){
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
