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

    public static void heapify(int[] array, int heapSize, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < heapSize && array[left] > array[largest])
            largest = left;

        if (right < heapSize && array[right] > array[largest])
            largest = right;

        if(largest != i){
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, heapSize, largest);
        }

    }

    public static int insert(int[] A, int heapSize, int key){

        heapSize += 1;
        A[heapSize - 1] = key;
        heapify(A, heapSize, heapSize - 1);
        return heapSize;
    }

    public static int pop(int[] A, int num){
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

