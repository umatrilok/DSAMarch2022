package recursion.recursionOnTheWayUp;

public class PrintKCP {
    static String[] arr={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void main(String[] args) {
        printSubsequences("78","");
    }
    public static void printSubsequences(String qstn,String ans)
    {
        if(qstn.length()==0)
        {
            System.out.println("ans:"+ans);
            return;
        }
        char firstChar = qstn.charAt(0);
        int idx=Integer.parseInt(firstChar+"");
        String key=arr[idx];

        for(int i=0;i<key.length();i++) {
            printSubsequences(qstn.substring(1), ans+key.charAt(i)+"");
        }


    }
}
