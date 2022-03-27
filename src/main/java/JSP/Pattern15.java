package JSP;

import java.util.Scanner;

public class Pattern15 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        int stars=1;//starting
        int spaces=n/2;//starting

        int val=1;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=spaces;j++)
            {
                System.out.print("\t");
            }

            int val2=val;
            for(int j=1;j<=stars;j++)
            {   //System.out.print(val+"\t");
                //val=val*(i-j)*(j+1);
                if(j<stars/2+1)
                    System.out.print(val2+++"\t");
                else
                    System.out.print(val2--+"\t");

            }
            System.out.println();

            if(i>=n/2 +1 ){
                stars=stars-2;
                spaces++;
                val--;
            }
            else{
                stars=stars+2;
                spaces--;
                val++;
            }


        }
    }
}
