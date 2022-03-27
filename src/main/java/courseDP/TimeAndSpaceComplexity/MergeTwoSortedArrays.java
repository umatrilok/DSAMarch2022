package courseDP.TimeAndSpaceComplexity;


import java.io.*;

        import java.util.*;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scn.nextInt();
        }
        int[] mergedArray = mergeTwoSortedArrays(a, b);
        print(mergedArray);
    }
    public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
        // write your code here
        int n = a.length;
        int m = b.length;

        int[] res = new int[n + m];

        int i = 0;
        int j = 0;
        int k = 0;

        // when there are elements in both the array
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                res[k] = a[i];
                i++;
            } else {
                res[k] = b[j];
                j++;
            }
            k++;
        }


        while (i < n) {
            res[k] = a[i];
            i++;
            k++;
        }

        while (j < m) {
            res[k] = b[j];
            j++;
            k++;
        }

        return res;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}