package recursion.introductionToRecursion;

import java.util.Scanner;

public class Stack1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        printIncreasing(n);
    }
    public static void printIncreasing(int n)
    {
        if(n==1) {
            System.out.println(1);
            return;
        }
        if(n==0||n<0)
        {
            //System.out.println(1);
            return;
        }
        System.out.println(n);//our work is to print 6
        System.out.println(n-1);//our work is to print 5
        printIncreasing(n-2);//if n=6;faith:function will work for n=4,3,2,1
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
