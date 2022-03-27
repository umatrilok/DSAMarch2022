package recursion.recursionWithArrayList;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GetStairPaths {
    public static void main(String[] args) {

        System.out.println(getStairPaths(0,4));

    }

    public static ArrayList<String> getStairPaths(int idx,int n)
    {
        if(idx==n)
        {
            ArrayList<String> ba =new ArrayList<>();
            ba.add("");
            return ba;//base ArrayList
        }
        if(idx>n)//when tree grows out of nth node
        {
            ArrayList<String > ba =new ArrayList<>();
            return ba;
        }
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<String> sans = getStairPaths(idx+1,n);

        for(int i=0;i<sans.size();i++)
        {
            String s=sans.get( i);
            String path="1"+s;
            ans.add(path);
        }

        ArrayList<String> sans2=getStairPaths(idx+2,n);

        for(int i=0;i<sans2.size();i++)
        {
            String s=sans2.get(i);
            String path="2"+s;
            ans.add(path);
        }

        ArrayList<String> sans3=getStairPaths(idx+3,n);

        for(int i=0;i<sans3.size();i++)
        {
            String s=sans3.get(i);
            String path="3"+s;
            ans.add(path);
        }

        return ans;
    }



}
