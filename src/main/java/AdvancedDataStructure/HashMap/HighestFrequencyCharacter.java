package AdvancedDataStructure.HashMap;
import java.util.Scanner;
import java.util.*;

public class HighestFrequencyCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(map.containsKey(ch))
            {
                int old_fre=map.get(ch);
                map.put(ch,old_fre+1);
            }
            else{
                map.put(ch,1);
            }
        }
        char ans='#';
        int max_fre=0;
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            int fre=map.get(ch);
            if(fre>max_fre)
            {
                max_fre=fre;
                ans=ch;
            }
        }
        System.out.println(ans+" appeared "+max_fre+" times");
    }
}
/*
aaaaaabbbbbbbbbbbbbbbcccccccddddddddeeghhhhhhhhhhhhhhhhiij
        h appeared 16 times*/
