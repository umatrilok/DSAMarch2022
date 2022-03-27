package JSP;

import org.apache.spark.sql.connector.read.Scan;

import java.util.Scanner;

public class Pattern8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        for(int i=n;i>0;i--)
        {
            for(int j=n;j>0;j--)
            {
                if(i+j==n+1)
                System.out.print("*\t");
                else
                    System.out.print("\t");
            }
            System.out.println();
        }
    }
}
