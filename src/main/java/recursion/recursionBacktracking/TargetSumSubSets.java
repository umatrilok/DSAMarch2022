package recursion.recursionBacktracking;

import java.util.Scanner;

public class TargetSumSubSets {

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
        if(sos>tar)//if we have this complete tree will not be explored till end
        {          // if sum is greater, that portion of tree will not be explored
            return;
        }

        //include
        printTargetSumSubsets(arr, idx + 1, asf+arr[idx]+", ", sos + arr[idx ], tar);
        //not include
        printTargetSumSubsets(arr, idx+1, asf , sos , tar);


    }
}
/*
4
10
20
30
40
60
10, 20, 30, .
20, 40, .
*/