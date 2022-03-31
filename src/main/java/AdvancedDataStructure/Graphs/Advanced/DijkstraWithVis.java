package AdvancedDataStructure.Graphs.Advanced;
import AdvancedDataStructure.Graphs.GetConnectedComponents_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraWithVis {
    public static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int v1, int v2, int w) {
            this.src = v1;
            this.nbr = v2;
            this.wt = w;
        }
    }

    public class Pair {
        int node;
        String psf;
        int wsf;

        public Pair(int node, String psf, int wsf) {
            this.node = node;
            this.psf = psf;
            this.wsf = wsf;
        }
    }

    public static void addEdge(int v1, int v2, int wt, ArrayList<Edge>[] graph) {
        graph[v1].add(new Edge(v1, v2, wt));
        graph[v2].add(new Edge(v2, v1, wt));
    }

    public int[] dijkstra(ArrayList<Edge>[] graph, int src) {

        int V = graph.length;

        int[] dis = new int[V];
        boolean[] vis = new boolean[V];

        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> {
            return a.wsf - b.wsf;
        });

        pq.add(new Pair(src, src + "", 0));

        while (pq.size() > 0) {
            Pair t = pq.remove();

            int node = t.node;
            String psf = t.psf;
            int wsf = t.wsf;

            if (vis[node]) continue;

            vis[node] = true;
            dis[node] = wsf;
            System.out.println("node:"+node+" psf:"+psf+" wsf:"+wsf);

            for (Edge e : graph[node]) {
                if (!vis[e.nbr]) {
                    pq.add(new Pair(e.nbr, psf + e.nbr, wsf + e.wt));
                }
            }
        }

        return dis;

    }

    public int[] dijkstra_better(ArrayList<Edge>[] graph, int src) {
        //Without visited
        int V = graph.length;

        int[] dis = new int[V];
        Arrays.fill(dis, (int) (1e8));


        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> {
            return a.wsf - b.wsf;
        });

        pq.add(new Pair(src, src + "", 0));
        dis[src] = 0;

        while (pq.size() > 0) {
            Pair p = pq.remove();

            int node = p.node;
            String psf = p.psf;
            int wsf = p.wsf;

            if (dis[node] < wsf) continue;

            System.out.println("");
            for (Edge e : graph[node]) {


                if (dis[e.nbr] > wsf + e.wt) {
                    dis[e.nbr] = wsf + e.wt;
                    System.out.println("node:"+node+" psf:"+psf+" wsf:"+(wsf+e.wt));

                    pq.add(new Pair(e.nbr, psf + e.nbr, wsf + e.wt));

                }
            }
        }

        return dis;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("Enter no.of nodes/vertices");
        int vtces = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        DijkstraWithVis obj = new DijkstraWithVis();
        System.out.println("Enter no.of Edges");
        int edges_count = sc.nextInt();
        for (int i = 0; i < edges_count; i++) {

            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            int wt = sc.nextInt();

            obj.addEdge(v1, v2, wt, graph);

        }
        int ans1[] = obj.dijkstra(graph, 0);
        for (int a : ans1) {
            System.out.println(a);
        }

        System.out.println("Dijkstra 2nd Way:");

        int ans2[] = obj.dijkstra_better(graph, 0);
        for (int a : ans2) {
            System.out.println(a);
        }
    }

}
/*
Enter no.of nodes/vertices
7
Enter no.of Edges
8
0 3 40
0 1 10
1 2 10
2 3 10
3 4 2
4 5 3
5 6 3
4 6 8
node:0 psf:0 wsf:0
node:1 psf:01 wsf:10
node:2 psf:012 wsf:20
node:3 psf:0123 wsf:30
node:4 psf:01234 wsf:32
node:5 psf:012345 wsf:35
node:6 psf:0123456 wsf:38
0
10
20
30
32
35
38
Dijkstra 2nd Way:

node:0 psf:0 wsf:40
node:0 psf:0 wsf:10

node:1 psf:01 wsf:20

node:2 psf:012 wsf:30

node:3 psf:0123 wsf:32

node:4 psf:01234 wsf:35
node:4 psf:01234 wsf:40

node:5 psf:012345 wsf:38

0
10
20
30
32
35
38

Process finished with exit code 0
*/