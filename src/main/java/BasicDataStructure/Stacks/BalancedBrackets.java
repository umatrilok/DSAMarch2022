package BasicDataStructure.Stacks;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args)throws Exception  {
        Scanner sc = new Scanner(System.in);
        String exp= sc.nextLine();
        System.out.println(isDup(exp));
    }
    public static boolean isDup(String exp)
    {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<exp.length();i++) {
            char ch = exp.charAt(i);
            //System.out.println(ch);
            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else if (ch == ')'||ch == '}'||ch == ']') {
               if(st.size()==0) return false;
               //this handels more closing brackets

               if(ch==')' && st.peek()!='(') return false;
               if(ch=='}' && st.peek()!='{') return false;
               if(ch==']' && st.peek()!='[') return false;
                //you get ) closing bracket and there is no open bracket for it, then you return false directly
                //[(a + b) + {(c + d) * (e / f)}])-->one opening bracket at the end

               st.pop();
            }


        }
        if(st.size()!=0)//this handels more opening brackets
        return false;
        //System.out.println(st.peek());

        return true;
    }
}
