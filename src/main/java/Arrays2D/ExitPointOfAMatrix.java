package Arrays2D;

import java.util.Scanner;

public class ExitPointOfAMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[][] = new int[m][n];


        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();

        int dir = 0;
        int col = 0;
        int row = 0;
        while (row >= 0 && col >= 0 && row < n && col < m) {
            if (arr[row][col] == 1) {
                dir = dir + 1;
            }


            dir = dir % 4;//because we have 4 directions only
            //if(dir==4)dir=0;//also works

            if (dir == 0) {
                col++;
            } else if (dir == 1) {
                row++;
            } else if (dir == 2) {
                col--;
            } else if (dir == 3) {
                row--;
            }
        }
        //exits-readjusting
        if (col == -1) col = 0;
        if (row == -1) row = 0;
        if (row == n) row = n - 1;
        if (col == m) col = m - 1;

        System.out.println(row);
        System.out.println(col);
    }
}