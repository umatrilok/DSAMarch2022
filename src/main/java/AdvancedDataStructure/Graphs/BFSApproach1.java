package AdvancedDataStructure.Graphs;
//Faster Approach// Visit marked on insertion


import java.util.*;
public class BFSApproach1 {

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
        static class Pair{
            int node;
            String psf;
            Pair(int node,String psf)
            {
                this.node=node;
                this.psf=psf;
            }
        }
        public static void addEdge(int v1,int v2,int wt,ArrayList<Edge>[] graph)
        {
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

       public static void bfs(int src, ArrayList<Edge>[] graph)
       {
           LinkedList<Pair> que= new LinkedList<>();
           int vtces=graph.length;
           boolean[] vis=new boolean[vtces];
           que.addLast(new Pair(src,src+""));
           System.out.println(src+"@"+src);

           while (que.size()>0)
           {
               int size=que.size();
               while (size-->0)//all children of above level parents should be covered//level order line wise
               {
                   Pair t=que.removeFirst();
                   int node=t.node;
                   String psf=t.psf;


                   for(Edge e:graph[node])
                   {
                       int nbr=e.nbr;
                       if(!vis[nbr])
                       {
                           que.addLast(new Pair(nbr,psf+nbr));
                           System.out.println(nbr+"@"+psf+nbr);
                           vis[nbr]=true;
                       }
                   }
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


            int src = sc.nextInt();

            // write your code here

            bfs(src,graph);

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
2
2@2
1@21
3@23
0@210
2@212
4@234
5@2345
6@2346*/