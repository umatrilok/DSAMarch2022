package AdvancedDataStructure.Graphs.UnionFind;

import AdvancedDataStructure.Graphs.CourseSchedule;

import java.util.Scanner;

//Leet-684
public class RedundantConnections {
    int[] par;
    int[] size;

    public int findPar(int u){
        if(par[u]==u) return u;
        return par[u]=findPar(par[u]);
    }

    public void merge(int p1, int p2){
        if(size[p1]>=size[p2]){
            par[p2]=p1;
            size[p1]+=size[p2];
        } else {
            par[p1]=p2;
            size[p2]+=size[p1];
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        par=new int[n];
        size=new int[n];

        for(int i=0; i<n; i++){
            par[i]=i;
            size[i]=1;
        }

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            int p1=findPar(u);
            int p2=findPar(v);

            if(p1!=p2){
                merge(p1,p2);
            } else {
                return edge;
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        RedundantConnections obj = new RedundantConnections();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no.of nodes:");
        int x=sc.nextInt();
        System.out.println("Enter no.of edges:");
        int n = sc.nextInt();
        int m = 2;
        int[][] grid1=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                grid1[i][j]=sc.nextInt();
            }
        }

        int a[]=obj.findRedundantConnection(grid1);
        System.out.println("Output:");
        for(int p:a) {
            System.out.print(p+"\t");
        }
    }
}
/*
Enter no.of nodes:
5
Enter no.of edges:
5
0 1
1 2
2 3
3 1
4 1
Output:
3	1	*/


/**
 * Enter no.of nodes:
 * 5
 * Enter no.of edges:
 * 5
 * 0 1
 * 1 2
 * 2 3
 * 3 0
 * 4 0
 * Output:
 * 3	0
 */
