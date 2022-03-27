package AdvancedDataStructure.Graphs;
import java.util.*;
public class IsBipartiteGraph {

    public static boolean isEvenBFS(ArrayList<Integer>[] graph, int src,int[] vis){
        LinkedList<Integer> que = new LinkedList<>();

        que.addLast(src);

        int color=0;

        while(que.size()>0){
            int size=que.size();

            while(size-->0){
                int t=que.removeFirst();

                if(vis[t]!=-1){
                    if(vis[t]!=color) return false;
                }

                vis[t]=color;

                for(int nbr:graph[t] ){
                   // if( nbr!=-20) {
                        if (vis[nbr] == -1) {
                            que.addLast(nbr);
                        }
                    //}
                }
            }
            color=(color+1)%2;
        }

        return true;

    }
    public static boolean isBipartite(int[][] graph) {

        int vtces=graph.length;

        ArrayList<Integer>[] myGraph = new ArrayList[vtces];

        for(int i=0; i<vtces;i++){
            myGraph[i]=new ArrayList<>();
        }

        for(int i=0;i<vtces;i++){
            for(int v:graph[i]){
               if(v!=-20) {
                    myGraph[i].add(v);
                }
            }
        }

        int[] vis=new int[vtces];
        Arrays.fill(vis,-1);

        for(int i=0;i<vtces;i++){
            if(vis[i]==-1){
                boolean even=isEvenBFS(myGraph,i,vis);
                if(even==false) return false;
            }
        }
        return true;
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
        System.out.println(isBipartite(grid));

    }
}

/*
*
index is the V1, v2 is value in respective row
* 4
3
1 2 3
0 2 -20
0 1 3
0 2 -20
false
* */
/*
*
4
2
1 3
0 2
1 3
0 2
true*/

