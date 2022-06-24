import java.util.Arrays;
public class Heap {

    private int[] array;
    private int heapSize;

    //basic constructor to build the Heap
    public Heap(int arraySize) {
        array = new int[arraySize];
        heapSize = arraySize;
    }





//Heap Functions
//    public boolean isFull(){
//
//    }

    public static heapify(int[] array, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < heapSize[array] && array[left] > array[largest])
            largest = left;
        else
            largest = i;
        else if (right < )

    }

    public static insert(int[] A, int num){

    }

    public static pop(int[] A, int num ){
        int lastElement = A[num - 1];
        A[0] = lastElement;
        num -= 1;
        heapify(A, num, 0);
        return num;

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

