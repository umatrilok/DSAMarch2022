package BasicDataStructure.Stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
public class MaxStack1 {
    public static class MaxStack {
        Stack< Integer> allData;
        Stack< Integer> maxData;

        public MaxStack() {
            allData = new Stack< >();
            maxData = new Stack< >();
        }

        int size() {
            return allData.size();
        }

        void push(int val) {
            allData.push(val);
            if (maxData.size() == 0 || val >= maxData.peek()) {
                maxData.push(val);
            } else
            {
                int top= maxData.peek();
                maxData.push(top);

            }

        }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = allData.pop();
               // if (val == maxData.peek()) {
                    maxData.pop();
               // }
                return val;
            }
        }

        int popmax2() {
            Stack< Integer> buffer = new Stack<>();

            int popmax;
            if (size() == 0) {
                System.out.println("Stack underflow");

                return -1;
            } else {
               popmax=maxData.peek();
              while(popmax!=allData.peek())
              {
                  buffer.push(allData.pop());
                  maxData.pop();
              }
              allData.pop();
              maxData.pop();
              while(buffer.size()>0)
              {
                  int bufferpop=buffer.pop();
                  allData.push(bufferpop);
                  int maxpeek=maxData.peek();
                  if(bufferpop>=maxpeek)
                  {
                      maxData.push(bufferpop);
                  }
                  else
                  {
                      maxData.push(maxpeek);
                  }
              }
            }
            return popmax;
        }
        int popmax1() {
            if (size() == 0) {
                System.out.println("Stack underflow");

                return -1;
            } else {

                int max_md = maxData.pop();

                int top_md;
                if(maxData.size()==0)
                    top_md=-1;
                else
                    top_md= maxData.peek();

                int top_ad = allData.peek();

                while(allData.peek()!=max_md)
                {
                    maxData.push(allData.pop());
                }
                allData.pop();

                boolean add_new_max=false;
                int save_new_max=0;

                while(maxData.peek()!=top_md)
                {
                    int can_be_new_max=maxData.pop();

                    if(can_be_new_max>top_md)
                    {
                        System.out.println("can_be_new_max:"+can_be_new_max);
                        add_new_max=true;
                        save_new_max=can_be_new_max;
                    }
                    allData.push(can_be_new_max);
                }

                if(add_new_max)
                maxData.push(save_new_max);

                return max_md;
            }
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return allData.peek();
            }
        }

        int peekmax() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return maxData.peek();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MaxStack st = new MaxStack();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("pmax1")) {
                int val = st.popmax1();
                if (val != -1) {
                    System.out.println(val);
                }
            }  else if (str.startsWith("popMax")) {
                int val = st.popmax2();
                if (val != -1) {
                    System.out.println(val);
                }
            }else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("max")) {
                int val = st.peekmax();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
}