package strings;



import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String  str = sc.next();
        System.out.println(toggleCase(str));


    }

    public static String toggleCase(String str)
    {
        StringBuilder ans = new StringBuilder();

        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(Character.isLowerCase(ch))
            {
                ans.append(Character.toUpperCase(ch));
            }
            else{
                ans.append(Character.toLowerCase(ch));
            }
        }
        //convert to string
        return ans.toString();
    }
}

/*
*
pepCODinG
PEPcodINg
*
*
*/