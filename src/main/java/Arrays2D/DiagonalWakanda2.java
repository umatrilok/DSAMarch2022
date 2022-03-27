package Arrays2D;

import java.util.Scanner;

public class DiagonalWakanda2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[][] = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                arr[i][j]=sc.nextInt();


        for(int d=0;d<arr.length;d++)
        {
            for(int i=0,j=d;j<arr[0].length;i++,j++)
            {
                System.out.println(arr[i][j]);
            }
        }



        for(int diag=0;diag<n;diag++)
        {
            int row=0;
            int col=diag;
            while(col<n)
            {
                System.out.println(arr[row][col]);
                row++;
                col++;
            }
        }
    }
}
