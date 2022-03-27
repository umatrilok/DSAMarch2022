package recursion.recursionBacktracking;

import java.util.Scanner;

public class PrintNQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] chess = new boolean[n][n];
        printNQueens(chess,"",0);
    }
    //qsf->Queens so far
    public static void printNQueens(boolean[][] chess, String qsf,int row)
    {
        if(row==chess.length)
        {
            System.out.println(qsf+".");
            return;
        }
        for(int col=0;col<chess.length;col++)
        {
            if(isQueenSafe(chess,row,col)==true)
            {
                chess[row][col]=true;
                printNQueens(chess,qsf+row+"-"+col+",",row+1);
                chess[row][col]=false;
            }
        }
    }
    public static boolean isQueenSafe(boolean[][] chess ,int row, int col)
    {
        int[][] dirs={
                {-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}
        };
        int n=chess.length;
        for(int dis=1;dis<= n;dis++)
        {
            for(int i=0;i<8;i++)
            {
                int nrow=row+dirs[i][0]*dis;
                int ncol=col+dirs[i][1]*dis;

                if(nrow>=0 && ncol>=0 && nrow<n && ncol<n)
                {
                    if(chess[nrow][ncol]==true)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
