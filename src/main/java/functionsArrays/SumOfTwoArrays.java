package functionsArrays;

import java.util.Scanner;

public class SumOfTwoArrays {
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
        int m=0;
        if(n1>=n2)
            m=n1+1;
        else if(n2>=n1)
            m=n2+1;
        else
            m=n1+1;

        int[] outputArr= new int[m];

        int digit_sum=0,digit=0,carry=0;
        int digit1,digit2;
        for(int i=n1-1,j=n2-1,k=m-1;k>=0;i--,j--,k--)
        {
            if(i>=0)
              digit1=arr1[i];
            else
                digit1=0;

            if(j>=0)
                digit2=arr2[j];
            else
                digit2=0;

            digit_sum=digit1+digit2+carry;
            carry=0;
            if(digit_sum>=10)
            {
                digit_sum=digit_sum%10;
                carry=digit_sum/10;
            }
            outputArr[k]=digit_sum;
            //System.out.println(digit_sum);
        }
        //if()
        outputArr[0]=carry;


if(outputArr[0]!=0)
    System.out.println(outputArr[0]);

        for(int i=1;i<m;i++)
        {

                System.out.println(outputArr[i]);
        }
    }
}
