package functionsArrays;

import java.util.Scanner;

public class BarChart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr=new int[n];
        int max=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            if(max<arr[i])
                max=arr[i];
        }

        for(int row=0;row<max;row++)
        {
            for(int j=0;j<arr.length;j++)
            {
                if(arr[j]>=max-row)
                {
                    System.out.print("*\t");
                }
                else
                    System.out.print("\t");
            }
            System.out.println();
        }
    }
}
