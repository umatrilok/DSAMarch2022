package AdvancedDataStructure.Graphs;
import java.io.*;
        import java.util.*;

public class HasPath_DFS {
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
    public static void addEdge(int v1,int v2,int wt,ArrayList<Edge>[] graph)
    {
        graph[v1].add(new Edge(v1, v2, wt));
        graph[v2].add(new Edge(v2, v1, wt));
    }

    public static boolean hasPath(int src,int des,ArrayList<Edge>[] graph,boolean[] vis)
    {
        if(src==des)
        {
            return true;
        }
        vis[src]=true;
        for(Edge e:graph[src])
        {
            int nbr=e.v2;
            if(!vis[nbr])
            {
                if(hasPath(nbr,des,graph,vis))
                    return true;
            }
        }
        return false;
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

        System.out.println( hasPath(src,dest,graph,vis));

    }

}

/*
input:
7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
0
6
output:
true*/