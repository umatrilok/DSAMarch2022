package strings;

import java.util.Scanner;

public class PrintAllPallindromicSubstrings {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        solution(str);
    }
    public static void solution(String str)
    {
        String s= str;
        for(int si=0;si<str.length();si++)
        {
            for(int ei=si+1;ei<=str.length();ei++)
            {
                String sub= str.substring(si,ei);

                if(isPallindrome(sub))
                {
                    System.out.println(sub);
                }
            }
        }
    }
    public static boolean isPallindrome(String sub)
    {
        int i=0;
        int j=sub.length()-1;
        while(i<j)
        {
            if(sub.charAt(i)!=sub.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

/*
*
input:
abcc
output:
a
b
c
cc
c
* */