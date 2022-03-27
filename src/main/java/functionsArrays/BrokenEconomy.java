package functionsArrays;

import java.util.Scanner;

public class BrokenEconomy {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr=new int[n];
        //inputs must be sorted in Binary Search
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }

        int tar =sc.nextInt();//element to search

        int si=0;//starting index
        int ei=arr.length-1;//ending index
        int floor =-1;
        int ceil =-1;

        while(si<=ei)
        {
            int mid=(si+ei)/2;

            if(arr[mid]==tar)
            {
                floor=mid;
                ceil=mid;
            }

            if(arr[mid]<tar){
                si=mid+1;
                floor=mid-1;
                ceil=mid;
            }else if(arr[mid]>tar)
            {
                ei= mid-1;
                floor=mid-1;
                ceil=mid;
            }
        }

        System.out.println(arr[floor]);
        System.out.println(arr[ceil]);
    }
}
