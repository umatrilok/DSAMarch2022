package AdvancedDataStructure.Graphs;

import java.util.Scanner;

public class NoOfIslandsWithoutVis_DFS_Grid {
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

       // boolean[][] vis = new boolean[n][m];
        int count_of_islands=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    dfs(i,j,grid);
                    count_of_islands++;
                }
            }
        }
        System.out.println("No.of Islands:"+count_of_islands);
    }
    public static void dfs(int i,int j, int[][] grid)
    {
        //base case is not needed here because we are travelling in the array bounds are controlled by if condition in for loop
        int n=grid.length;
        int m=grid[0].length;
        grid[i][j]=20;
        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] dir:dirs)
        {
            int x=i+dir[0];
            int y=j+dir[1];
            if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==1)
            {
                dfs(x,y,grid);
            }
        }
    }
}
/*
4
5
1 1 0 0 0
1 1 0 0 0
0 0 1 0 0
0 0 0 1 1
No.of Islands:3 */