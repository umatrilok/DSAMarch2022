package JSP;

import java.util.Scanner;

public class Pattern5 {


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        int stars=1;//starting
        int spaces=n/2;//starting

        for(int i=1;i<=n;i++)
        {
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
                stars=stars-2;
                spaces++;
            }
            else{
                stars=stars+2;
                spaces--;
            }


        }
    }

}
