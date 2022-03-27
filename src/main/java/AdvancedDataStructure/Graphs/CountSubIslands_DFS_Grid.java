package AdvancedDataStructure.Graphs;

import java.util.Scanner;

public class CountSubIslands_DFS_Grid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid1=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                grid1[i][j]=sc.nextInt();
            }
        }

        int[][] grid2=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                grid2[i][j]=sc.nextInt();
            }
        }

        System.out.println(countSubIslands(grid1,grid2));

        for(int[] x:grid2)
        {
            for(int y:x)
            {
                System.out.print(y+"\t");
            }
            System.out.println();
        }
    }


    public static int countSubIslands( int[][] grid1,int[][] grid2)
    {
        //base case is not needed here because we are travelling in the array, bounds are controlled by if condition in for loop
        int ans=0;
        int n=grid1.length;
        int m=grid2[0].length;

       for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid2[i][j]==1)
                {
                   boolean isSub=dfs(grid1,grid2,i,j,n,m);
                   if(isSub)
                   {
                       ans++;
                   }
                }
            }
        }

      return ans;


    }
    public static boolean dfs(int[][] grid1,int[][] grid2,int i,int j,int n,int m)
    {
        boolean ans =true;
        if(grid1[i][j]!=grid2[i][j])
        {
            ans = false;
        }
        grid2[i][j]=0;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir:dirs)
        {
            int x=i+dir[0];
            int y=j+dir[1];
            if(x>=0 && y>=0 && x<n && y<m && grid2[x][y]==1)
            {
                ans = ans && dfs(grid1,grid2,x,y,n,m);
            }
        }
        return ans;
    }
}

/*
5
5
1 1 1 0 0
0 1 1 1 1
0 0 0 0 0
1 0 0 0 0
1 1 0 1 1
5
5
1 1 1 0 0
0 0 1 1 1
0 1 0 0 0
1 0 1 1 0
0 1 0 1 0
3
5	5	0	0	0
0	0	0	0	0
0	0	0	0	0
0	0	0	0	0
0	0	0	0	0	*/