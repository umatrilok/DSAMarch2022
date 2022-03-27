package courseDP.TimeAndSpaceComplexity;

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int[] arr= new int[n];
        for(int i =0;i<n;i++)
            arr[i]=sc.nextInt();

        for(int i=0;i<n-1;i++)
        {
            int minIndex=i;
            for(int j=i+1;j<n;j++)
            {
                if(arr[minIndex]>arr[j])
                {
                    minIndex=j;
                }
            }
            int temp=arr[i];
            arr[i]= arr[minIndex];
            arr[minIndex]=temp;

            System.out.println();
            for (int x:arr)
                System.out.print(x+"\t");
        }

    }
}