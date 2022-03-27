package BasicDataStructure.Stacks;

import java.io.*;
        import java.util.*;

public class FindCelebrity {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"

        int n= arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++)
        {
            st.push(i);
        }

        while(st.size()>1)
        {
            int a=st.pop();
            int b=st.pop();

            if(arr[a][b]==1)//a knows b
            {
                st.push(b);
            }
            else{
                st.push(a);
            }
        }
        int poss =  st.peek();
        for(int i=0;i<n;i++)
        {
            if(i==poss) continue;//knowing/not knowing self does not matter
            //every column should have 1 stored
            if(arr[i][poss]!=1)
            {
                System.out.println("none");
                return;
            }
            //every row should have 0 stored for poss to become celebrity
            if(arr[poss][i]!=0)
            {
                System.out.println("none");
                return;
            }
        }
        System.out.println(poss);
    }

}