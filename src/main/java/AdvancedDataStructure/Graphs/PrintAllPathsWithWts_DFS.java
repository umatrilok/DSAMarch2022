package AdvancedDataStructure.Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintAllPathsWithWts_DFS {
    static class Edge {
        int v1;
        int v2;
        int wt;

        Edge(int src, int nbr, int wt){
            this.v1 = src;
            this.v2 = nbr;
            this.wt = wt;
        }
    }
    public static void addEdge(int v1, int v2, int wt, ArrayList<Edge>[] graph)
    {
        graph[v1].add(new Edge(v1, v2, wt));
        graph[v2].add(new Edge(v2, v1, wt));
    }

    public static void printAllPaths(int src, int des, ArrayList<Edge>[] graph,String psf, boolean[] vis
    ,int wsf)
    {
        if(src==des)
        {
            System.out.println("Path:"+psf+", Total wt:"+wsf);
            return;
        }
        vis[src]=true;
        for(Edge e:graph[src])
        {
            int nbr=e.v2;
            int wt=e.wt;
            if(!vis[nbr])
            {
                printAllPaths(nbr,des,graph,psf+nbr,vis,wt+wsf);

            }
        }
        vis[src]=false;

    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);


        int vtces = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for(int i = 0; i < vtces; i++){
            graph[i] = new ArrayList<>();
        }

        int edges_count = sc.nextInt();
        for(int i = 0; i < edges_count; i++){

            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int wt = sc.nextInt();

            addEdge(v1,v2,wt,graph);

        }

        boolean[] vis=new boolean[vtces];
        int src = sc.nextInt();
        int dest = sc.nextInt();
        // write your code here

        printAllPaths(src,dest,graph,src+"",vis,0);

        System.out.println( );

    }

}

/*
7
9
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
2 5 5
0
6
Path:0123456, Total wt:38
Path:012346, Total wt:40
Path:012546, Total wt:36
Path:01256, Total wt:28
Path:032546, Total wt:66
Path:03256, Total wt:58
Path:03456, Total wt:48
Path:0346, Total wt:50
*/