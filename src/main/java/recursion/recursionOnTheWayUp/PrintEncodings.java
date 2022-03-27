package recursion.recursionOnTheWayUp;

import java.util.Scanner;

public class PrintEncodings {

    public static void main(String[] args) {

        Scanner sc =  new Scanner(System.in);
        String str=sc.next();

        printEncodings(str,"");
    }
    public static void printEncodings(String qstn,String ans)
    {
        //System.out.println(Integer.parseInt("1"));

        if(qstn.length()==0)
        {
            System.out.println(ans);
            return;
        }
        if((qstn.charAt(0))=='0')
        {
            return;
        }

        for(int i=0;i<qstn.length();i++)
        {
            String solving = qstn.substring(0,i+1);
            String next = qstn.substring(i+1);
            int x=Integer.parseInt(solving);
            if(!(x>26))
            {
                int y=x+96;
                printEncodings(next,ans+(char)y);

            }
        }
    }
}
