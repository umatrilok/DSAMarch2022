package recursion.recursionInArrays;

import java.util.Scanner;

public class AllIndicesOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        int x= sc.nextInt();

        int[] p = indexFunction(arr,0,3,0);
        for (int z: p ) {
            System.out.println("index of 3:"+z);
        }
    }

    public static int[] indexFunction(int arr[],int idx,int x,int count_so_far)
    {
        if(arr.length==idx)
        {
            int[] indices = new int[count_so_far];
            return indices;
        }

        if(arr[idx]==x)
        {   int[] ans=   indexFunction(arr,idx+1,x,count_so_far+1);
            ans[count_so_far]=idx;
            return ans;
        }
        else {
            int[] sol=  indexFunction(arr, idx + 1, x, count_so_far);
            return sol;
        }

    }
}
/*12
2
4
3
3
5
3
2
3
2
3
3
9
3
index of 3:2
index of 3:3
index of 3:5
index of 3:7
index of 3:9
index of 3:10*/