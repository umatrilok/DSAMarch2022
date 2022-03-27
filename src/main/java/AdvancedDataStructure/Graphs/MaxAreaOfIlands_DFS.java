package AdvancedDataStructure.Graphs;

import java.util.Scanner;

public class MaxAreaOfIlands_DFS {
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
        maxAreaOfIsland(grid);

    }

    public static int maxAreaOfIsland(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    int size=dfs(i,j,grid);
                    ans=Math.max(ans,size);
                }
            }
        }

        return ans;
    }
    public static int dfs(int i,int j, int[][] grid)
    {
        //base case is not needed here because we are travelling in the array, bounds are controlled by if condition in for loop
        int n=grid.length;
        int m=grid[0].length;
        int size=0;
        grid[i][j]=0;
        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] dir:dirs)
        {
            int x=i+dir[0];
            int y=j+dir[1];
            if(x>=0 && y>=0 && x<n && y<m &&  grid[x][y]==1)//must follow same order as we don't want to face array index out of bounds
            {
                size += dfs(x,y,grid);
            }
        }
        return size+1;
    }
}