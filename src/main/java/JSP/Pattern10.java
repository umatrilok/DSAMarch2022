package JSP;

import java.util.Scanner;

public class Pattern10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();

        int space1=n/2; int space2=-1;
        for(int i=1;i<=n;i++) {

            for(int j=1;j<=space1;j++)
            {
                System.out.print("#\t");
            }
            System.out.print("*\t");
            for(int j=1;j<=space2;j++)
            {
                System.out.print("#\t");
            }
            if(space2>0)//if i is not first row(0) and i is not n
                //i show not be first and last row
            System.out.print("*\t");
            if(i<n/2 +1)
            {
                space1--;
                space2=space2+2;
            }
            else
            {
                space1++;
                space2=space2-2;
            }
            System.out.println();

        }
    }
}
