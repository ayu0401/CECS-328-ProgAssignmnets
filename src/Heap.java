import java.util.Arrays;
public class Heap {

    private int[] array;
    private int heapSize;



    //basic constructor to build the Heap
    public Heap(){
        array = null;
    }
    public Heap(int arraySize) {
        array = new int[arraySize];
        heapSize = arraySize;
    }






// heap properties
    public static int Parent(int i){
        return i / 2;
    }

    public static int Left(int i){
        return 2 * i;
    }

    public static int Right(int i){
        return 2 * i + 1;
    }



//heap functions

    public static void swap(Heap hp, int i, int j){
        int temp;
        temp = hp.getArray()[i];
        hp.getArray()[i] = hp.getArray()[j];
        hp.getArray()[j] = temp;
    }


    public static void heapify(Heap hp, int i){
        int l = Left(i);
        int r = Right(i);
        int smallest;

        if (l >=  hp.heapSize && hp.getArray()[l] < hp.getArray()[l]){
             smallest = l;
        }
        else{
            smallest = i;
        }
        if (r >= hp.heapSize && hp.getArray()[r] < hp.getArray()[r]){
            smallest = r;
        }
        if (smallest != i){
            swap(hp, i, smallest);
            heapify(hp, smallest);
        }
    }

    public static void BuildHeap(Heap hp){
        for (int i = hp.getHeapSize()/2; i>= 1; i--){
            heapify(hp, i);
        }
    }

    public void insert(int num){


    }

    public void pop(Heap hp){
        int lastElement = hp.getArray()[hp.getHeapSize() - 1];
        hp.getArray()[0] = lastElement;
        int num = getHeapSize() - 1;
        decHeapSize();
        heapify(hp,num);
    }




//Prints Array into String
    public String printArray(int[] A){
        return Arrays.toString(A);
    }




//getter method


    public int[] getArray() {
        return array;
    }
    public int getHeapSize(){
        return heapSize;
    }



    //setter method
    public void incHeapSize() {
        heapSize++;
    }
    public void decHeapSize() {
        heapSize--;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
}



