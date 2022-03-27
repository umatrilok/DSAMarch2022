package AdvancedDataStructure.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class SpreadOfAnInfection_BFS {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt){
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

    public static int bfs(int src, ArrayList<Edge>[] graph,int t)
    {
        LinkedList<Integer> que= new LinkedList<>();
        int vtces=graph.length;
        boolean[] vis=new boolean[vtces];
        int count=1;
        que.addLast(src);
        vis[src]=true;
        //visit on insertion
        int level=1;
        while (que.size()>0 && level<=t)
        {
            int size=que.size();
            while (size-->0)
            {
                int top=que.removeFirst();

                for(Edge e:graph[top])
                {
                    int nbr=e.nbr;
                    if(!vis[nbr])
                    {
                       vis[nbr]=true;
                       que.addLast(nbr);
                       count++;
                    }
                }
            }
            level++;

        }
        return count;
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


        int src = sc.nextInt();
        int t= sc.nextInt();

        // write your code here

        System.out.println("infection is spread to:"+bfs(src,graph,t));

    }
}
/*7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
6
3
output:
infection is spread to:6*/