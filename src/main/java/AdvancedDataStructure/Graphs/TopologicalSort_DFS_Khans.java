package AdvancedDataStructure.Graphs;
//TopologicalSort GFG(Geek For Geeks)
//https://practice.geeksforgeeks.org/problems/topological-sort/1
//Did not understand
//

import java.util.ArrayList;

public class TopologicalSort_DFS_Khans {

    public static boolean dfs(int src,ArrayList<ArrayList<Integer> >graph,int[] vis,ArrayList<Integer> al){
       // if(vis[src]!=-20) {
            vis[src] = 1;
            for (int nbr : graph.get(src)) {
                if (vis[nbr] == 0) {
                    boolean cycle = dfs(nbr, graph, vis, al);
                    if (cycle) return true;
                } else if (vis[nbr] == 1) {
                    return true;
                }
            }
            vis[src] = 2;
            al.add(src);
            return false;
    }
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis= new int[V];

        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
               boolean cycle = dfs(i,adj,vis,al);
               if(cycle)
               {
                   System.out.println("No Solution!!!!");
               }
            }
        }

        int[] topo = new int[V];
        int j=0;
        for(int i=al.size()-1;i>=0;i--)
        {
            topo[j]=al.get(i);
            j++;
        }
        return topo;
    }

    public static void main(String[] args) {
       ArrayList<ArrayList<Integer>> bal= new ArrayList<>();
        //0
        ArrayList<Integer> sal = new ArrayList<>();
        bal.add(sal);
        //1
        sal=new ArrayList<>();
        sal.add(3);
        bal.add(sal);
        //2
        sal=new ArrayList<>();
        sal.add(3);
        bal.add(sal);
        //3
        sal=new ArrayList<>();
        bal.add(sal);
        //4
        sal=new ArrayList<>();
        bal.add(sal);
        //5
        sal=new ArrayList<>();
        sal.add(0);
        sal.add(2);
        bal.add(sal);

        System.out.println(bal);
        int a[]=topoSort(bal.size(),bal);
        for(int i:a)
        {
            System.out.println(i);
        }
    }
}
/*
[[], [3], [3], [], [], [0, 2]]
5
4
2
1
3
0*/