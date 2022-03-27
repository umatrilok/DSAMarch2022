package BasicDataStructure.GenericTree;

import java.io.*;
        import java.util.*;

public class DiameterOfAGenericTree {
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
public static int height(Node root)
{
    int h=-1;
    for(Node child:root.children)
    {
        h=Math.max(h,height(child));
    }
    return h+1;
}
public static int diameter(Node root)
{
    int mh=-1;//maximum height
    int smh=-1;//second maximum height
    int dia=-1;
    for(Node child:root.children)
    {
        int h=height(child);
        if(h>mh)
        {
            smh=mh;
            mh=h;
        }else if(h>smh)
        {
            smh=h;
        }
    }
    dia=mh+smh+2;
    for(int i=0;i<root.children.size();i++){
        Node child=root.children.get(i);
        System.out.println("i:"+i+" child:"+child.data);
        int rec_dia=diameter(child);
        dia=Math.max(dia,rec_dia);
        System.out.println("children-dia:"+dia);
    }
    System.out.println("root.data:"+root.data+" mh:"+mh+" smh:"+smh+" "+""+" dia:"+dia);
    return dia;
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
        // write your code here

        System.out.println(  diameter(root));
    }

}
/*
* 24
10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
5*/