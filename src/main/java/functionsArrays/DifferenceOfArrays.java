package functionsArrays;

import java.util.Scanner;

public class DifferenceOfArrays {
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

        int[] outputArr= new int[n2];

        int borrow=0;
        int digit1,digit2;

        int i=n2-1;
        int j=n1-1;
        int k=n2-1;
       while(k>=0)
        {
            int diff=arr2[i]-borrow;
            if(j>=0)
                diff=diff-arr1[j];

            if(diff<0) {
                diff = diff + 10;
                borrow = 1;
            }else{
                borrow=0;
            }

            outputArr[k]=diff;

            i--;
            j--;
            k--;

        }


    if(outputArr[0]!=0)
    System.out.println(outputArr[0]);

        for(int p=1;p<n2;p++)
        {
                System.out.println(outputArr[p]);
        }
    }
}
