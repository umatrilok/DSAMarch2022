package strings;
import java.io.*;
import java.util.*;

public class StringCompression {

    public static String compression1(String str) {
        // write your code here
        //remove count and repeat compression2
        return null;
    }
    public static String compression2(String str){


        // write your code here
        StringBuilder ans = new StringBuilder();
        int i = 0;


        while (i < str.length()) {
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                int j = i;
                int count = 0;
//when equal, do compression -->tell me what is the duplicate count
                while (j < str.length() && str.charAt(j) == str.charAt(i)) {
                    count++;
                    j++;
                }
                //when it is not equal
                ans.append(str.charAt(i));
                ans.append(count);
                i = j;
            } else {
                ans.append(str.charAt(i));
                i++;
            }

        }

        return ans.toString();
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(compression1(str));
        System.out.println(compression2(str));
    }

}
/*
   wwwxxxxtteeyxxx
null
w3x4t2e2yx3
*/