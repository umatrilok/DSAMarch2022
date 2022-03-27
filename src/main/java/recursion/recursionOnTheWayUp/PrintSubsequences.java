package recursion.recursionOnTheWayUp;

public class PrintSubsequences {
    public static void main(String[] args) {
        printSubsequences("abc","");
    }
    public static void printSubsequences(String qstn,String ans)
    {
        if(qstn.length()==0)
        {
            System.out.println("ans:"+ans);
            return;
        }
        char firstChar=qstn.charAt(0);
        String ansNotInc=ans;
        String ansInc=ans+firstChar;
        printSubsequences(qstn.substring(1),ansInc);
        printSubsequences(qstn.substring(1),ansNotInc);

    }
}
