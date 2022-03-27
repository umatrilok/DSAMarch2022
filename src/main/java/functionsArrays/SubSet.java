package functionsArrays;

import java.util.Scanner;

public class SubSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] a = new int[n];
        int p=0;
        while(p<n)
        {
            a[p]= sc.nextInt();
            p++;
        }
//int m;

        int total=(int)Math.pow(2,n);
        for(int i=0;i<total;i++)
        {
            int num=i;
            String ans="";
            for(int j=n-1;j>=0;j--) {
                int rem = num % 2;
                num = num / 2;//base2

                if (rem == 1) {
                    ans = a[j] + "\t" + ans;
                } else { 
                    ans = "-\t" + ans;
                }
            }

                    System.out.print(ans);

            System.out.println();
            }


        }

    }

