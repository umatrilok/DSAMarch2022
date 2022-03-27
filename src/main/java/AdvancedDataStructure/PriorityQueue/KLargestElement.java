package AdvancedDataStructure.PriorityQueue;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElement {
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
        for(int i=0;i<arr.length;i++)
        {
            pq.add(arr[i]);
            if(pq.size()>k)
            {
                pq.remove();
            }
        }


        ArrayList<Integer> al = new ArrayList<Integer>();
        while(pq.size()>0)
        {
            al.add(pq.remove());
        }
        for(int i=k-1;i>=0;i--)
        {
            System.out.println(al.get(i)+" ");
        }
    }
}
/*
8
44 -5 -2 41 12 19 21 -6
2
41
44
System.out.println(pq.remove());
System.out.println(pq.remove());

when ArrayList<Integer> is not included

when it is included
*/

/*
8
44 -5 -2 41 12 19 21 -6
2
44
41 */