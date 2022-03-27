package amazon;


public class FindCluster
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
                {1, 2, 4, 6, 0},
                {1, 2, 3, 0, 0},
                {4, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };


       // System.out.println(findNumClusters(myArr));
    }
    public void findClusters(int[][] clusters)
    {
        int isLast,isFirst;
        int count;
        for(int i=0;i<clusters.length;i++ ){
        count=0;
        for (int j = 0; j < clusters.length; j++) {
            if (clusters[i][j] == 1) {
                count++;
            }
            else if(count>0)
            {
                count=0;
                System.out.println("last node"+j);
            }
        }

    }



    }
}
