package AdvancedDataStructure.Graphs;
import java.util.ArrayList;
import java.util.List;

public class FindEventfulSafeNodes_DFS {

    public static boolean dfs(int src,ArrayList<ArrayList<Integer>>graph,int[] vis){
            vis[src] = 1;
            for (int nbr : graph.get(src)) {
                if (vis[nbr] == 0) {
                    boolean cycle = dfs(nbr, graph, vis);
                    if (cycle) return true;
                } else if (vis[nbr] == 1) {
                    return true;
                }
            }
            vis[src] = 2;
            return false;
    }
    public static List<Integer> eventualSafeNodes(int V, ArrayList<ArrayList<Integer>> graph) {
        int[] vis = new int[V];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                boolean cycle  = dfs(i, graph, vis);
                if (cycle == false) {
                    ans.add(i);
                }
                //there is change here from Topological Sort
            }
            else if (vis[i] == 2) {
                ans.add(i);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
       ArrayList<ArrayList<Integer>> bal= new ArrayList<>();
        //0
        ArrayList<Integer> sal = new ArrayList<>();
        sal.add(1);
        sal.add(2);
        bal.add(sal);
        //1
        sal=new ArrayList<>();
        sal.add(2);
        sal.add(3);
        bal.add(sal);
        //2
        sal=new ArrayList<>();
        sal.add(5);
        bal.add(sal);
        //3
        sal=new ArrayList<>();
        sal.add(0);
        bal.add(sal);
        //4
        sal=new ArrayList<>();
        sal.add(5);
        bal.add(sal);
        //5
        sal=new ArrayList<>();
        bal.add(sal);
        //6
        sal=new ArrayList<>();
        bal.add(sal);


        System.out.println(bal);
        List<Integer> ans=eventualSafeNodes(bal.size(),bal);
        System.out.println(ans);
    }
}
/*
*
[[1, 2], [2, 3], [5], [0], [5], [], []]
[2, 4, 5, 6]*/