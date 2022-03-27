package courseDP.TimeAndSpaceComplexity;

import java.io.*;

        import java.util.*;

public class QuickSort {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        quickSort(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void quickSort(int[] arr, int lo, int hi) {

        if (lo >= hi)
        {
            return;
        }

        int pivot = arr[hi];
        int pi = partition(arr, pivot, lo, hi);// you are partitioning till the last element in the tree, so the result array will be completely sorted
        quickSort(arr, lo, pi - 1);
        quickSort(arr, pi + 1, hi);

    }

    public static int partition(int[] arr, int pivot, int lo, int hi) {
        System.out.println("pivot -> " + pivot);
        int i = lo, j = lo;
        while (i <= hi) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }
        System.out.println("pivot index -> " + (j - 1));
        return (j - 1);
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
/*
* 8
7 9 4 8 3 6 2 1
pivot -> 1
Swapping 1 and 7
pivot index -> 0
pivot -> 7
Swapping 4 and 9
Swapping 3 and 9
Swapping 6 and 8
Swapping 2 and 9
Swapping 7 and 8
pivot index -> 5
pivot -> 2
Swapping 2 and 4
pivot index -> 1
pivot -> 4
Swapping 3 and 3
Swapping 4 and 6
pivot index -> 3
pivot -> 8
Swapping 8 and 9
pivot index -> 6
1 2 3 4 6 7 8 9
*/