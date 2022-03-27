package courseDP.TimeAndSpaceComplexity;

import java.io.*;
import java.util.*;

public class PartitionAnArray {

    public static void partition(int[] arr, int pivot) {
        int i = 0;
        int j = 0;
        while (i < arr.length) {
            if (arr[i] > pivot)
            {
                i++;
            }
            else if (arr[i] <= pivot)
            {
                swap(arr, i, j);
                i++;
                j++;
            }
        }

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

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int pivot = scn.nextInt();
        partition(arr, pivot);
        print(arr);
    }

}
/*
8
7 9 4 8 3 6 2 1
5
Swapping 4 and 7
Swapping 3 and 9
Swapping 2 and 7
Swapping 1 and 8
4 3 2 1 9 6 7 8 */