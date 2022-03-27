package AdvancedDataStructure.Graphs;

import java.util.*;
public class CourseSchedule {
    public boolean dfs(ArrayList<Integer>[] graph, int src, int[] vis){
        vis[src]=1;

        for(int nbr:graph[src]){
            if(vis[nbr]==0){
                boolean cycle=dfs(graph,nbr,vis);
                if(cycle) return true;
            } else if(vis[nbr]==1){
                return true;
            }
        }
        vis[src]=2;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph=new ArrayList[numCourses];

        for(int i=0; i<graph.length; i++)
            graph[i]=new ArrayList<>();

        for(int[] edge:prerequisites){
            int a=edge[0];
            int b=edge[1];//b is the prerequisite

            graph[a].add(b);
            System.out.println("prereq-b:"+b+"  a:"+a);
        }

        int[] vis=new int[numCourses];
        // ArrayList<Integer> topo=new ArrayList<>()

        for(int i=0; i<vis.length; i++){
            if(vis[i]==0){
                boolean cycle=dfs(graph,i,vis);
                if(cycle) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CourseSchedule obj = new CourseSchedule();
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

        System.out.println(obj.canFinish(x,grid1));
    }
}
/*
Enter no.of courses:
2
Enter no.of edges:
1
0 1
prereq-b:1  a:0
true*/

/*
Enter no.of courses:
2
Enter no.of edges:
1
1 0
prereq-b:0  a:1
true
*/

/*
Enter no.of courses:
2
Enter no.of edges:
2
1 0
0 1
prereq-b:0  a:1
prereq-b:1  a:0
false*/


/*
Enter no.of courses:
5
Enter no.of edges:
5
0 1
0 2
1 3
1 4
3 4
prereq-b:1  a:0
prereq-b:2  a:0
prereq-b:3  a:1
prereq-b:4  a:1
prereq-b:4  a:3
true*/

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
prereq-b:1  a:0
prereq-b:2  a:0
prereq-b:3  a:1
prereq-b:4  a:3
prereq-b:1  a:4
false*/