package functionsArrays;

import java.util.Scanner;

public class FirstIndexLastIndex {
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
        //System.out.println("reading finished");

        int si=0;//starting index
        int ei=arr.length-1;//ending index
        int fi =-1;

        while(si<=ei)//si!=ei, si<ei
        {
            int mid=(si+ei)/2;
            if(arr[mid]==tar)
            {
                fi=mid;
                ei=mid-1;
            }
            if(arr[mid]<tar){
                si=mid+1;
            }else if(arr[mid]>tar)
            {
                ei= mid-1;
            }
        }

         si=0;//starting index
         ei=arr.length-1;//ending index
         int li =-1;


        while(si<=ei)//si!=ei, si<ei
        {
            int mid=(si+ei)/2;
            if(arr[mid]==tar)
            {
                li=mid;
                si=mid+1;
                //li move right

            }
            if(arr[mid]<tar){
                si=mid+1;
            }else if(arr[mid]>tar)
            {
                ei= mid-1;
            }
        }
        System.out.println(fi);
        System.out.println(li);
    }
}
