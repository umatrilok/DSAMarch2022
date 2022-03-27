package courseDP.TimeAndSpaceComplexity;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int[] arr= new int[n];
        for(int i =0;i<n;i++)
            arr[i]=sc.nextInt();

        for(int i=1;i<n;i++)
        {
            System.out.print("\n"+"i:"+i+":"+arr[i]+" will ask can i come front as i am small"+" ,ans is:");
            for(int j=i;j>0;j--)
            {
                if(arr[j-1]>arr[j])
                {
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }

            for(int x=0;x<=i;x++)
                System.out.print(arr[x]+"\t");
        }

    }
}
/*
*
5
5 4 3 2 1

i:1:4 will ask can i come front as i am small ,ans is:4	5
i:2:3 will ask can i come front as i am small ,ans is:3	4	5
i:3:2 will ask can i come front as i am small ,ans is:2	3	4	5
i:4:1 will ask can i come front as i am small ,ans is:1	2	3	4	5	*/