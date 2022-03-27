package courseDP.TimeAndSpaceComplexity;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int[] arr= new int[n];
        for(int i =0;i<n;i++)
            arr[i]=sc.nextInt();

        for(int i=1;i<n;i++) {
            for (int j = 0; j < n - i; j++) {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            System.out.print("\n"+"i:"+i+":");
            for (int x:arr)
                System.out.print(x+"\t");
        }

    }
}
/*
*
5
5 4 3 2 1

4	3	2	1	5
3	2	1	4	5
2	1	3	4	5
1	2	3	4	5*/