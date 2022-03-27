package strings;

import java.io.*;
        import java.util.*;

public class RemovePrimes {

    public static void solution(ArrayList<Integer> pl){
        //this works//even if indexes changes and size shrinks,
        //array changes at the end, not at the starting
        //no memory impact
        //time will be saved
        for(int i=pl.size()-1;i>=0;i--)
        {
            int num=pl.get(i);
            System.out.print("Element:"+num+"-");
            if(isPrime(num)){
                pl.remove(i);
            }
            System.out.print("pl.size():"+pl.size()+"\n");
        }


    }

    public static boolean isPrime(int n)
    {
        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            al.add(scn.nextInt());
        }
        solution(al);
        System.out.println(al);//Array list is not returned
    }

}