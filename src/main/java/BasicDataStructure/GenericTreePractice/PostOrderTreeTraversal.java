package BasicDataStructure.GenericTreePractice;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
public class PostOrderTreeTraversal {
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

    public static void pre(Node node) {

        System.out.println(node.data+")");
        for(Node child:node.children)
        {
            pre(child);
        }
    }

    public static void post(Node node) {


        for(Node child:node.children)
        {
            post(child);
        }
        System.out.println("("+node.data);
    }

    public static void postWithForLoop(Node node) {


        for(Node child:node.children)
        {
            post(child);
        }
        for(int i=0;i<node.children.size();i++)
        System.out.println("("+node.data);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        //int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);
       //pre(root);
       post(root);
        //postWithForLoop(root);
    }

}
/*
* 24
10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
2
90*/