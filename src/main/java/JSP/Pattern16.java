package JSP;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.Scanner;

public class Pattern16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int star=1,space=2*n-3;

        for(int i=1;i<=n;i++)
        { int val=1;
            for(int j=1;j<=star;j++)
            {
                System.out.print(val+++"\t");

            }
            for(int j=1;j<= space;j++)
            {
                System.out.print("\t");
            }
            if(i==n)
            {
                val=val-2;
            }else
            val=val-1;
            for(int j=1;j<=star;j++)
            {
                if(!(i==n&&j==star))
                System.out.print(val--+"\t");
            }
            System.out.println();

            space=space-2;
            star++;
        }
    }
}
