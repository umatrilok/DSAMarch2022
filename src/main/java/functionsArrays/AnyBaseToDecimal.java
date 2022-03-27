package functionsArrays;

import java.util.Scanner;
//2
public class AnyBaseToDecimal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int pow=0;
        int sum=0;
        int digit=0;
        while(n!=0)
        {
            digit=n%10;//-->output base
            n=n/10;//-->output base
            sum=sum+(digit*(int)Math.pow(b,pow));//-->input base
            pow++;
        }
        System.out.println(sum);
    }
}
