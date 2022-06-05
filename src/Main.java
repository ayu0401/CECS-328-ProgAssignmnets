import java.lang.reflect.Array;
import java.util.*;

public class Main {



    public static void SortedDescendingInit(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = (array.length - 1) - i;
        }
    }

    public static void SortedAscendingInit(int[] array){
        for (int i = 0; i < 1000; i++){
            array[i] = i;
        }
    }




//The BubbleSort algorithm super easy stuff
    public static void BubbleSort(int[] arrB){
        for (int j = 0; j < arrB.length - 1; j++){
            for (int i = 0; i < arrB.length - 1 - j; i++) {
                if (arrB[i] > arrB[i + 1]) {
                    int tp = arrB[i];
                    arrB[i] = arrB[i + 1];
                    arrB[i + 1] = tp;
                }
            }
        }
    }










//The merge sort algorithm kinda easy, recursive
    public static void merge(int[] arr, int[] lft, int[] rht){
        //Initializing the ijk for while loops
        int i = 0; int j = 0; int k = 0;
        int lenL = lft.length; int lenR = rht.length;


        /* here it will put the sorted elements into the arr[] until one side prevails because say lft.length is 1 and
        rht.length is 2. And the lft element is smaller than the rht. Result --> i=lenL there fore we need to jump to
        the bottom and do while(j < lenR) to finish off whatever we need to store in the arr[]. vice versa.
         */
        while (i < lenL && j < lenR){
            if (lft[i] <= rht[j]){
                arr[k] = lft[i];
                i++;
                k++;
            }
            else{
                arr[k] = rht[j];
                j++;
                k++;
            }
        }

        while (i < lenL){
            arr[k] = lft[i];
            i++;
            k++;
        }

        while (j < lenR){
            arr[k] = rht[j];
            j++;
            k++;
        }


    }

    public static void MergeSort(int[] arr){
        int n = arr.length;
        //Base Case
        if (n < 2){
            return;
        }
        //Create 2 arrays left and right
        int mid = n / 2;
        int[] lft = new int[mid];
        int[] rht = new int[n - mid];

        //Copy the stuff from arr(arg) into the split left[]
        for (int i = 0; i < mid; i++){
            lft[i] = arr[i];
        }
        //Copy the stuff from arr(arg) other half into the split right[]
        for (int j = mid; j < n; j++){
            rht[j - mid] = arr[j];
        }

        //Recurse over and over again until the array is split into one element.
        MergeSort(lft);
        MergeSort(rht);
        //Then merge the the arrays together
        merge(arr, lft, rht);
    }







   //   p -> starting index
   //   r -> ending index
   //   A -> the [] array
    private static void QuickSort(int[] A, int p, int r){
        if (p < r){

            // q will be the partitioning index
            int q = Partition(A, p, r);
            QuickSort(A, p, q-1);
            QuickSort(A, q+1, r);

        }
    }

    //this will be used within the partition method
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = array[temp];
    }

    private static int Partition(int[] A, int p, int r){
        int pivot = A[r];

        //the index that starts on the very beginning
        int i = (p -1);

        for (int j = p; j<= r - 1; j++){
            if (A[j] < pivot){
                i++;
                swap(A,i,j);
            }
        }
        swap(A, i + 1, r);
        return(i+1);

    }








    public static void main(String[] args) {
        int[] a = new int[1000];
        int[] b = new int[1000];
        int[] c = new int[10000];


        //SortedDescendingInit(a);


        long start = System.currentTimeMillis();
        SortedDescendingInit(a);
        System.out.println(Arrays.toString(a));
        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end-start) + " ms");

    }
}

