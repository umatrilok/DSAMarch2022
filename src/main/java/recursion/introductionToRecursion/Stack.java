package recursion.introductionToRecursion;

import java.util.Scanner;


        import java.util.Scanner;

public class Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        printIncreasing(n);
    }
    public static void printIncreasing(int n)
    {
        if(n==0)
        {
            //System.out.println(1);
            return;
        }
        System.out.println(n);//our work is to print 5 because it is left
        printIncreasing(n-1);//if n=5;faith->this line will work for base case, n=1,2,3,4
        System.out.println(n);//our work is to print 5
    }
}
