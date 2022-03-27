package recursion.introductionToRecursion;

import java.util.Scanner;

public class PrintZigZag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();

        fun(n);
    }
    public static void fun(int n)
    {
        if(n==0)
            return;
        System.out.println("Pre"+n);

        fun(n-1);
        System.out.println("In"+n);

        fun(n-1);
        System.out.println("Post"+n);
    }
}
