package BasicDataStructure.Stacks;

import java.io.*;

public class NormalStack {

    public static class CustomStack {
        int[] data;
        int tos;

        public CustomStack(int cap) {
            data = new int[cap];
            tos = -1;
        }

        int size() {
            // write ur code here
            return tos+1;
        }

        void display() {
            // write ur code here
            for(int i=0;i<=tos;i++)
            {
                System.out.println(data[i]);
            }
        }

        void push(int val) {
            // write ur code here
            if(tos<data.length-1) {
                tos++;
                data[tos] = val;
            }
            else
            {
                System.out.println("Stack overflow");
            }
        }

        int pop() {
            // write ur code here
            if(tos==-1)
            {
                System.out.println("Stack underflow");
                return 0;
            }
            else
            {
                int x=data[tos];
                tos--;
                return x;
            }
        }

        int top() {
            // write ur code here
            return data[tos];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomStack st = new CustomStack(n);

        String str = br.readLine();
        while(str.equals("quit") == false){
            if(str.startsWith("push")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if(str.startsWith("pop")){
                int val = st.pop();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("top")){
                int val = st.top();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("size")){
                System.out.println(st.size());
            } else if(str.startsWith("display")){
                st.display();
            }
            str = br.readLine();
        }
    }
}