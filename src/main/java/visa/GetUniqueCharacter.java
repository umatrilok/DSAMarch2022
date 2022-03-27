package visa;

import java.util.ArrayList;
import java.util.List;


//A unique character is one which appears only once in a string. Given a string consisting
//of lowercase English letters only, return the index of the first occurence of a unique character
//in the string using 1-based indexing. If the string does not contain any unique character, return -1.

//Example:
//str = "statistics"
//The unique characters are [a,c] among which a occurs first. Using 1-based indexing, it is at index 3
public class GetUniqueCharacter {

    public static void main(String[] args) {

        GetUniqueCharacter obj= new GetUniqueCharacter();
        obj.getUniqueCharacter("hackthegame");//give 74000 and try
    }
    void getUniqueCharacter(String str)
    {


        int[] count = new int[256];

        /* Count array with frequency of characters */
        int i;
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                count[(int) str.charAt(i)]++;
                System.out.println("str.charAt(i):"+str.charAt(i)
                        +"(int) str.charAt(i):"+(int) str.charAt(i));
            }
        }

        int n = i;

        // Print characters having count more than 0
        System.out.println();
        for (i = 0; i < n; i++)
            if (count[(int)str.charAt(i)] == 1) {
                System.out.println(i+1);
                break;
            }





    }
}
