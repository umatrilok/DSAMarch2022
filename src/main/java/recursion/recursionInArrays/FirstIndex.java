package recursion.recursionInArrays;

import java.util.Scanner;

public class FirstIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        int x=sc.nextInt();
        System.out.println(firstIndex( arr, 0,x));
    }
    public static int firstIndex(int[] arr,int idx,int x)
    {
        if(idx==arr.length)
        {
            return -1;
        }
       int fi_front=firstIndex(arr,idx+1,x);
       if(arr[idx]==x )//post, this can be pre also
           // comparision is happening while coming down, which is better for first index
           //if you get same x element in smaller index, it is better than the previous
           return idx;

       return  fi_front;
    }

}
/*8
1
2
4
6
3
5
3
3
3
4*/
