package courseDP.TimeAndSpaceComplexity;

import java.io.*;

import java.util.*;

import static courseDP.TimeAndSpaceComplexity.MergeTwoSortedArrays.mergeTwoSortedArrays;

public class MergSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int[] arr= new int[n];
        for(int i =0;i<n;i++)
            arr[i]=sc.nextInt();

        int[] mergedArray = mergeSort(arr,0,arr.length-1);
        print(mergedArray);
    }

    public static int[] mergeSort(int[] arr, int lo, int hi) {
        if (lo == hi) {         //only 1 element is remaining                                                             //2
            int[]ba = new int[1];
            ba[0] = arr[lo];
            return ba;
        }
        int mid = (lo + hi) / 2;
        int[] f = mergeSort(arr, lo, mid);
        int[] s = mergeSort(arr, mid + 1, hi);
        int[] fin = mergeTwoSortedArrays(f, s);
        return fin;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
    }
}
/*
8
7 4 1 3 6 8 2 5
1	2	3	4	5	6	7	8	*/