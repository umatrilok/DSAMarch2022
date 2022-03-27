package BasicDataStructure.Stacks;

import java.io.*;
        import java.util.*;

public class NextSmallestOnRight_Wrong {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] span = solve(a);
        display(span);
    }

    public static int[] solve(int[] arr){

        int n=arr.length;
        int[] ans= new int[n];

        Stack<Integer> st = new Stack<>();
        ans[n-1]=-1;
        st.push(arr[n-1]);

        for(int i=1;i<n;i++)
        {
            int ele= arr[i];

            while(st.size()!=0 && ele>=st.peek())
            {
                st.pop();
            }
            if(st.size()==0)
            {
                ans[i]=-1;//for 15(very very highest element)
            }
            else
            {
                ans[i]=st.peek();
            }
            st.push(ele);
        }
        return ans;

    }

}
/*
5
        5  3  8  -2  7

        3  -2  -2 -1 -1

 */