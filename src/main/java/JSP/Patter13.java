package JSP;

import java.util.Scanner;

public class Patter13 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();

        for(int i=0;i<n;i++)
        {
            int val1=1;
            for(int j=0;j<=i; j++)
            {
                //if (j==0||j==n-1)
                    //System.out.println(val1+"\t");
                System.out.print(val1+"\t");
                 val1=val1*(i-j)/(j+1);

            }
            System.out.println();
        }
    }
}
