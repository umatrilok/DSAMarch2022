package JSP;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print("*\t");
            }
            System.out.println();
        }


        for(int i=n;i>0;i--)
        {
            for(int j=i;j>0;j--)
            {
                System.out.print("*\t");
            }
            System.out.println();
        }


        for(int i=0;i<n;i++)
        {
            for (int s=2*(n-i); s>=0; s--)
            {
//prints space between two stars
                System.out.print(" ");
            }

            for(int j=0;j<=i;j++)
            {
                System.out.print("*\t");
            }
            System.out.println();
        }

    }
}