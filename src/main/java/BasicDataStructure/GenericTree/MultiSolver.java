package BasicDataStructure.GenericTree;

import sun.rmi.server.InactiveGroupException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class MultiSolver {
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

     static int size;
     static int sum;
     static int min;
     static int max;

     public static void multisolver(Node n)
     {//just tree traversal
         size+=1;
         sum+=n.data;

         min=Math.min(min,n.data);
         max=Math.max(max,n.data);
         for(Node child:n.children)
         {
             multisolver(child);
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
        size=0;
        sum=0;
        min= Integer.MAX_VALUE;
        max=0;
        multisolver(root1);
        System.out.println(size);
        System.out.println(sum);
        System.out.println(min);
        System.out.println(max);
    }

}