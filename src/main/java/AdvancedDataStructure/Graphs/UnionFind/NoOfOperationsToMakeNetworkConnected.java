package AdvancedDataStructure.Graphs.UnionFind;

import java.util.Scanner;

//leet 1319
public class NoOfOperationsToMakeNetworkConnected {
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

    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;

        par=new int[n];
        size=new int[n];

        for(int i=0; i<n; i++){
            par[i]=i;
            size[i]=1;
        }

        int comps=n;

        for(int[] edge:connections){
            int u=edge[0];
            int v=edge[1];

            int p1=findPar(u);
            int p2=findPar(v);

            if(p1!=p2){
                merge(p1,p2);
                comps--;
            }
        }

//         int comps=0;
//         for(int i=0; i<n; i++){
//             int p=findPar(i);
//             if(p==i) comps++;
//         }

        return comps-1;
    }

    public static void main(String[] args) {
        NoOfOperationsToMakeNetworkConnected obj = new NoOfOperationsToMakeNetworkConnected();
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


        System.out.println("Output:");
        System.out.println(obj.makeConnected(x,grid1));

    }
}
/*
Enter no.of nodes:
6
Enter no.of edges:
7
0 1
0 2
2 3
3 1
0 3
2 1
4 5
Output:
1
*/

/*
Enter no.of nodes:
6
Enter no.of edges:
5
0 1
0 2
0 3
1 2
1 3
Output:
2*/