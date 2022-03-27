package BasicDataStructure.Stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostFixEvaluationConversion {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Stack<Integer> post_opnds_i = new Stack<>();
        Stack<String> post_opnds = new Stack<>();
        Stack<Character> optors = new Stack<>();
        for(int i=0;i<exp.length();i++)
        {
            char ch = exp.charAt(i);
            if(ch == '(')
            {
                optors.push(ch);
            }else if((ch>='0'&&ch<='9')||(ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z'))
            {
                post_opnds_i.push(ch-'0');
                post_opnds.push(ch+"");
            }else if(ch == ')')
            {
                while(optors.peek()!='(')
                {
                    char optor = optors.pop();
                    int post_v2_i = post_opnds_i.pop();
                    int post_v1_i = post_opnds_i.pop();

                    String post_v2 = post_opnds.pop();
                    String post_v1 = post_opnds.pop();

                    int post_result_i = operation(post_v1_i,post_v2_i,optor);
                    String post_result = post_v1+optor+post_v2;

                    post_opnds_i.push(post_result_i);
                    post_opnds.push(post_result);
                }
                optors.pop();

            }else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
                //ch is wanting higher priority operators to solve first
                while(optors.size() > 0 && optors.peek() != '(' && precedence(ch)<=precedence(optors.peek()))
                {
                    char optor = optors.pop();
                    int post_v2_i = post_opnds_i.pop();
                    int post_v1_i = post_opnds_i.pop();

                    String post_v2 = post_opnds.pop();
                    String post_v1 = post_opnds.pop();

                    int post_result_i = operation(post_v1_i,post_v2_i,optor);
                    String post_result = post_v1+optor+post_v2;

                    post_opnds_i.push(post_result_i);
                    post_opnds.push(post_result);
                }
                // ch is pushing itself now
                optors.push(ch);

            }
        }
        //for remaining elements
        while(optors.size() != 0)
        {
            char optor = optors.pop();
            int post_v2_i = post_opnds_i.pop();
            int post_v1_i = post_opnds_i.pop();

            String post_v2 = post_opnds.pop();
            String post_v1 = post_opnds.pop();

            int post_result_i = operation(post_v1_i,post_v2_i,optor);
            String post_result = post_v1+optor+post_v2;

            post_opnds_i.push(post_result_i);
            post_opnds.push(post_result);
            //System.out.println("v1:"+v1+" "+optor+" " +"v2:"+v2+" result:"+result);
        }

        System.out.println(post_opnds_i.peek());
        System.out.println(post_opnds.peek());

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
