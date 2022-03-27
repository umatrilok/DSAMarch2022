package BasicDataStructure.GenericTree;

import java.io.*;
        import java.util.*;

public class NodeToRootPathInGenericTrees {
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

    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        // write your code here
        System.out.println("("+node.data+")");
        if(node.data==data)
        {
            ArrayList<Integer> ba=new ArrayList<>();
            ba.add(data);
            return ba;

        }
        for(Node child:node.children)
        {
            ArrayList<Integer> ans = nodeToRootPath(child,data);
            if(ans.size()>0)
            {
                ans.add(node.data);
                return ans;
            }
        }
        return new ArrayList<>();//return empty arraylist if we do not reach: return ans
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        ArrayList<Integer> path = nodeToRootPath(root, data);
        System.out.println(path);
        // display(root);
    }
}

/**
 24
 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
 120
 (10)
 (20)
 (50)
 (60)
 (30)
 (70)
 (80)
 (110)
 (120)
 [120, 80, 30, 10]
 */
