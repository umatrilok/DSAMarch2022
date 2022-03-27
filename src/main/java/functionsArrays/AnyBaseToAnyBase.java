package functionsArrays;

import java.util.Scanner;

public class AnyBaseToAnyBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n=sc.nextInt();
        int b1=sc.nextInt();
        int b2=sc.nextInt();

        int num=anyBaseToDecimal(n,b1);
        System.out.println(decimalToAnyBase(num,b2));
    }
    public static int anyBaseToDecimal(int n,int b){
        int pow=0;
        int sum=0;
        int digit=0;
        while(n!=0)
        {
            digit=n%10;
            n=n/10;
            sum=sum+(digit*(int)Math.pow(b,pow));
            pow++;
        }
        return sum;
    }
    public static int decimalToAnyBase(int n,int b)
    {
        int display=1;
        int mul=1;
        int rem=1;
        int sum=0;
        while(n!=0)
        {
            rem=n%b;
            sum=sum+(rem*mul);
            mul=mul*10;
            n=n/b;

        }
        return sum;
    }
}
