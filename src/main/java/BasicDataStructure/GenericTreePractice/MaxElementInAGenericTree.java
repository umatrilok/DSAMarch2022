package BasicDataStructure.GenericTreePractice;
import java.io.*;
import java.util.*;
public class MaxElementInAGenericTree {
    private static class Node {
        int data;
        ArrayList< Node> children = new ArrayList< >();
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
        ans=Math.max(ans,node.data);

        return ans;
    }

    public static int size(Node node)
    {
        int ans= 0;//ans=0 everytime when i=0
        for(int i=0;i<node.children.size();i++)
        {
            Node child =  node.children.get(i);
            int rec_size = size(child);
            ans=ans+rec_size;
        }
        ans=ans+1;
        return ans;
    }

    public static int height(Node node)
    {
        int ans= 0;//ans=0 everytime when i=0
        for(int i=0;i<node.children.size();i++)
        {
            Node child =  node.children.get(i);
            int rec_height = height(child);
            ans=Math.max(ans,rec_height);
        }
        ans=ans+1;
        return ans;
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
       // display(root);

        //
        System.out.println("max of the tree:"+max(root));
        System.out.println("size of the tree:"+size(root));
        System.out.println("height of the tree:"+height(root));
        //traversals(root);
    }
}

