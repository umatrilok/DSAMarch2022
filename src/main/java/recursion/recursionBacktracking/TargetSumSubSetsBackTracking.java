package recursion.recursionBacktracking;

import java.util.Scanner;

public class TargetSumSubSetsBackTracking {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int tar=sc.nextInt();
        printTargetSumSubsets(arr,0,"",0,tar);
    }

    // asf is the subset--ans so far
    // sos is sum of subset-- sum so far
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String asf, int sos, int tar) {
        if (idx == arr.length) {
            if (sos == tar) {
                System.out.println(asf + ".");
            }
            return;
        }
        if(sos>tar)//if we have this all paths will not be explored till end
        {
            return;
        }

        //include
        sos+=arr[idx];
        printTargetSumSubsets(arr, idx + 1, asf+arr[idx]+", ", sos , tar);

        //not include
        sos-=arr[idx];
        printTargetSumSubsets(arr, idx+1, asf , sos , tar);
    //}

    }
}
/*
*
5
10
20
30
40
50
60
10, 20, 30, .
10, 50, .
20, 40, .*/