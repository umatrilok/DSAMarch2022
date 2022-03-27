package recursion.recursionInArrays;

import java.util.Scanner;
//this is still first index program, but on the 1st way
public class LastIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int x=sc.nextInt();
        System.out.println(lastIndex( arr, 0,x));
    }
    public static int lastIndex(int[] arr,int idx,int x)
    {
        if(idx==arr.length)
        {
            return -1;
        }
        if(arr[idx]==x )//pre, this can be post also
            // comparision is happening while going up, which is better for last index
            //if you get same x element in smaller index, it is better than the previous
            return idx;

          int li_last=lastIndex(arr,idx+1,x);
                //li_last;
       //int li_last=lastIndex(arr,idx+1,x);
        return li_last;



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
4*/
