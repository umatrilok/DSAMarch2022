package JSP;

import java.util.Scanner;

public class Pattern11 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int p=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print(p+++"\t");
            }
            System.out.println();
        }
    }
}
