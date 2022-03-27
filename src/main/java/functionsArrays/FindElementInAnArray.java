package functionsArrays;

import java.util.Scanner;

public class FindElementInAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int d=sc.nextInt();
int temp=-1;
        for(int i=0;i<n;i++)
        {
            if(d==arr[i])
            { temp=i;
                break;}
        }
        System.out.println(temp);

    }
}
