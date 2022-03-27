package recursion.recursionWithArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class GetSubsequence {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        ArrayList<String> ans=getss(str);
        System.out.println(ans);
    }

    public static ArrayList<String> getss(String str)
    {
        if(str.length()==0)
        {
            ArrayList<String> al = new ArrayList<>();
            al.add("");
            return al;
        }
        ArrayList<String> sans = getss(str.substring(1));//remove first char

        char first_char=str.charAt(0);

        ArrayList<String> ans = new ArrayList<>();

        //not including
        for(int i=0;i<sans.size();i++)
        {
            String s=sans.get(i);
            ans.add(s);
        }

        //including first char
        for(int i=0;i<sans.size();i++)
        {
            String s =sans.get(i);
            s=first_char+s;
            ans.add(s);
        }
        return ans;
    }
}
/*abc
[, c, b, bc, a, ac, ab, abc]*/