package recursion.recursionInArrays;

import java.util.Scanner;

public class DisplayArrayInReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        displayArray(arr,0);//index is 0 always
        //expectation:display array elements in reverse
        //

    }

    public static void displayArray(int[] arr, int idx)
    {
        if(idx==arr.length)
            return;
        displayArray(arr,idx+1);//faith:display array element from idx+1 to 6th element
        System.out.println(arr[idx]);//our work:idx is 0(first element is our work)
    }
//expectation:display array elements

}
