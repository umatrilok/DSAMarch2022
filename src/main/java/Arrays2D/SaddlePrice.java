package Arrays2D;

import java.util.Scanner;

public class SaddlePrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[][] = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                arr[i][j]=sc.nextInt();

        for(int i=0;i<n;i++) {

            int min=Integer.MAX_VALUE;
            int min_col=-1;

            for (int j = 0; j < n; j++) {
                if(min>arr[i][j]) {
                  min=arr[i][j];
                  min_col=j;
                }
            }

            boolean isSaddle=true;
            for(int row=0;row<n;row++)
            {   //we are thinking min is the saddle point, so it has to be the maximum in row
                //if it is not maximum then it is not saddle point
                //so we are checking if it is less than any of the element in the column
                //if yes it is not the maximum in column
                if(arr[row][min_col]>min)
                {
                    isSaddle=false;
                }
            }
            if(isSaddle)
            {
                System.out.println(min);
                return;
            }
        }
        System.out.println("Invalid input");


    }
}
