package BasicDataStructure.Stacks;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextGreaterElementOnLeftStockSpan {
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

        int[] nge = solve(a);
        display(nge);
    }

    public static int[] solve(int[] arr){
        // solve

        int n=arr.length;
        int[] ans= new int[n];

        Stack<Integer> st = new Stack<>();
        ans[0]=1;
        st.push(0);

        for(int i=1;i<n;i++)
        {
            int ele= arr[i];

            while(st.size()!=0 && ele>arr[st.peek()])
            {
                st.pop();
            }
            if(st.size()==0)
            {
                ans[i]=i+1;//for 15(very very highest element)
            }
            else
            {
                ans[i]=i - st.peek();
            }
        st.push(i);
        }
        return ans;
    }

}