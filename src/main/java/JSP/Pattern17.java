package JSP;
import java.util.Scanner;
public class Pattern17 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n=sc.nextInt();
        int spaces=n/2;int stars=1;
        int beforecenterstars=1;
        int beforecenterspaces=1;

        boolean cnter =false;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=spaces;j++)
                System.out.print("\t");
            for(int j=1;j<=stars;j++)
                System.out.print("*\t");

            System.out.println();



            if(i==n/2)//center
            {
                beforecenterspaces=spaces;
                spaces=0;
                beforecenterstars=stars;
                stars=n;
                //System.out.println(i+"center");
                cnter=true;
            } else if(i<n/2 +1)//top of center
            {
                stars++;
                //cnter=true;
                //System.out.println(i+"top of center");
            }
            else if(i>n/2)//bottom of center
            {
                if(cnter) {
                    stars = beforecenterstars;
                    spaces = beforecenterspaces;
                    cnter=false;
                  //  System.out.println("beforecenterstars"+beforecenterstars);
                }
                else
                    stars--;
                //System.out.println(i+"bottom of center");
            }

        }
    }
}
