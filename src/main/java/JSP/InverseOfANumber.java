package JSP;

import java.util.Scanner;

public class InverseOfANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

      int num=number;
      int x=0;
      while(num>0)
      {
          num=num/10;
          x++;
      }

      int count=x;int isum=0;

      for(int place=1;place <=count;place++)
      {
          int digit =number%10;
          number = number/10;
          isum= isum + place*(int)Math.pow(10,digit-1);
      }
        System.out.println(isum);

    }
}
