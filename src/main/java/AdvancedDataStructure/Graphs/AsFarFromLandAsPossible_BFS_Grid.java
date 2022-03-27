package AdvancedDataStructure.Graphs;

import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class AsFarFromLandAsPossible_BFS_Grid {
    public static int maxDistance(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        LinkedList<Integer> que=new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    que.addLast(i*m+j);
                }
            }
        }

        if(que.size()==n*m) return -1;
        if(que.size()==0) return -1;

        int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};

        int level=0;
        while(que.size()>0){
            int size=que.size();

            while(size-->0){
                int idx=que.removeFirst();

                int i=idx/m;
                int j=idx%m;

                for(int[] dir:dirs){
                    int x=i+dir[0];
                    int y=j+dir[1];

                    if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==0){
                        que.addLast(x*m+y);
                        grid[x][y]=1;
                    }
                }
            }
            level++;
        }

        return level-1;
    }

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

        System.out.println(maxDistance(grid));
    }
}
/*
3
3
1 0 0
0 0 0
0 0 0
(2,2)
4*/

/*
3
3
1 0 1
0 0 0
1 0 1
(1,1)
2
*/
/*
3
4
1 0 0 1
0 0 0 0
1 0 0 1
2*/