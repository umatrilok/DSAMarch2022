package Arrays2D;

import java.util.Scanner;

public class StateOfWakanda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m= sc.nextInt();
        int n=sc.nextInt();
        int arr[][] = new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                arr[i][j]=sc.nextInt();

        for(int j=0;j<n;j++) {
            if(j%2==0) {
                for (int i = 0; i < m; i++)

                    System.out.println(arr[i][j]);
            }
            else
            {
                for (int i = m-1; i >=0; i--)

                    System.out.println(arr[i][j]);
            }
        }


    }
}
