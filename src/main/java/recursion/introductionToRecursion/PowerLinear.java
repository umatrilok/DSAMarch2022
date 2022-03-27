package recursion.introductionToRecursion;

import java.util.Scanner;

public class PowerLinear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x= sc.nextInt();
        int n= sc.nextInt();
        System.out.println( power(x,n));

    }
    public static int power(int x, int n){
        if(n==0)
            return 1;
        int xpownb2= power(x,n-1);//x power n by 2
        int ans =x*xpownb2;

        return  ans;
    }
}
