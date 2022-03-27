package recursion.recursionOnTheWayUp;

import java.util.Scanner;

public class PrintMazePath {
    public static void main(String[] args) {

        Scanner sc =  new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        printMazePath(0,0,n-1,m-1,"");
    }
    public static void printMazePath(int sr,int sc,int dr,int dc,String psf)
    {
        if(sr==dr && sc==dc)
        {
            System.out.println(psf);
            return;
        }
        if(sr>dr||sc>dc)
        {
            return;
        }
        printMazePath(sr,sc+1,dr,dc,psf+"h");
        printMazePath(sr+1,sc,dr,dc,psf+"v");
    }
}
/*
3
3
hhvv
hvhv
hvvh
vhhv
vhvh
vvhh*/