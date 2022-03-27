package recursion.recursionBacktracking;

import java.util.Scanner;

public class KnightsTour {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] chess = new int[n][n];
        int row =sc.nextInt();
        int col =sc.nextInt();
        printKnightsTour(chess,row,col,1);
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
        int n=chess.length;




        if(upcomingMove==n*n+1)//n*n+1)
        {
            displayBoard(chess);
            return;
        }
        if(r<0||c<0||r>=chess.length||c>=chess.length||chess[r][c]!=0) {
            return;
        }

        chess[r][c]=upcomingMove;
        printKnightsTour(chess,r-2,c+1,upcomingMove+1);
        printKnightsTour(chess,r-1,c+2,upcomingMove+1);
        printKnightsTour(chess,r+1,c+2,upcomingMove+1);
        printKnightsTour(chess,r+2,c+1,upcomingMove+1);
        printKnightsTour(chess,r+2,c-1,upcomingMove+1);
        printKnightsTour(chess,r+1,c-2,upcomingMove+1);
        printKnightsTour(chess,r-1,c-2,upcomingMove+1);
        printKnightsTour(chess,r-2,c-1,upcomingMove+1);
        chess[r][c]=0;

    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
