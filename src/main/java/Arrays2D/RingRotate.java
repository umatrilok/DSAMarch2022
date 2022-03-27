package Arrays2D;

public class RingRotate {
    public static void main(String[] args) {
        //get 1d array

        //rotate 1d array

        //fill 1d array
    }

    public  static  int[] getOneD(int[][] arr,int s)
    {
        int rmin=s-1;
        int rmax=arr.length-s;
        int cmin=s-1;
        int cmax=arr[0].length-s;

        int r_ele=rmax-rmin+1;
        int c_ele=cmax-cmin+1;

        int total_ele=2*r_ele+2*c_ele -4;

        int[] ans = new int[total_ele];
        int idx=0;

        //left wall
        for(int i=rmin;i<=rmax;i++)
        {
            ans[idx]=arr[i][cmin];
            idx++;
        }
        cmin++;

        //bottom wall
        for(int j=cmin;j<=cmax;j++)
        {
            ans[idx]=arr[rmax][j];
            idx++;
        }
        rmax--;

        //right wall
        for(int i=rmax;i>=rmin ; i--)
        {
            ans[idx]=arr[i][cmax];
            idx++;
        }
        cmax--;

        //top wall
        for(int j=cmax;j>=cmin;j--)
        {
            ans[idx]=arr[rmin][j];
            idx++;
        }
        rmin++;
        return ans;
    }
}
