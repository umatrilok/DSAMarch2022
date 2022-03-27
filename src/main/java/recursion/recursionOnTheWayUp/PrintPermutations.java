package recursion.recursionOnTheWayUp;

import java.util.Scanner;

public class PrintPermutations {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        String str=scn.nextLine();
        printPermutations(str,"");


    }

    public static void printPermutations(String qstn, String ans) {

        if(qstn.length()==0)
        {
            System.out.println(ans);
            return;
        }

        for(int i=0;i<qstn.length();i++)
        {
            char ch = qstn.charAt(i);
            System.out.println("qstn"+qstn+":"+i+":"+ch);
            String before_char = qstn.substring(0,i);
            String after_char = qstn.substring(i+1);

            String next = before_char+after_char;

            //System.out.println(before_char+"-"+after_char+"-"+next);
            printPermutations(next,ans+ch);

        }

    }

}
/*i/P:
abc
o/p:
abc
acb
bac
bca
cab
cba*/