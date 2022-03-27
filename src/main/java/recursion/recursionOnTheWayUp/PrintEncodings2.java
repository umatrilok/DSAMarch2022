package recursion.recursionOnTheWayUp;

import java.util.Scanner;

public class PrintEncodings2 {

    public static void main(String[] args) {

        Scanner sc =  new Scanner(System.in);
        String str=sc.next();

        printEncodings(str,"");
    }
    public static void printEncodings(String qstn,String ans)
    {
        if(qstn.length()==0)
        {
            System.out.println(ans);
            return;
        }

        if(qstn.charAt(0)!='0' && qstn.length()>=1) {
            int solve1=Integer.parseInt(qstn.substring(0,1));
            String ans1 = (char) ('a' - 1 + solve1) + "";

            printEncodings(qstn.substring(1), ans + ans1);


        }

        if(qstn.charAt(0)!='0' && qstn.length()>=2)
        {
            int solve2=Integer.parseInt(qstn.substring(0,2));
            if(solve2>=1 && solve2<=26) {
                String ans2 = (char) ('a' - 1 + solve2) + "";//output is an alphabet
                printEncodings(qstn.substring(2), ans + ans2);
            }

        }


    }
}
