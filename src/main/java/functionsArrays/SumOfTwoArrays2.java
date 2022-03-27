package functionsArrays;

import java.util.Scanner;

public class SumOfTwoArrays2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1= sc.nextInt();
        int[] arr1=new int[n1];

        for(int i=0;i<n1;i++)
        {
            arr1[i]=sc.nextInt();
        }
        //System.out.println("enter 2");
        int n2= sc.nextInt();
        int[] arr2=new int[n2];

        for(int i=0;i<n2;i++)
        {
            arr2[i]=sc.nextInt();
        }
        //System.out.println("done");
        int m=Math.max(n1,n2);

        int[] outputArr= new int[m+1];

        int carry=0;
        int digit1,digit2;

        int i=n1-1;
        int j=n2-1;
        int k=m;
       while(k>=0)
        {
            int digit_sum=0;

            if(i>=0)
                digit_sum=digit_sum+arr1[i];

            if(j>=0)
                digit_sum=digit_sum+arr2[j];


            digit_sum=digit_sum+carry;

            int digit=digit_sum%10;
            carry=digit_sum/10;
            outputArr[k]=digit;
            //System.out.println(k);
            i--;
            j--;
            k--;


        }
        //if()
        outputArr[0]=carry;


    if(outputArr[0]!=0)
    System.out.println(outputArr[0]);

        for(int p=1;p<=m;p++)
        {

                System.out.println(outputArr[p]);
        }
    }
}
