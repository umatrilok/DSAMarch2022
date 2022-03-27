package dp;

import java.util.Scanner;

public class CatalanMountains {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int dp[] = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<dp.length;i++)
        {
            int inside = i-1;
            int outside = i-inside-1;

            while(inside>=0)
            {
                System.out.println("inside-->"+inside+" outside-->"+outside);
                dp[i]+=dp[outside]*dp[inside];

                inside--;
                outside++;
            }
            System.out.println("i"+i+"-->"+dp[i]);
        }

    }
}
