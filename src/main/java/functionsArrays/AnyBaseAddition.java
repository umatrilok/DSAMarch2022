package functionsArrays;

import java.util.Scanner;

public class AnyBaseAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int carry=0,pow=0,digit1,digit2,digit_sum,sum=0;
        int base=sc.nextInt();
        int num1=sc.nextInt();
        int num2=sc.nextInt();

        while(num1!=0||num2!=0)
        {
            digit1=num1%10;
            digit2=num2%10;
            num1=num1/10;
            num2=num2/10;
            digit_sum=digit1+digit2+carry;
            carry=0;
            System.out.print(digit_sum);
            if(digit_sum>=base)
            {
                carry=digit_sum/base;
                digit_sum=digit_sum%base;
                System.out.print("carry-->"+carry+"-->digit_sum-->"+digit_sum +"-->");
            }

            sum=sum+(digit_sum*(int)Math.pow(10,pow));


            System.out.print("-->sum-->"+sum +"\n");
            pow++;
        }
        if(num1==0&&num2==0)
            sum=sum+(carry*(int)Math.pow(10,pow));
        System.out.println(sum);
    }
}
