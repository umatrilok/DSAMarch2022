package AdvancedDataStructure.Graphs;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
public class Matrix01_BFS {
    public static int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        LinkedList<Integer> que=new LinkedList<>();

        int[][] ans=new int[n][m];

        for(int[] e:ans){
            Arrays.fill(e,-1); // -1 -> unvisited
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    que.addLast(i*m+j);
                    ans[i][j]=0;
                }
            }
        }

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

                    if(x>=0 && y>=0 && x<n && y<m && ans[x][y]==-1){
                        que.addLast(x*m+y);
                        ans[x][y]=level+1;
                    }
                }
            }
            level++;
        }

        return ans;
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

        int [][] x =updateMatrix(grid);
        for(int a[] : x)
        {
            for(int b:a)
            {
                System.out.print(b+"\t");
            }
            System.out.println();
        }
    }
}
/*
3
3
0 0 0
0 1 0
0 0 0
0	0	0
0	1	0
0	0	0	*/

/*
3
3
0 0 0
0 1 0
1 1 1
0	0	0
0	1	0
1	2	1	*/