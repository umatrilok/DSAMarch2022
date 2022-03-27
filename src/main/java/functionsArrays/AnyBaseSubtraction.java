package functionsArrays;

import java.util.Scanner;

public class AnyBaseSubtraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int base=sc.nextInt();
        int num1=sc.nextInt();
        int num2=sc.nextInt();

        int digit1,digit2;
        int before_digit=0;
        int digit_sub=0;

        int f_sum=0;
        int pow=0;

        while(num1!=0||num2!=0)
        {
            digit1=num1%10;
            digit2=num2%10;
            num1=num1/10;
            num2=num2/10;
            digit2=digit2+before_digit;
            before_digit=0;

            if(digit2<digit1)
            {
                before_digit--;
                digit2=digit2+base;
            }
            digit_sub=digit2-digit1;

            //System.out.println(digit_sub);
            f_sum=f_sum+(digit_sub*(int)Math.pow(10,pow));
            pow++;

        }
        System.out.println(f_sum);
        //if(num1==0&&num2==0)
            //sum=sum+(carry*(int)Math.pow(10,pow));
        //System.out.println(digit_sub);
    }
}
