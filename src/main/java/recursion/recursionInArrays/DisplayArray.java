package recursion.recursionInArrays;

import java.util.Scanner;

public class DisplayArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        displayArray(arr,0);
        displayArrayPlus(arr,0);
    }

    public static void displayArray(int[] arr, int idx)
    {
        if(idx==arr.length)
            return;
        System.out.println(arr[idx]);//our work:print 1st element
        displayArray(arr,idx+1);//faith:2nd element till last element
    }

    public static void displayArrayPlus(int[] arr, int idx)
    {
        if(idx==arr.length)
            return;
        System.out.println(arr[idx]);
        displayArray(arr,idx++);//idx++ is post increment//first does the work then increments//might not work for our case

    }
}
