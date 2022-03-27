package recursion.introductionToRecursion;

import java.util.Scanner;

public class PowerLog {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x= sc.nextInt();
        int n= sc.nextInt();
        System.out.println( power(x,n));

    }
    public static int power(int x, int n){
       if(n==0)
           return 1;
       int xpownby2= power(x,n/2);//x power n by 2
        int ans =xpownby2*xpownby2;
        if(n%2!=0){
            ans=ans*x;
        }
        System.out.println(ans);
       return  ans;
    }
}
/**
 * 2
 * 10
 * 1024
 */
