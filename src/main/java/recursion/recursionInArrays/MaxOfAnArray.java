package recursion.recursionInArrays;

import java.util.Scanner;

public class MaxOfAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        System.out.println(maxOfArray(arr,0));
    }
    public static int maxOfArray(int[] arr, int idx)
    {
        if(idx==arr.length)
            return Integer.MIN_VALUE;//what will you return

        int max_after_idx1=maxOfArray(arr,idx+1);//faith that f(x) will work for smaller values


        //our work
        if(arr[idx]>max_after_idx1)
        {
            return arr[idx];
        }
        else{
            return max_after_idx1;
        }
    }
}
