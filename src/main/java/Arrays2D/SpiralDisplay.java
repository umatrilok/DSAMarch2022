package Arrays2D;

import java.util.Scanner;

public class SpiralDisplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n= sc.nextInt();
        int  m= sc.nextInt();
        int arr[][] = new int[n][m];


        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i][j] = sc.nextInt();

        int rmin = 0;
        int rmax = n-1;
        int cmin=0;
        int cmax=m-1;
        int count=0;

        while (count<n*m){
            //left wall
            for(int i=rmin;i<=rmax && count<m*n;i++){
                System.out.println(arr[i][cmin]);
                count++;
            }
            cmin++;//after the above loop i will never touch cmin so increment it

            //bottom wall
            for(int j=cmin; j<=cmax&& count<m*n;j++)
            {
                System.out.println(arr[rmax][j]);
                count++;
            }
            rmax--;

            //right wall
            for(int i=rmax;i>=rmin&& count<m*n;i--)
            {
                System.out.println(arr[i][cmax]);
                count++;
            }
            cmax--;

             //top wall
            for(int j=cmax;j>=cmin&& count<m*n;j--)
            {
                System.out.println(arr[rmin][j]);
                count++;
            }
            rmin++;
        }

    }
}
