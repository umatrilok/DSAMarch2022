package BasicDataStructure.Stacks;

import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets {
    public static void main(String[] args)throws Exception  {
        Scanner sc = new Scanner(System.in);
        String exp= sc.nextLine();
        System.out.println(isDup(exp));
    }
    public static boolean isDup(String exp)
    {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<exp.length();i++)
        {
            char ch=exp.charAt(i);

            if(ch == ')')
            {
                if(st.peek()=='(') return  true;

                while(st.peek()!='(')
                {
                    st.pop();
                }
                st.pop();
            }else{
                st.push(ch);
            }
        }
        return false;
    }
}
/*
((a+b)+((c+d)))
true
*/