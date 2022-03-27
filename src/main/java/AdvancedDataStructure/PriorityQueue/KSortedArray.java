package AdvancedDataStructure.PriorityQueue;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KSortedArray {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]arr = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = scn.nextInt();
        }
        int k=scn.nextInt();
        solve(arr,k);
    }
    public static void solve(int[] arr, int k)
    {
        //if we remove anything from PriorityQueue, bydefault min value will be removed
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++)
        {
            pq.add(arr[i]);
        }
        for(int j=k;j<arr.length;j++)
        {
            pq.add(arr[j]);
            System.out.println(pq.remove());
        }

        while(pq.size()>0)
        {
            System.out.println(pq.remove());
        }

    }
}
/*
9
3 2 4 1 6 5 7 9 8
3-->k
1
2
3
4
5
6
7
8
9*/

/*
9
3 2 4 1 6 5 7 9 8
2-->k
2
1
3
4
5
6
7
8
9*/