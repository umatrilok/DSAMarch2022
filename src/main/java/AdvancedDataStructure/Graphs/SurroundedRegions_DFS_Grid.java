package AdvancedDataStructure.Graphs;

import java.util.Scanner;
//X=1=water
//O=0=Land
//$=5=used for conversion in boundary regions
public class SurroundedRegions_DFS_Grid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                grid[i][j]=sc.nextInt();
            }
        }
        solve(grid);

        for(int[] x:grid)
        {
            for(int y:x)
            {
                System.out.print(y+"\t");
            }
            System.out.println();
        }
    }


    public static void solve( int[][] grid)
    {
        //base case is not needed here because we are travelling in the array, bounds are controlled by if condition in for loop
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;

       for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0||j==0||i==n-1||j==m-1)
                {
                    if(grid[i][j]==0)
                    {
                        dfs(i,j,grid,n,m);
                    }
                }
            }
        }

       for(int i=0;i<n;i++)
       {
           for(int j=0;j<m;j++)
           {
               if(grid[i][j]==0)
               {
                   grid[i][j]=1;
               }
               else if(grid[i][j]==5)
               {
                   grid[i][j]=0;
               }
           }
       }


    }
    public static void dfs(int i,int j,int[][] board,int n,int m)
    {
        board[i][j]=5;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir:dirs)
        {
            int x=i+dir[0];
            int y=j+dir[1];
            if(x>=0 && y>=0 && x<n && y<m && board[x][y]==0)
            {
                dfs(x,y,board,n,m);
            }
        }
    }
}

/*
* 4
4
1 1 1 1
1 0 0 1
1 1 0 1
1 0 1 1
1	1	1	1
1	1	1	1
1	1	1	1
1	0	1	1
*
*
*
*
7
7
0 1 1 1 1 1 1
0 1 1 1 0 0 1
1 0 0 1 1 1 1
1 1 0 1 0 0 1
0 0 0 1 1 0 1
1 1 1 1 1 0 1
1 1 0 1 1 1 1
0	1	1	1	1	1	1
0	1	1	1	1	1	1
1	0	0	1	1	1	1
1	1	0	1	1	1	1
0	0	0	1	1	1	1
1	1	1	1	1	1	1
1	1	0	1	1	1	1	*/