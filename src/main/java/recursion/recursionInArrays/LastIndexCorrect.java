package recursion.recursionInArrays;

import java.util.Scanner;

public class LastIndexCorrect {
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
        int li_last= lastIndex(arr,idx+1,x);

        if(arr[idx]!=x)
        {
            return li_last;

        }
        else
        {
            if(li_last==-1)

            return idx;
            else
                return li_last;
        }
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
7*/
