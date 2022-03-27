package AdvancedDataStructure.Graphs;

import java.io.*;
import java.util.*;
public class GetConnectedComponents_DFS {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    public static void addEdge(int v1,int v2,int wt,ArrayList<Edge>[] graph)
    {
        graph[v1].add(new Edge(v1, v2, wt));
        graph[v2].add(new Edge(v2, v1, wt));
    }
    public static void dfs(int src,boolean[] vis,ArrayList<Edge>[] graph,ArrayList<Integer>comp)
    {
        vis[src]=true;
        comp.add(src);

        for(Edge e:graph[src])
        {
            int nbr=e.nbr;
            if(!vis[nbr])
            {
                dfs(nbr,vis,graph,comp);
            }
        }
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

        boolean[] visited=new boolean[vtces];

        // write your code here
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();


        for(int i=0;i<vtces;i++)
        {
            if(visited[i]==false)
            {
                ArrayList<Integer> comp = new ArrayList<>();//components
                dfs(i,visited,graph,comp);
                comps.add(comp);
            }
        }
        System.out.println(comps);

    }

}
/*
* 12
8
1 2 10
2 3 10
3 4 10
4 1 10
5 6 10
5 7 10
7 11 10
9 10 10
[[0], [1, 2, 3, 4], [5, 6, 7, 11], [8], [9, 10]]
* */

/*
* 7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10
[[0, 1], [2, 3], [4, 5, 6]]*/