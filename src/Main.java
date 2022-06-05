/**
 * Aaron Yu 018153614
 * Jacob Munoz 018192133
 */

import java.lang.reflect.Array;
import java.util.*;
public class Main {



    public static void SortedDescendingInit(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = (array.length - 1) - i;
        }
    }

    public static void SortedAscendingInit(int[] array){
        for (int i = 0; i < array.length; i++){
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

        /**
         * Test Case 1
         */
        int[] a = new int[1000];

        /**
         * Test Case 2
         */
        int[] b = new int[1000];

        /**
         * Test Case 3 & 4
         */
        Random randNum = new Random();

        int[] testCase3 = new int[1000];
        for(int i = 0; i < testCase3.length; i++){
            testCase3[i] = randNum.nextInt(1000);
        }
        int[] testCase4 = new int[10000];
        for(int i = 0; i < testCase4.length; i++){
            testCase4[i] = randNum.nextInt(10000);
        }
        //SortedDescendingInit(a);
        //SortedAscendingInit(b);


//        int[] c = {227, 889, 368, 697, 626, 86, 919, 924, 840, 454, 412, 11, 602, 823, 132, 245, 719, 458, 391, 85, 92,
//                865, 744, 387, 720, 392, 12, 883, 207, 929, 98, 633, 636, 293, 611, 603, 912, 735, 990, 349, 24, 828, 210,
//                368, 716, 732, 334, 643, 331, 187, 491, 958, 394, 42, 764, 880, 202, 690, 660, 850, 212, 998, 208, 399, 481,
//                239, 346, 734, 674, 131, 892, 991, 128, 56, 808, 5, 32, 93, 461, 396, 504, 796, 798, 172, 373, 932, 199, 170,
//                83, 123, 482, 924, 686, 926, 76, 377, 230, 349, 120, 170, 649, 927, 182, 795, 119, 824, 90, 361, 482, 808,
//                971, 801, 238, 443, 400, 899, 410, 740, 747, 751, 431, 623, 456, 310, 998, 825, 37, 936, 428, 97, 509, 607,
//                999, 525, 15, 983, 67, 994, 164, 993, 530, 710, 590, 655, 519, 674, 959, 384, 642, 138, 715, 761, 460, 261,
//                287, 208, 668, 430, 549, 903, 917, 293, 240, 796, 518, 760, 354, 210, 170, 962, 738, 464, 615, 978, 17, 685,
//                308, 431, 299, 602, 976, 974, 893, 450, 1, 864, 187, 732, 316, 988, 137, 857, 193, 794, 175, 674, 473, 175,
//                167, 644, 111, 448, 703, 840, 82, 24, 370, 761, 260, 931, 493, 781, 387, 857, 394, 784, 56, 430, 18, 661,
//                872, 687, 122, 631, 467, 679, 529, 960, 614, 379, 857, 721, 596, 126, 661, 797, 493, 940, 888, 486, 472,
//                403, 854, 681, 553, 105, 131, 815, 31, 31, 283, 168, 290, 792, 633, 533, 555, 251, 112, 343, 636, 115,
//                228, 356, 76, 740, 725, 992, 105, 551, 418, 988, 538, 494, 388, 573, 518, 823, 835, 903, 127, 130, 329,
//                81, 162, 980, 197, 44, 374, 775, 707, 839, 197, 70, 33, 149, 865, 405, 966, 144, 722, 503, 833, 800, 957,
//                530, 482, 894, 644, 188, 125, 834, 448, 562, 62, 543, 933, 637, 877, 490, 390, 943, 519, 224, 216, 640,
//                132, 136, 920, 963, 960, 198, 404, 10, 73, 443, 664, 391, 537, 672, 606, 916, 707, 531, 580, 904, 303,
//                513, 753, 752, 378, 453, 189, 781, 125, 703, 457, 461, 424, 725, 507, 237, 356, 309, 586, 668, 885, 696,
//                893, 137, 532, 517, 610, 458, 931, 893, 813, 969, 927, 180, 970, 5, 721, 313, 671, 74, 579, 860, 613, 507,
//                721, 411, 541, 494, 491, 198, 826, 889, 455, 553, 339, 234, 229, 697, 366, 702, 131, 165, 53, 804, 182,
//                396, 516, 173, 447, 963, 349, 692, 593, 871, 450, 211, 67, 10, 277, 68, 355, 818, 54, 83, 83, 55, 852,
//                172, 623, 390, 985, 641, 957, 91, 392, 67, 363, 266, 429, 547, 95, 347, 302, 209, 752, 733, 8, 913, 476,
//                542, 224, 343, 498, 954, 950, 806, 865, 721, 259, 328, 872, 26, 507, 443, 822, 256, 387, 561, 457, 714,
//                859, 36, 609, 349, 428, 295, 559, 532, 64, 981, 724, 874, 103, 218, 819, 204, 808, 339, 299, 273, 48, 240,
//                373, 397, 862, 689, 39, 574, 221, 727, 888, 121, 96, 44, 233, 178, 357, 569, 359, 535, 254, 908, 273, 637,
//                810, 67, 290, 493, 921, 356, 521, 306, 719, 622, 203, 164, 39, 809, 20, 418, 227, 954, 957, 589, 903, 381,
//                89, 867, 348, 263, 962, 932, 983, 600, 702, 784, 674, 833, 393, 504, 112, 585, 677, 341, 805, 773, 62,
//                398, 594, 972, 322, 558, 713, 550, 521, 168, 183, 708, 720, 130, 89, 318, 263, 153, 679, 500, 238, 790,
//                737, 589, 63, 403, 301, 772, 878, 950, 404, 954, 64, 585, 204, 434, 243, 745, 282, 207, 419, 338, 662,
//                394, 278, 958, 726, 266, 666, 751, 662, 491, 382, 238, 662, 916, 362, 953, 254, 381, 563, 567, 898, 249,
//                923, 655, 591, 201, 85, 211, 180, 209, 639, 81, 994, 633, 820, 930, 297, 69, 446, 50, 769, 29, 125, 628,
//                419, 802, 939, 600, 86, 639, 687, 617, 840, 94, 999, 670, 285, 160, 258, 997, 996, 240, 689, 940, 696,
//                664, 476, 755, 461, 508, 958, 223, 23, 135, 251, 344, 451, 167, 39, 8, 776, 438, 423, 13, 715, 40, 937,
//                849, 450, 965, 144, 94, 54, 875, 96, 44, 121, 631, 283, 989, 981, 253, 378, 579, 35, 925, 974, 523, 897,
//                500, 741, 338, 973, 943, 453, 534, 632, 240, 238, 220, 340, 843, 938, 341, 318, 428, 429, 334, 283, 434,
//                696, 328, 34, 291, 597, 37, 954, 980, 27, 530, 799, 853, 565, 113, 322, 632, 74, 771, 272, 107, 455, 553,
//                265, 679, 782, 711, 899, 972, 892, 382, 496, 841, 43, 362, 138, 323, 767, 907, 629, 279, 815, 20, 941,
//                375, 567, 538, 930, 575, 630, 935, 716, 594, 361, 402, 415, 759, 991, 312, 719, 452, 232, 86, 937, 55,
//                956, 720, 972, 338, 600, 462, 473, 262, 155, 465, 306, 27, 119, 850, 764, 929, 730, 178, 328, 496, 562,
//                331, 621, 236, 995, 84, 125, 195, 807, 679, 991, 508, 937, 55, 742, 952, 694, 448, 901, 985, 598, 951,
//                608, 483, 522, 70, 200, 556, 465, 124, 183, 687, 710, 415, 623, 654, 41, 642, 849, 347, 697, 254, 905,
//                321, 678, 838, 195, 292, 318, 4, 10, 717, 227, 436, 43, 357, 727, 517, 757, 370, 638, 766, 893, 433, 784,
//                776, 777, 993, 33, 506, 415, 515, 122, 179, 371, 605, 722, 366, 360, 115, 996, 320, 45, 956, 308, 149, 73,
//                911, 92, 559, 13, 759, 983, 721, 740, 559, 620, 817, 97, 530, 516, 334, 989, 408, 545, 130, 432, 533, 124,
//                81, 949, 227, 588, 678, 272, 319, 219, 170, 753, 591, 995, 501, 196, 823, 290, 806, 190, 524, 297, 273,
//                267, 887, 436, 813, 667, 528, 264, 977, 911, 208, 452, 111, 455, 294, 842, 693, 723, 927, 767, 926, 528,
//                370, 41, 572, 499, 304, 176, 10, 304, 472, 865, 855, 244, 647, 948, 479, 150, 813, 866, 949, 353, 154,
//                376, 476, 358, 239, 339, 719, 732, 840, 32, 977};

        /**
        * Bubble Sort
        */
        long start = System.currentTimeMillis();
        SortedDescendingInit(a);
        BubbleSort(a);
        //System.out.println(Arrays.toString(a));
        long end = System.currentTimeMillis();
        System.out.println("Bubble Sort Descending Execution time: " + (end-start) + " ms");

        long start2 = System.currentTimeMillis();
        SortedAscendingInit(b);
        BubbleSort(b);
        //System.out.println(Arrays.toString(b));
        long end2 = System.currentTimeMillis();
        System.out.println("Bubble Sort Ascending Execution time: " + (end2-start2) + " ms");

        long start3 = System.currentTimeMillis();
        BubbleSort(testCase3);
        //System.out.println(Arrays.toString(testCase3));
        long end3 = System.currentTimeMillis();
        System.out.println("Bubble Sort 1000 Random Elements Execution time: " + (end3-start3) + " ms");

        long start4 = System.currentTimeMillis();
        BubbleSort(testCase4);
        //System.out.println(Arrays.toString(testCase4));
        long end4 = System.currentTimeMillis();
        System.out.println("Bubble Sort 10000 Random Elements Execution time: " + (end4-start4) + " ms");
        System.out.println();

        /**
         * Insertion Sort
         */
        long start5 = System.currentTimeMillis();
        SortedDescendingInit(a);
        InsertionSort(a);
        //System.out.println(Arrays.toString(a));
        long end5 = System.currentTimeMillis();
        System.out.println("Insertion Sort Descending Execution time: " + (end5-start5) + " ms");

        long start6 = System.currentTimeMillis();
        SortedAscendingInit(b);
        InsertionSort(b);
        //System.out.println(Arrays.toString(b));
        long end6 = System.currentTimeMillis();
        System.out.println("Bubble Sort Ascending Execution time: " + (end6-start6) + " ms");

        long start7 = System.currentTimeMillis();
        InsertionSort(testCase3);
        //System.out.println(Arrays.toString(testCase3));
        long end7 = System.currentTimeMillis();
        System.out.println("Bubble Sort 1000 Random Elements Execution time: " + (end7-start7) + " ms");

        long start8 = System.currentTimeMillis();
        InsertionSort(testCase4);
        //System.out.println(Arrays.toString(testCase4));
        long end8 = System.currentTimeMillis();
        System.out.println("Bubble Sort 10000 Random Elements Execution time: " + (end8-start8) + " ms");
        System.out.println();

        /**
         * Quick Sort
         */
        long start9 = System.currentTimeMillis();
        SortedDescendingInit(a);
        QuickSort(a);
        //System.out.println(Arrays.toString(a));
        long end9 = System.currentTimeMillis();
        System.out.println("Insertion Sort Descending Execution time: " + (end9-start9) + " ms");

        long start10 = System.currentTimeMillis();
        SortedAscendingInit(b);
        QuickSort(b);
        //System.out.println(Arrays.toString(b));
        long end10 = System.currentTimeMillis();
        System.out.println("Bubble Sort Ascending Execution time: " + (end10-start10) + " ms");

        long start11 = System.currentTimeMillis();
        QuickSort(testCase3);
        //System.out.println(Arrays.toString(testCase3));
        long end11 = System.currentTimeMillis();
        System.out.println("Bubble Sort 1000 Random Elements Execution time: " + (end11-start11) + " ms");

        long start12 = System.currentTimeMillis();
        QuickSort(testCase4);
        //System.out.println(Arrays.toString(testCase4));
        long end12 = System.currentTimeMillis();
        System.out.println("Bubble Sort 10000 Random Elements Execution time: " + (end12-start12) + " ms");
        System.out.println();

        /**
         * Merge Sort
         */
        

    }
}

