package recursion.recursionOnTheWayUp;

import java.util.Scanner;

public class PrintStairPath {
    public static void main(String[] args) {

        Scanner sc =  new Scanner(System.in);
        int n=sc.nextInt();
        printStairPaths(0,n,"");
    }
    public static void printStairPaths(int idx,int n,String path)
    {
        if(idx>n)
        {
            return;
        }
        if(idx==n)
        {
            System.out.println(path);
            return;
        }
        printStairPaths(idx+1,n,path+"1");
        printStairPaths(idx+2,n,path+"2");
        printStairPaths(idx+3,n,path+"3");
    }


}
/*
4
1111
112
121
13
211
22
31*/
