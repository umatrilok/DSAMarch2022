package functionsArrays;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr=new int[n];
        //inputs must be sorted in Binary Search
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int x =sc.nextInt();//element to search

        int si=0;//starting index
        int ei=arr.length-1;//ending index
        int ans =-1;
        while(si<=ei)//si!=ei, si<ei
        {
            int mid=(si+ei)/2;
            if(arr[mid]==x)
            {
                ans=mid;
                break;//breaks when si=ei
            }
            if(arr[mid]<x){
                si=mid+1;
            }else if(arr[mid]>x)
            {
                ei= mid-1;
            }
        }

    }
}
