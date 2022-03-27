package functionsArrays;

import java.util.Scanner;

public class SubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] a = new int[n];
        int i=0;
        while(i<n)
        {
            a[i]= sc.nextInt();
            i++;
        }
        for(int si=0;si<n;si++)
        {
            for(int ei=si;ei<n;ei++)
            {
                for(int k=si;k<=ei;k++)
                {
                    System.out.print(a[k]+"\t");
                }
                System.out.println();
            }

        }

    }
}
