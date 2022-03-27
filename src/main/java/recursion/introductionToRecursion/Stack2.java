package recursion.introductionToRecursion;

import java.util.Scanner;

public class Stack2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        printIncreasing(n);
    }
    public static void printIncreasing(int n)
    {
        //if(n==0||n==-1||n==-2)
        if(n==0||n<0)
        {
            //System.out.println(1);
            return;
        }
        System.out.println(n);//our work is to print 6
        System.out.println(n-1);//our work is to print 5
        System.out.println(n-2);//our work is to print 4
        printIncreasing(n-3);//if n=6, faith: fn will work for n=3,2,1  (base case)
        System.out.println(n-2);//our work is to print 4
        System.out.println(n-1);//our work is to print 5
        System.out.println(n);//our work is to print 6

    }
}
/*
*
input: 6
output:
6
5
4
3
2
1
1
2
3
4
5
6
*/
