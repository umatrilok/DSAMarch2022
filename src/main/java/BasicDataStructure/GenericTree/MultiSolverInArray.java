package BasicDataStructure.GenericTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class MultiSolverInArray {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static int size(Node node) {
        int s = 0;

        for (Node child : node.children) {
            s += size(child);
        }
        s += 1;

        return s;
    }

    public static int max(Node node) {
        int m = Integer.MIN_VALUE;

        for (Node child : node.children) {
            int cm = max(child);
            m = Math.max(m, cm);
        }
        m = Math.max(m, node.data);

        return m;
    }

    public static int height(Node node) {
        int h = -1;

        for (Node child : node.children) {
            int ch = height(child);
            h = Math.max(h, ch);
        }
        h += 1;

        return h;
    }

     public static void multisolverInArray(Node n,int[] ans)
     {//just tree traversal
         ans[0]+=1;
         ans[1]+=n.data;

         ans[2]=Math.min(ans[2],n.data);
         ans[3]=Math.max(ans[3],n.data);
         for(Node child:n.children)
         {
             multisolverInArray(child,ans);
         }
     }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n1];
        String[] values1 = br.readLine().split(" ");
        for (int i = 0; i < n1; i++) {
            arr1[i] = Integer.parseInt(values1[i]);
        }
        Node root1 = construct(arr1);

        //initialization
        int[] ans=new int[4];
        ans[0]=0;//size
        ans[1]=0;//sum
        ans[2]= Integer.MAX_VALUE;//min
        ans[3]= Integer.MIN_VALUE;//max
        multisolverInArray(root1,ans);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
        System.out.println(ans[2]);
        System.out.println(ans[3]);
    }

}