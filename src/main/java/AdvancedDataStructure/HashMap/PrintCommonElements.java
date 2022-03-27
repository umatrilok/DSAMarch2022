package AdvancedDataStructure.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class PrintCommonElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1=sc.nextInt();
        int arr1[] = new int[n1];
        for(int i=0;i<n1;i++)
            arr1[i]=sc.nextInt();

        int n2=sc.nextInt();
        int arr2[] = new int[n2];
        for(int i=0;i<n2;i++)
            arr2[i]=sc.nextInt();

        HashMap<Integer,Integer> map= new HashMap<>();
        //we want all arr1[] elements to be in map
        //if any duplicates found in arr1[] we are incrementing the frequency
        for(int i =0 ;i<n1;i++)
        {
            int key=arr1[i];
            if(map.containsKey(key))
            {
                int old_fre=map.get(key);
                map.put(key,old_fre+1);
            }
            else{
                map.put(key,1);
            }
        }

        //if common element found,we print and we remove that element from map, so that the removed element
        //even if it comes in rest of the arr2[] as duplicate in arr2[] should not be printed
        for(int i=0;i<n2;i++)
        {
            int key=arr2[i];
            if(map.containsKey(key))
            {
                System.out.println(key);
                map.remove(key);
            }
        }
    }
}
/*
10(n1)
1 2 3 4 5 6 7 8 9 10
5(n2)
2 4 6 8 10
common elements
2
4
6
8
10

15(n1)
1 2 3 4 5 6 7 8 9 10 2 2 3 4 5
8(n2)
2 3 4 5 2 3 4 5
common elements
2
3
4
5
*/