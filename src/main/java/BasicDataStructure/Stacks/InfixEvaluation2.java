package BasicDataStructure.Stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixEvaluation2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Stack<Integer> opnds = new Stack<>();
        Stack<Character> optors = new Stack<>();
        for(int i=0;i<exp.length();i++)
        {
            char ch = exp.charAt(i);
            if(ch == '(')
            {
                optors.push(ch);
            }else if(Character.isDigit(ch))
            {
                opnds.push(ch-'0');//char to int
            }else if(ch == ')')
            {
                while(optors.peek()!='(')
                {
                   char optor = optors.pop();
                   int v2 = opnds.pop();
                   int v1 = opnds.pop();

                   int result = operation(v1,v2,optor);
                   opnds.push(result);
                }
                optors.pop();

            }else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
                //ch is wanting higher priority operators to solve first
                while(optors.size() > 0 && optors.peek() != '(' && precedence(ch)<=precedence(optors.peek()))
                {
                    char optor = optors.pop();
                    int v2 = opnds.pop();
                    int v1 = opnds.pop();

                    int result = operation(v1,v2,optor);
                    opnds.push(result);

                }
                // ch is pushing itself now
                optors.push(ch);

            }
        }
        //for remaining elements
        while(optors.size() != 0)
        {
            char optor = optors.pop();
            int v2 = opnds.pop();
            int v1 = opnds.pop();

            int result = operation(v1,v2,optor);
            opnds.push(result);
            System.out.println("v1:"+v1+" "+optor+" " +"v2:"+v2+" result:"+result);
        }

        System.out.println(opnds.peek());

    }
    public static int precedence(char optor)
    {
        if(optor=='+')
        {
            return 1;
        }else if(optor == '-')
        {
            return 1;
        }else if(optor=='*'){
            return 2;
        }else{
            return 2;
        }
    }
    public static int operation(int v1,int v2,char optor)
    {
        if(optor=='+')
        {
            return v1+v2;
        }else if(optor == '-')
        {
            return v1-v2;
        }else if(optor=='*'){
            return v1*v2;
        }else{
            return v1/v2;
        }
    }
}
