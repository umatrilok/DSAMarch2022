package recursion.recursionBacktracking;

import java.util.Scanner;

public class FloodFill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m=sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        boolean[][] vis = new boolean[n][m];
        floodFill(arr,0,0,"",vis);
    }
    public static void floodFill(int[][] maze, int sr, int sc, String asf,boolean[][] vis)
    {
        int n=maze.length;
        int m=maze[0].length;
        if(sr<0||sc<0||sr>=n||sc>=m || maze[sr][sc] ==1 || vis[sr][sc]==true)
        {
            return;
        }

        if(sr==n-1 && sc==m-1)
        {
            System.out.println(asf);
            return;
        }
        vis[sr][sc]=true;//or vis[sr][sc]=2;

        floodFill(maze,sr-1,sc,asf+"t",vis);
        floodFill(maze,sr,sc-1,asf+"l",vis);
        floodFill(maze,sr+1,sc,asf+"d",vis);
        floodFill(maze,sr,sc+1,asf+"r",vis);
        //order should be t l d r

        vis[sr][sc]= false;//or vis[sr][sc]=0;

    }
}
/*
*
5 6
0 0 0 0 1 0
0 1 1 0 0 0
0 0 0 0 1 0
0 1 1 0 1 0
0 0 0 0 1 0
ddddrrrtttrrddd
ddrrrtrrddd
rrrdrrddd
*/

/*
* 3 3
0 0 0
1 0 1
0 0 0
rddr
* */

/*
*5 6
0 0 0 0 1 0
0 1 1 0 0 0
0 0 0 0 1 0
0 1 1 0 1 0
0 0 0 0 1 0
ddddrrrtttrrddd
ddrrrtrrddd
rrrdrrddd
* */
/*
*
4 4
0 1 0 1
0 0 0 0
0 1 0 0
0 0 0 0
dddrrttrdd
dddrrtrd
dddrrr
drrddr
drrdrd
drrrdldr
drrrdd
* */
