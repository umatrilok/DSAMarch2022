//union find

package AdvancedDataStructure.Graphs.UnionFind;
import java.util.ArrayList;

class  DSU {
   static int[] parent;
    static int[] size;

    public static int findParent(int u){
        if(parent[u]==u) return u;

        int p=findParent(parent[u]);

        parent[u]=p;

        return p;
    }

    public static void merge(int p1, int p2){
        if(size[p1]>=size[p2]){
            parent[p2]=p1;
            size[p1]+=size[p2];
        } else {
            parent[p1]=p2;
            size[p2]+=size[p1];
        }
    }


    public  static ArrayList<Integer>[] createSpanningTree(int V, int[][] edges){
        ArrayList<Integer>[] graph=new ArrayList[V];

        for(int i=0; i<V; i++){
            graph[i]=new ArrayList<>();
        }

        parent=new int[V];
        size=new int[V];

        for(int i=0; i<V; i++){
            parent[i]=i;
            size[i]=1;
        }

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            int p1=findParent(u);
            int p2=findParent(v);

            if(p1!=p2){
                merge(p1,p2);
                addEdge(graph,u,v);
            }
        }

        return graph;

    }

    public static void addEdge(ArrayList<Integer>[] graph, int u, int v){
        graph[u].add(v);
        graph[v].add(u);
    }

    public static void main(String[] args){
        int[][] edges=new int[14][14];
        edges[0][0]=6; edges[0][1]=7;
        edges[1][0]=6; edges[1][1]=5;
        edges[2][0]=2; edges[2][1]=5;
        edges[3][0]=0; edges[3][1]=1;
        edges[4][0]=6; edges[4][1]=8;
        edges[5][0]=7; edges[5][1]=8;
        edges[6][0]=2; edges[6][1]=3;
        edges[7][0]=0; edges[7][1]=7;
        edges[8][0]=1; edges[8][1]=2;
        edges[9][0]=5; edges[9][1]=4;
        edges[10][0]=1; edges[10][1]=7;
        edges[11][0]=2; edges[11][1]=8;
        edges[12][0]=3; edges[12][1]=4;
        edges[13][0]=3; edges[13][1]=5;

        ArrayList<Integer>[] graph =createSpanningTree(14,edges);

        System.out.println("Solution");
        for(ArrayList<Integer> x:graph)
        {
            for(int y:x)
            {
                System.out.print(y+"\t");
            }
            System.out.println();
        }

    }
}