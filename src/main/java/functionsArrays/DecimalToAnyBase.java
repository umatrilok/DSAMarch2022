package functionsArrays;
//1
import java.util.Scanner;

public class DecimalToAnyBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n=sc.nextInt(); int n1=n;
        int b=sc.nextInt(); int b1=b;

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
        System.out.println(sum);
//Other way of writing
        int rem1;
        int sum1=0;
        int pow=0;
        while(n1!=0)
        {
            rem1=n1%b1;//-->output base
            sum1=sum1+(rem1*(int)Math.pow(10,pow));//-->input base
            n1=n1/b1;//-->output base
            pow++;
        }
        System.out.println(sum1);
    }
}
