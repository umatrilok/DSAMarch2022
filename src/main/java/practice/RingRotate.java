package practice;

import java.util.Scanner;

public class RingRotate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m=sc.nextInt();
        int[][] arr = new int[n][m];

        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                arr[i][j]=sc.nextInt();

        ringRotate(arr,1);
    }
    public static void ringRotate(int[][] arr,int k)
    {
        int rmin=k-1;
        int rmax=arr.length-k;
        int cmin=k-1;
        int cmax=arr[0].length-k;

        int oneD[] = new int[2*(cmax-cmin)+2*(rmax-rmin)];
        int count=0;
       while(count<2*Math.pow(2,k))
        {
            for(int j=rmin;j<=rmax;j++)
            {
                System.out.println(arr[j][cmin]+":1");
                oneD[count++]= arr[j][cmin];           ;

            }
            cmin++;
            for(int j=cmin;j<=cmax;j++)
            {
                System.out.println(arr[rmax][j]+":2");
                oneD[count++]=arr[rmax][j];
            }
            rmax--;
            for(int j=rmax;j>=rmin;j--)
            {
                System.out.println(arr[j][cmax]+":3");
                oneD[count++]=arr[j][cmax];
            }
            cmax--;
            for(int j=cmax;j>=cmin;j--)
            {
                System.out.println(arr[rmin][j]+":4");
                oneD[count++]=arr[rmin][j];
            }
        }
       int[] orig1D=rotate1D(oneD,k);
        ringRotate2(arr,orig1D,k);

    }
    public static void ringRotate2(int[][] arr,int[] orig1D,int k)
    {

        int rmin=k-1;
        int rmax=arr.length-k;
        int cmin=k-1;
        int cmax=arr[0].length-k;


        int count=0;
        while(count<2*Math.pow(2,k))
        {
            for(int j=rmin;j<=rmax;j++)
            {
                System.out.println(arr[j][cmin]+":1");
                 arr[j][cmin]=orig1D[count++];           ;

            }
            cmin++;
            for(int j=cmin;j<=cmax;j++)
            {
                System.out.println(arr[rmax][j]+":2");
                arr[rmax][j]=orig1D[count++];
            }
            rmax--;
            for(int j=rmax;j>=rmin;j--)
            {
                System.out.println(arr[j][cmax]+":3");
                arr[j][cmax]=orig1D[count++];
            }
            cmax--;
            for(int j=cmax;j>=cmin;j--)
            {
                System.out.println(arr[rmin][j]+":4");
                arr[rmin][j]=orig1D[count++];
            }
        }

        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }


    public static int[] rotate1D(int[] oneD,int k)
    {

       int[] oneD2= reverse(oneD,oneD.length-k,oneD.length-1);
        oneD2=reverse(oneD2,0,oneD.length-k-1)   ;
        oneD2=reverse(oneD2,0,oneD.length-1) ;
        for (int a:oneD2) {
            System.out.println(a);
        }
        //ringRotate2()
        return oneD2;
    }

    public static int[] reverse(int[] arr,int start,int end)
    {
        while(start<end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        return arr;
    }
}
