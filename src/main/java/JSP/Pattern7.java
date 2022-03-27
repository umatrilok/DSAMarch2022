package JSP;

import java.util.Scanner;

public class Pattern7 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                if(i!=j)
                System.out.print("\t");
                else
                    System.out.print("*\t");

            }
            System.out.println();
        }



        for(int i=0;i<n;i++)
        {
            for(int j=n;j>=i;j--)
            {
                if(i==j)
                    System.out.print("*\t");
                else
                    System.out.print("\t");

            }
            System.out.println();
        }

        for(int i=n;i>0;i--)
        {
            for(int j=i;j>0;j--)
            {
                if(i+j==n+1)
                    System.out.print("*\t");
                else
                    System.out.print("\t");
            }
            n=n-1;
            System.out.println();
        }
    }
}
