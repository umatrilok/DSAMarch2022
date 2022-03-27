package amazon;

//https://stackoverflow.com/questions/59762717/find-clusters-in-a-multidimensional-array-java
//DFS
public class FindClusterDFS
{
    public static void main(String[] args) {
        int myArr[][] = {
                {1, 1, 0, 0, 1},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0}
        };

        int myArr2[][] = {
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0}
        };


        System.out.println(findNumClusters(myArr2));
    }

    private static int findNumClusters(int[][] arr){
        int num_clusters = 0;


        System.out.println("length::arr.length::"+arr.length);
        System.out.println("length::arr[0].length::"+arr[0].length);
        for(int i=0;i<arr.length;++i){
            for(int j=0;j<arr.length;++j){
                if(arr[i][j] == 1){
                    dfs(arr,i,j,arr.length,arr[0].length);
                    System.out.println("num_clusters++:"+num_clusters++);;
                }
            }
        }

        // restore all ones
        for(int i=0;i<arr.length;++i){
            for(int j=0;j<arr.length;++j){
                if(arr[i][j] == -1) arr[i][j] = 1;
            }
        }

        return num_clusters;
    }

    private static void dfs(int[][] arr,int x,int y,int rows,int cols){
        System.out.println("checking if condition");
        if(x < 0 || x == rows || y < 0 || y == cols || arr[x][y] != 1) {
            System.out.println("x::"+x+" y::"+y+"returnFun");
            return;
        }
        //System.out.println("assignment"+"x:"+x+" y:"+y+" arr[x][y]:"+arr[x][y]);
        System.out.println("No return::assignemnt of -1 a["+x+"]["+y+"]");
        arr[x][y] = -1; // marking a cell as visited(will be restored later)

        System.out.println("x:"+x+" y:"+y+" arr[x][y]:"+arr[x][y]+"(dfs:x-1,y)"+" x-1::"+(x-1)+" y::"+y);
        dfs(arr,x-1,y,rows,cols);
        System.out.println("x:"+x+" y:"+y+" arr[x][y]:"+arr[x][y]+"(dfs:x+1,y)"+" x+1::"+(x+1)+" y::"+y);
        dfs(arr,x+1,y,rows,cols);
        System.out.println("x:"+x+" y:"+y+" arr[x][y]:"+arr[x][y]+"(dfs:x,y-1)"+" x::"+(x)+" y-1::"+(y-1));
        dfs(arr,x,y-1,rows,cols);
        System.out.println("x:"+x+" y:"+y+" arr[x][y]:"+arr[x][y]+"(dfs:x,y+1)"+" x::"+(x)+" y+1::"+(y+1));
        dfs(arr,x,y+1,rows,cols);


    }
}