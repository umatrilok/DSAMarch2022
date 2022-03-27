package AdvancedDataStructure.Graphs;
import java.util.*;
public class CourseSchedule2 {
    public boolean dfs(ArrayList<Integer>[] graph, int src, int[] vis,ArrayList<Integer> topo){
        vis[src]=1;

        for(int nbr:graph[src]){
            if(vis[nbr]==0){
                boolean cycle=dfs(graph,nbr,vis,topo);
                if(cycle) return true;
            } else if(vis[nbr]==1){
                return true;
            }
        }

        vis[src]=2;
        topo.add(src);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph=new ArrayList[numCourses];

        for(int i=0; i<graph.length; i++)
            graph[i]=new ArrayList<>();

        for(int[] edge:prerequisites){
            int a=edge[0];
            int b=edge[1];

            graph[a].add(b);
        }

        int[] vis=new int[numCourses];
        ArrayList<Integer> topo=new ArrayList<>();

        for(int i=0; i<vis.length; i++){
            if(vis[i]==0){
                boolean cycle=dfs(graph,i,vis,topo);
                if(cycle) return new int[]{};
            }
        }

        int[] ans=new int[numCourses];
        for(int i=0; i<ans.length; i++){
            ans[i]=topo.get(numCourses-i-1);
        }

        return ans;
    }
    public static void main(String[] args) {
        CourseSchedule2 obj = new CourseSchedule2();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no.of courses:");
        int x=sc.nextInt();
        System.out.println("Enter no.of edges:");
        int n = sc.nextInt();
        int m = 2;
        int[][] grid1=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                grid1[i][j]=sc.nextInt();
            }
        }

        int a[]=obj.findOrder(x,grid1);
        for(int p:a) {
            System.out.println(p);
        }
    }
}
/*
No cycle
Enter no.of courses:
5
Enter no.of edges:
5
0 1
0 2
1 3
1 4
3 4
0
2
1
3
4*/
/*
Has cycle
Enter no.of courses:
5
Enter no.of edges:
5
0 1
0 2
1 3
3 4
4 1

Process finished with exit code 0*/