package recursion.recursionWithArrayList;

import org.apache.spark.sql.connector.read.Scan;

import java.util.ArrayList;
import java.util.Scanner;

public class GetKCP {
    static String[] arr={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str =  sc.nextLine();
        System.out.println(getKPC(str));

    }

    public static ArrayList<String> getKPC(String str)
    {
        //empty string
        if(str.length()==0)
        {
            ArrayList<String> ba = new ArrayList<>();
            ba.add("");
            return ba;
        }
        ArrayList<String>  sans = getKPC(str.substring(1));

        ArrayList<String>  ans = new ArrayList<>();

        char first_char = str.charAt(0);
        int idx=Integer.parseInt(first_char+"");

        String key=arr[idx];

        for(int i=0;i<key.length();i++)
        {
            char ch = key.charAt(i);
            for(int j=0;j<sans.size();j++)
            {
                String toAdd=ch+sans.get(j);
                ans.add(toAdd);
            }
        }
        return ans;
    }
}
/*78
[tv, tw, tx, uv, uw, ux]*/