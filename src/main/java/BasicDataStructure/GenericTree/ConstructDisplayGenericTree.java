package BasicDataStructure.GenericTree;
import java.io.*;
import java.util.*;

public class ConstructDisplayGenericTree {
    private static class Node {
        int data;
        ArrayList< Node> children = new ArrayList< >();
    }

    public static void display(Node root) {
       /*
       String str = root.data + " -> ";
        for (Node child : root.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : root.children) {
            display(child);
        }
        */


        String str = root.data + " -> ";
        for (int i=0;i<root.children.size();i++) {
            Node child =root.children.get(i);
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (int i=0;i<root.children.size();i++) {
            Node child = root.children.get(i);
            display(child);//child is becoming the root here
        }

    }


    public static int size(Node root) {
        int ans = 0;
        for (int i=0;i<root.children.size();i++) {
            Node child = root.children.get(i);
            ans = ans + size(child);//child is becoming the root here
        }
        return ans+1;
    }

    public static Node construct(int[] arr) {
        Node root = new Node();
        root.data=arr[0];
        Stack< Node> st = new Stack< >();
        st.push(root);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node n = new Node();
                n.data = arr[i];

                Node top=st.peek();
                top.children.add(n);
                st.push(n);
            }
        }

        return root;
    }

    public static int max(Node node)
    {
        int ans= Integer.MIN_VALUE;//Minus infinity
        for(int i=0;i<node.children.size();i++)
        {
            Node child =  node.children.get(i);
            int rec_max = max(child);
            ans=Math.max(rec_max,ans);
        }
        if(node.data > ans)
        {
            ans = node.data;
        }
        return ans;
    }

    public static int height(Node root) {
        int ans = 0;
        for (int i=0;i<root.children.size();i++) {
            Node child = root.children.get(i);
            int h =height(child);
            ans = Math.max(h,ans);//child is becoming the root here
        }
        //ans=ans+1;
        return ans+1;

        /*14
10 20 -1 30 50 70 -1 -1 60 80 -1 -1 -1 40 -1 -1
10 -> 20, 30, 40, .
20 -> .
30 -> 50, 60, .
50 -> 70, .
70 -> .
60 -> 80, .
80 -> .
40 -> .
size of the tree:8
max of the tree:80
height of the tree:4*/
    }

    public static void traversals(Node node){

        System.out.println("Node Pre )" + node.data);

        for(int i=0;i<node.children.size();i++)
        {
            Node child=node.children.get(i);
            System.out.println("Edge-Pre :"+node.data+"--"+child.data);
            traversals(child);
            System.out.println("          "+node.data+"--"+child.data+": Edge-Post ");
        }
        System.out.println("          "+node.data+"( Node Post ");
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        display(root);

        System.out.println("size of the tree:"+size(root));
        System.out.println("max of the tree:"+max(root));
        System.out.println("height of the tree:"+height(root));
        traversals(root);
    }
}
/*
* 12
10 20 -1 30 50 -1 60 -1 -1 40 -1 -1
10 -> 20, 30, 40, .
20 -> .
30 -> 50, 60, .
50 -> .
60 -> .
40 -> .*/