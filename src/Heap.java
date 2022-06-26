//Aaron Yu, 018153614
//Jacob Munoz, 018192133
import java.util.*;
public class Heap {

    private int[] array;
    private int heapSize;

    //basic constructor to build the Heap
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

    public static int insert(Heap hp, int key){
        int heap_size = hp.getHeapSize();
        heap_size += 1;
        hp.getArray()[heap_size - 1] = key;
        heapify(hp, heap_size - 1);
        return heap_size;

//        int heapSize = A.length;
//        heapSize += 1;
//        A[heapSize - 1] = num;
//        heapify(A, num - 1);
    }

    public static int pop(Heap hp, int num){
        int lastElement = hp.getArray()[num - 1];
        hp.getArray()[0] = lastElement;
        num -= 1;
        heapify(hp,num);
        return num;
    }

    public static void Heapsort(Heap hp){
        int heap_size = hp.getHeapSize();

        for(int i = heap_size / 2 - 1; i >= 0; i--){
            heapify(hp,i);
        }

        for(int i = heap_size - 1; i > 0;i--){
            int temp = hp.getArray()[0];
            hp.getArray()[0] = hp.getArray()[i];
            hp.getArray()[i] = temp;

            heapify(hp,i);
        }
    }

    public static void swap(Heap hp, int i, int j){
        int temp = hp.getArray()[i];
        hp.getArray()[i] = hp.getArray()[j];
        hp.getArray()[j] = temp;
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
}

