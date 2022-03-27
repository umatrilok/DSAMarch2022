package JSP;

import java.util.Scanner;

public class Pattern3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        //pattern3
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(i+j>=n+1)
                System.out.print("*\t");
                else
                    System.out.print("\t");
            }
            System.out.println();
        }
        //pattern4
        for(int i=1;i<=n;i++)
        {
            for(int j=n;j>0;j--)
            {
                if(i+j<=n+1)
                    System.out.print("*\t");
                else
                    System.out.print("\t");
            }
            System.out.println();
        }


    }
}
