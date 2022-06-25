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
    public static void heapify(int[] A, int i){
        int l = Left(i);
        int r = Right(i);


        if (l <= )
    }

    public static void insert(int[] A, int num){

    }

    public static pop(int[] A, ){

    }

    public static void sort(int[] A){
        int heap_size = A.length;

        for(int i = heap_size / 2 - 1; i >= 0; i--){
            heapify(A,i);
        }

        for(int i = heap_size - 1; i > 0;i--){
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;

            heapify(A,i);
        }
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

