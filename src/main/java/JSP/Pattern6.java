package JSP;

import java.util.Scanner;

public class Pattern6 {
    public static void main(String[] args) {


    Scanner scn = new Scanner(System.in);

    // write ur code here
    int n=scn.nextInt();
    int stars=n/2+1;//starting
    int spaces=1;//starting

        for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=stars;j++)
        {
            System.out.print("*\t");
        }

        for(int j=1;j<=spaces;j++)
        {
            System.out.print("\t");
        }

        for(int j=1;j<=stars;j++)
        {
            System.out.print("*\t");
        }


        System.out.println();

        if(i>=n/2 +1 ){
            stars++;
            spaces=spaces-2;
        }
        else{
            spaces=spaces+2;
            stars--;
        }


    }

    }
}
